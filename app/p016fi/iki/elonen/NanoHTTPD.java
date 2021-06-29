package p016fi.iki.elonen;

import android.support.p000v4.media.session.PlaybackStateCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.unity3d.ads.metadata.MediationMetaData;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import p017io.fabric.sdk.android.services.network.HttpRequest;
import p017io.fabric.sdk.android.services.network.UrlUtils;

/* renamed from: fi.iki.elonen.NanoHTTPD */
public abstract class NanoHTTPD {
    /* access modifiers changed from: private */
    public static final Pattern BOUNDARY_PATTERN = Pattern.compile(BOUNDARY_REGEX, 2);
    private static final String BOUNDARY_REGEX = "[ |\t]*(boundary)[ |\t]*=[ |\t]*['|\"]?([^\"^'^;]*)['|\"]?";
    /* access modifiers changed from: private */
    public static final Pattern CHARSET_PATTERN = Pattern.compile(CHARSET_REGEX, 2);
    private static final String CHARSET_REGEX = "[ |\t]*(charset)[ |\t]*=[ |\t]*['|\"]?([^\"^'^;]*)['|\"]?";
    /* access modifiers changed from: private */
    public static final Pattern CONTENT_DISPOSITION_ATTRIBUTE_PATTERN = Pattern.compile(CONTENT_DISPOSITION_ATTRIBUTE_REGEX);
    private static final String CONTENT_DISPOSITION_ATTRIBUTE_REGEX = "[ |\t]*([a-zA-Z]*)[ |\t]*=[ |\t]*['|\"]([^\"^']*)['|\"]";
    /* access modifiers changed from: private */
    public static final Pattern CONTENT_DISPOSITION_PATTERN = Pattern.compile(CONTENT_DISPOSITION_REGEX, 2);
    private static final String CONTENT_DISPOSITION_REGEX = "([ |\t]*Content-Disposition[ |\t]*:)(.*)";
    /* access modifiers changed from: private */
    public static final Pattern CONTENT_TYPE_PATTERN = Pattern.compile(CONTENT_TYPE_REGEX, 2);
    private static final String CONTENT_TYPE_REGEX = "([ |\t]*content-type[ |\t]*:)(.*)";
    /* access modifiers changed from: private */
    public static final Logger LOG = Logger.getLogger(NanoHTTPD.class.getName());
    public static final String MIME_HTML = "text/html";
    public static final String MIME_PLAINTEXT = "text/plain";
    protected static Map<String, String> MIME_TYPES = null;
    private static final String QUERY_STRING_PARAMETER = "NanoHttpd.QUERY_STRING";
    public static final int SOCKET_READ_TIMEOUT = 5000;
    protected AsyncRunner asyncRunner;
    /* access modifiers changed from: private */
    public final String hostname;
    /* access modifiers changed from: private */
    public final int myPort;
    /* access modifiers changed from: private */
    public volatile ServerSocket myServerSocket;
    private Thread myThread;
    private ServerSocketFactory serverSocketFactory;
    /* access modifiers changed from: private */
    public TempFileManagerFactory tempFileManagerFactory;

    /* renamed from: fi.iki.elonen.NanoHTTPD$AsyncRunner */
    public interface AsyncRunner {
        void closeAll();

        void closed(ClientHandler clientHandler);

        void exec(ClientHandler clientHandler);
    }

    /* renamed from: fi.iki.elonen.NanoHTTPD$ClientHandler */
    public class ClientHandler implements Runnable {
        private final Socket acceptSocket;
        private final InputStream inputStream;

        private ClientHandler(InputStream inputStream2, Socket socket) {
            this.inputStream = inputStream2;
            this.acceptSocket = socket;
        }

        public void close() {
            NanoHTTPD.safeClose(this.inputStream);
            NanoHTTPD.safeClose(this.acceptSocket);
        }

        public void run() {
            OutputStream outputStream;
            Exception e;
            try {
                outputStream = this.acceptSocket.getOutputStream();
                try {
                    HTTPSession hTTPSession = new HTTPSession(NanoHTTPD.this.tempFileManagerFactory.create(), this.inputStream, outputStream, this.acceptSocket.getInetAddress());
                    while (!this.acceptSocket.isClosed()) {
                        hTTPSession.execute();
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        if ((!(e instanceof SocketException) || !"NanoHttpd Shutdown".equals(e.getMessage())) && !(e instanceof SocketTimeoutException)) {
                            NanoHTTPD.LOG.log(Level.FINE, "Communication with the client broken", e);
                        }
                        NanoHTTPD.safeClose(outputStream);
                        NanoHTTPD.safeClose(this.inputStream);
                        NanoHTTPD.safeClose(this.acceptSocket);
                        NanoHTTPD.this.asyncRunner.closed(this);
                    } catch (Throwable th) {
                        th = th;
                        NanoHTTPD.safeClose(outputStream);
                        NanoHTTPD.safeClose(this.inputStream);
                        NanoHTTPD.safeClose(this.acceptSocket);
                        NanoHTTPD.this.asyncRunner.closed(this);
                        throw th;
                    }
                }
            } catch (Exception e3) {
                Exception exc = e3;
                outputStream = null;
                e = exc;
                NanoHTTPD.LOG.log(Level.FINE, "Communication with the client broken", e);
                NanoHTTPD.safeClose(outputStream);
                NanoHTTPD.safeClose(this.inputStream);
                NanoHTTPD.safeClose(this.acceptSocket);
                NanoHTTPD.this.asyncRunner.closed(this);
            } catch (Throwable th2) {
                Throwable th3 = th2;
                outputStream = null;
                th = th3;
                NanoHTTPD.safeClose(outputStream);
                NanoHTTPD.safeClose(this.inputStream);
                NanoHTTPD.safeClose(this.acceptSocket);
                NanoHTTPD.this.asyncRunner.closed(this);
                throw th;
            }
            NanoHTTPD.safeClose(outputStream);
            NanoHTTPD.safeClose(this.inputStream);
            NanoHTTPD.safeClose(this.acceptSocket);
            NanoHTTPD.this.asyncRunner.closed(this);
        }
    }

    /* renamed from: fi.iki.elonen.NanoHTTPD$Cookie */
    public static class Cookie {

        /* renamed from: e */
        private final String f1401e;

        /* renamed from: n */
        private final String f1402n;

        /* renamed from: v */
        private final String f1403v;

        public Cookie(String str, String str2) {
            this(str, str2, 30);
        }

        public Cookie(String str, String str2, int i) {
            this.f1402n = str;
            this.f1403v = str2;
            this.f1401e = getHTTPTime(i);
        }

        public Cookie(String str, String str2, String str3) {
            this.f1402n = str;
            this.f1403v = str2;
            this.f1401e = str3;
        }

        public static String getHTTPTime(int i) {
            Calendar instance = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            instance.add(5, i);
            return simpleDateFormat.format(instance.getTime());
        }

        public String getHTTPHeader() {
            return String.format("%s=%s; expires=%s", new Object[]{this.f1402n, this.f1403v, this.f1401e});
        }
    }

    /* renamed from: fi.iki.elonen.NanoHTTPD$CookieHandler */
    public class CookieHandler implements Iterable<String> {
        private final HashMap<String, String> cookies = new HashMap<>();
        private final ArrayList<Cookie> queue = new ArrayList<>();

        public CookieHandler(Map<String, String> map) {
            String str = map.get("cookie");
            if (str != null) {
                for (String trim : str.split(";")) {
                    String[] split = trim.trim().split("=");
                    if (split.length == 2) {
                        this.cookies.put(split[0], split[1]);
                    }
                }
            }
        }

        public void delete(String str) {
            set(str, "-delete-", -30);
        }

        public Iterator<String> iterator() {
            return this.cookies.keySet().iterator();
        }

        public String read(String str) {
            return this.cookies.get(str);
        }

        public void set(Cookie cookie) {
            this.queue.add(cookie);
        }

        public void set(String str, String str2, int i) {
            this.queue.add(new Cookie(str, str2, Cookie.getHTTPTime(i)));
        }

        public void unloadQueue(Response response) {
            Iterator<Cookie> it = this.queue.iterator();
            while (it.hasNext()) {
                response.addHeader("Set-Cookie", it.next().getHTTPHeader());
            }
        }
    }

    /* renamed from: fi.iki.elonen.NanoHTTPD$DefaultAsyncRunner */
    public static class DefaultAsyncRunner implements AsyncRunner {
        private long requestCount;
        private final List<ClientHandler> running = Collections.synchronizedList(new ArrayList());

        public void closeAll() {
            Iterator it = new ArrayList(this.running).iterator();
            while (it.hasNext()) {
                ((ClientHandler) it.next()).close();
            }
        }

        public void closed(ClientHandler clientHandler) {
            this.running.remove(clientHandler);
        }

        public void exec(ClientHandler clientHandler) {
            this.requestCount++;
            Thread thread = new Thread(clientHandler);
            thread.setDaemon(true);
            thread.setName("NanoHttpd Request Processor (#" + this.requestCount + ")");
            this.running.add(clientHandler);
            thread.start();
        }

        public List<ClientHandler> getRunning() {
            return this.running;
        }
    }

    /* renamed from: fi.iki.elonen.NanoHTTPD$DefaultServerSocketFactory */
    public static class DefaultServerSocketFactory implements ServerSocketFactory {
        public ServerSocket create() throws IOException {
            return new ServerSocket();
        }
    }

    /* renamed from: fi.iki.elonen.NanoHTTPD$DefaultTempFile */
    public static class DefaultTempFile implements TempFile {
        private final File file;
        private final OutputStream fstream = new FileOutputStream(this.file);

        public DefaultTempFile(File file2) throws IOException {
            this.file = File.createTempFile("NanoHTTPD-", "", file2);
        }

        public void delete() throws Exception {
            NanoHTTPD.safeClose(this.fstream);
            if (!this.file.delete()) {
                throw new Exception("could not delete temporary file");
            }
        }

        public String getName() {
            return this.file.getAbsolutePath();
        }

        public OutputStream open() throws Exception {
            return this.fstream;
        }
    }

    /* renamed from: fi.iki.elonen.NanoHTTPD$DefaultTempFileManager */
    public static class DefaultTempFileManager implements TempFileManager {
        private final List<TempFile> tempFiles;
        private final File tmpdir = new File(System.getProperty("java.io.tmpdir"));

        public DefaultTempFileManager() {
            if (!this.tmpdir.exists()) {
                this.tmpdir.mkdirs();
            }
            this.tempFiles = new ArrayList();
        }

        public void clear() {
            for (TempFile delete : this.tempFiles) {
                try {
                    delete.delete();
                } catch (Exception e) {
                    NanoHTTPD.LOG.log(Level.WARNING, "could not delete file ", e);
                }
            }
            this.tempFiles.clear();
        }

        public TempFile createTempFile(String str) throws Exception {
            DefaultTempFile defaultTempFile = new DefaultTempFile(this.tmpdir);
            this.tempFiles.add(defaultTempFile);
            return defaultTempFile;
        }
    }

    /* renamed from: fi.iki.elonen.NanoHTTPD$DefaultTempFileManagerFactory */
    private class DefaultTempFileManagerFactory implements TempFileManagerFactory {
        private DefaultTempFileManagerFactory() {
        }

        public TempFileManager create() {
            return new DefaultTempFileManager();
        }
    }

    /* renamed from: fi.iki.elonen.NanoHTTPD$HTTPSession */
    protected class HTTPSession implements IHTTPSession {
        public static final int BUFSIZE = 8192;
        public static final int MAX_HEADER_SIZE = 1024;
        private static final int MEMORY_STORE_LIMIT = 1024;
        private static final int REQUEST_BUFFER_LEN = 512;
        private CookieHandler cookies;
        private Map<String, String> headers;
        private final BufferedInputStream inputStream;
        private Method method;
        private final OutputStream outputStream;
        private Map<String, String> parms;
        private String protocolVersion;
        private String queryParameterString;
        private String remoteIp;
        private int rlen;
        private int splitbyte;
        private final TempFileManager tempFileManager;
        private String uri;

        public HTTPSession(TempFileManager tempFileManager2, InputStream inputStream2, OutputStream outputStream2) {
            this.tempFileManager = tempFileManager2;
            this.inputStream = new BufferedInputStream(inputStream2, 8192);
            this.outputStream = outputStream2;
        }

        public HTTPSession(TempFileManager tempFileManager2, InputStream inputStream2, OutputStream outputStream2, InetAddress inetAddress) {
            this.tempFileManager = tempFileManager2;
            this.inputStream = new BufferedInputStream(inputStream2, 8192);
            this.outputStream = outputStream2;
            this.remoteIp = (inetAddress.isLoopbackAddress() || inetAddress.isAnyLocalAddress()) ? "127.0.0.1" : inetAddress.getHostAddress().toString();
            this.headers = new HashMap();
        }

        private void decodeHeader(BufferedReader bufferedReader, Map<String, String> map, Map<String, String> map2, Map<String, String> map3) throws ResponseException {
            String str;
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    StringTokenizer stringTokenizer = new StringTokenizer(readLine);
                    if (stringTokenizer.hasMoreTokens()) {
                        map.put(FirebaseAnalytics.Param.METHOD, stringTokenizer.nextToken());
                        if (stringTokenizer.hasMoreTokens()) {
                            String nextToken = stringTokenizer.nextToken();
                            int indexOf = nextToken.indexOf(63);
                            if (indexOf >= 0) {
                                decodeParms(nextToken.substring(indexOf + 1), map2);
                                str = NanoHTTPD.decodePercent(nextToken.substring(0, indexOf));
                            } else {
                                str = NanoHTTPD.decodePercent(nextToken);
                            }
                            if (stringTokenizer.hasMoreTokens()) {
                                this.protocolVersion = stringTokenizer.nextToken();
                            } else {
                                this.protocolVersion = "HTTP/1.1";
                                NanoHTTPD.LOG.log(Level.FINE, "no protocol version specified, strange. Assuming HTTP/1.1.");
                            }
                            String readLine2 = bufferedReader.readLine();
                            while (readLine2 != null && readLine2.trim().length() > 0) {
                                int indexOf2 = readLine2.indexOf(58);
                                if (indexOf2 >= 0) {
                                    map3.put(readLine2.substring(0, indexOf2).trim().toLowerCase(Locale.US), readLine2.substring(indexOf2 + 1).trim());
                                }
                                readLine2 = bufferedReader.readLine();
                            }
                            map.put("uri", str);
                            return;
                        }
                        throw new ResponseException(Response.Status.BAD_REQUEST, "BAD REQUEST: Missing URI. Usage: GET /example/file.html");
                    }
                    throw new ResponseException(Response.Status.BAD_REQUEST, "BAD REQUEST: Syntax error. Usage: GET /example/file.html");
                }
            } catch (IOException e) {
                Response.Status status = Response.Status.INTERNAL_ERROR;
                throw new ResponseException(status, "SERVER INTERNAL ERROR: IOException: " + e.getMessage(), e);
            }
        }

        private void decodeMultipartFormData(String str, String str2, ByteBuffer byteBuffer, Map<String, String> map, Map<String, String> map2) throws ResponseException {
            ByteBuffer byteBuffer2 = byteBuffer;
            Map<String, String> map3 = map;
            Map<String, String> map4 = map2;
            try {
                int[] boundaryPositions = getBoundaryPositions(byteBuffer2, str.getBytes());
                int i = 2;
                if (boundaryPositions.length >= 2) {
                    int i2 = 1024;
                    byte[] bArr = new byte[1024];
                    int i3 = 0;
                    int i4 = 0;
                    while (i4 < boundaryPositions.length - 1) {
                        byteBuffer2.position(boundaryPositions[i4]);
                        int remaining = byteBuffer.remaining() < i2 ? byteBuffer.remaining() : 1024;
                        byteBuffer2.get(bArr, i3, remaining);
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArr, i3, remaining), Charset.forName(str2)), remaining);
                        if (bufferedReader.readLine().contains(str)) {
                            String readLine = bufferedReader.readLine();
                            String str3 = null;
                            String str4 = null;
                            String str5 = null;
                            int i5 = 2;
                            while (readLine != null && readLine.trim().length() > 0) {
                                Matcher matcher = NanoHTTPD.CONTENT_DISPOSITION_PATTERN.matcher(readLine);
                                if (matcher.matches()) {
                                    Matcher matcher2 = NanoHTTPD.CONTENT_DISPOSITION_ATTRIBUTE_PATTERN.matcher(matcher.group(i));
                                    while (matcher2.find()) {
                                        String str6 = str3;
                                        String group = matcher2.group(1);
                                        if (group.equalsIgnoreCase(MediationMetaData.KEY_NAME)) {
                                            str4 = matcher2.group(2);
                                        } else if (group.equalsIgnoreCase(FFmpegMediaMetadataRetriever.METADATA_KEY_FILENAME)) {
                                            str3 = matcher2.group(2);
                                        }
                                        str3 = str6;
                                    }
                                    String str7 = str3;
                                }
                                Matcher matcher3 = NanoHTTPD.CONTENT_TYPE_PATTERN.matcher(readLine);
                                if (matcher3.matches()) {
                                    str5 = matcher3.group(2).trim();
                                }
                                readLine = bufferedReader.readLine();
                                i5++;
                                i = 2;
                            }
                            int i6 = 0;
                            while (true) {
                                int i7 = i5 - 1;
                                if (i5 <= 0) {
                                    break;
                                }
                                i6 = scipOverNewLine(bArr, i6);
                                i5 = i7;
                            }
                            if (i6 < remaining - 4) {
                                int i8 = boundaryPositions[i4] + i6;
                                i4++;
                                int i9 = boundaryPositions[i4] - 4;
                                byteBuffer2.position(i8);
                                if (str5 == null) {
                                    byte[] bArr2 = new byte[(i9 - i8)];
                                    byteBuffer2.get(bArr2);
                                    map3.put(str4, new String(bArr2, str2));
                                } else {
                                    String str8 = str2;
                                    String saveTmpFile = saveTmpFile(byteBuffer2, i8, i9 - i8, str3);
                                    if (!map4.containsKey(str4)) {
                                        map4.put(str4, saveTmpFile);
                                    } else {
                                        int i10 = 2;
                                        while (true) {
                                            if (!map4.containsKey(str4 + i10)) {
                                                break;
                                            }
                                            i10++;
                                        }
                                        map4.put(str4 + i10, saveTmpFile);
                                    }
                                    map3.put(str4, str3);
                                }
                                i2 = 1024;
                                i = 2;
                                i3 = 0;
                            } else {
                                throw new ResponseException(Response.Status.INTERNAL_ERROR, "Multipart header size exceeds MAX_HEADER_SIZE.");
                            }
                        } else {
                            throw new ResponseException(Response.Status.BAD_REQUEST, "BAD REQUEST: Content type is multipart/form-data but chunk does not start with boundary.");
                        }
                    }
                    return;
                }
                throw new ResponseException(Response.Status.BAD_REQUEST, "BAD REQUEST: Content type is multipart/form-data but contains less than two boundary strings.");
            } catch (ResponseException e) {
                throw e;
            } catch (Exception e2) {
                throw new ResponseException(Response.Status.INTERNAL_ERROR, e2.toString());
            }
        }

        private void decodeParms(String str, Map<String, String> map) {
            if (str == null) {
                this.queryParameterString = "";
                return;
            }
            this.queryParameterString = str;
            StringTokenizer stringTokenizer = new StringTokenizer(str, "&");
            while (stringTokenizer.hasMoreTokens()) {
                String nextToken = stringTokenizer.nextToken();
                int indexOf = nextToken.indexOf(61);
                if (indexOf >= 0) {
                    map.put(NanoHTTPD.decodePercent(nextToken.substring(0, indexOf)).trim(), NanoHTTPD.decodePercent(nextToken.substring(indexOf + 1)));
                } else {
                    map.put(NanoHTTPD.decodePercent(nextToken).trim(), "");
                }
            }
        }

        private int findHeaderEnd(byte[] bArr, int i) {
            int i2;
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                if (i4 >= i) {
                    return 0;
                }
                if (bArr[i3] == 13 && bArr[i4] == 10 && (i2 = i3 + 3) < i && bArr[i3 + 2] == 13 && bArr[i2] == 10) {
                    return i3 + 4;
                }
                if (bArr[i3] == 10 && bArr[i4] == 10) {
                    return i3 + 2;
                }
                i3 = i4;
            }
        }

        private String getAttributeFromContentHeader(String str, Pattern pattern, String str2) {
            Matcher matcher = pattern.matcher(str);
            return matcher.find() ? matcher.group(2) : str2;
        }

        private int[] getBoundaryPositions(ByteBuffer byteBuffer, byte[] bArr) {
            int[] iArr = new int[0];
            if (byteBuffer.remaining() < bArr.length) {
                return iArr;
            }
            byte[] bArr2 = new byte[(bArr.length + 4096)];
            int remaining = byteBuffer.remaining() < bArr2.length ? byteBuffer.remaining() : bArr2.length;
            byteBuffer.get(bArr2, 0, remaining);
            int length = remaining - bArr.length;
            int[] iArr2 = iArr;
            int i = 0;
            while (true) {
                int[] iArr3 = iArr2;
                int i2 = 0;
                while (i2 < length) {
                    int[] iArr4 = iArr3;
                    int i3 = 0;
                    while (i3 < bArr.length && bArr2[i2 + i3] == bArr[i3]) {
                        if (i3 == bArr.length - 1) {
                            int[] iArr5 = new int[(iArr4.length + 1)];
                            System.arraycopy(iArr4, 0, iArr5, 0, iArr4.length);
                            iArr5[iArr4.length] = i + i2;
                            iArr4 = iArr5;
                        }
                        i3++;
                    }
                    i2++;
                    iArr3 = iArr4;
                }
                i += length;
                System.arraycopy(bArr2, bArr2.length - bArr.length, bArr2, 0, bArr.length);
                length = bArr2.length - bArr.length;
                if (byteBuffer.remaining() < length) {
                    length = byteBuffer.remaining();
                }
                byteBuffer.get(bArr2, bArr.length, length);
                if (length <= 0) {
                    return iArr3;
                }
                iArr2 = iArr3;
            }
        }

        private RandomAccessFile getTmpBucket() {
            try {
                return new RandomAccessFile(this.tempFileManager.createTempFile((String) null).getName(), "rw");
            } catch (Exception e) {
                throw new Error(e);
            }
        }

        private String saveTmpFile(ByteBuffer byteBuffer, int i, int i2, String str) {
            String str2 = "";
            if (i2 > 0) {
                FileOutputStream fileOutputStream = null;
                try {
                    TempFile createTempFile = this.tempFileManager.createTempFile(str);
                    ByteBuffer duplicate = byteBuffer.duplicate();
                    FileOutputStream fileOutputStream2 = new FileOutputStream(createTempFile.getName());
                    try {
                        FileChannel channel = fileOutputStream2.getChannel();
                        duplicate.position(i).limit(i + i2);
                        channel.write(duplicate.slice());
                        str2 = createTempFile.getName();
                        NanoHTTPD.safeClose(fileOutputStream2);
                    } catch (Exception e) {
                        e = e;
                        fileOutputStream = fileOutputStream2;
                        try {
                            throw new Error(e);
                        } catch (Throwable th) {
                            th = th;
                            NanoHTTPD.safeClose(fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = fileOutputStream2;
                        NanoHTTPD.safeClose(fileOutputStream);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    throw new Error(e);
                }
            }
            return str2;
        }

        private int scipOverNewLine(byte[] bArr, int i) {
            while (bArr[i] != 10) {
                i++;
            }
            return i + 1;
        }

        /* JADX WARNING: Unknown top exception splitter block from list: {B:71:0x0184=Splitter:B:71:0x0184, B:76:0x01a6=Splitter:B:76:0x01a6} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void execute() throws java.io.IOException {
            /*
                r7 = this;
                r0 = 8192(0x2000, float:1.14794E-41)
                r1 = 0
                byte[] r2 = new byte[r0]     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                r3 = 0
                r7.splitbyte = r3     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                r7.rlen = r3     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                java.io.BufferedInputStream r4 = r7.inputStream     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                r4.mark(r0)     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                java.io.BufferedInputStream r4 = r7.inputStream     // Catch:{ Exception -> 0x016f }
                int r4 = r4.read(r2, r3, r0)     // Catch:{ Exception -> 0x016f }
                r5 = -1
                if (r4 == r5) goto L_0x015d
            L_0x0018:
                if (r4 <= 0) goto L_0x0039
                int r5 = r7.rlen     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                int r5 = r5 + r4
                r7.rlen = r5     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                int r4 = r7.rlen     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                int r4 = r7.findHeaderEnd(r2, r4)     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                r7.splitbyte = r4     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                int r4 = r7.splitbyte     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                if (r4 <= 0) goto L_0x002c
                goto L_0x0039
            L_0x002c:
                java.io.BufferedInputStream r4 = r7.inputStream     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                int r5 = r7.rlen     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                int r6 = r7.rlen     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                int r6 = 8192 - r6
                int r4 = r4.read(r2, r5, r6)     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                goto L_0x0018
            L_0x0039:
                int r0 = r7.splitbyte     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                int r4 = r7.rlen     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                if (r0 >= r4) goto L_0x004c
                java.io.BufferedInputStream r0 = r7.inputStream     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                r0.reset()     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                java.io.BufferedInputStream r0 = r7.inputStream     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                int r4 = r7.splitbyte     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                long r4 = (long) r4     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                r0.skip(r4)     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
            L_0x004c:
                java.util.HashMap r0 = new java.util.HashMap     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                r0.<init>()     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                r7.parms = r0     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                java.util.Map<java.lang.String, java.lang.String> r0 = r7.headers     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                if (r0 != 0) goto L_0x005f
                java.util.HashMap r0 = new java.util.HashMap     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                r0.<init>()     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                r7.headers = r0     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                goto L_0x0064
            L_0x005f:
                java.util.Map<java.lang.String, java.lang.String> r0 = r7.headers     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                r0.clear()     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
            L_0x0064:
                java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                java.io.ByteArrayInputStream r5 = new java.io.ByteArrayInputStream     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                int r6 = r7.rlen     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                r5.<init>(r2, r3, r6)     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                r4.<init>(r5)     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                r0.<init>(r4)     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                java.util.HashMap r2 = new java.util.HashMap     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                r2.<init>()     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                java.util.Map<java.lang.String, java.lang.String> r4 = r7.parms     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                java.util.Map<java.lang.String, java.lang.String> r5 = r7.headers     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                r7.decodeHeader(r0, r2, r4, r5)     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                java.lang.String r0 = r7.remoteIp     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                if (r0 == 0) goto L_0x0097
                java.util.Map<java.lang.String, java.lang.String> r0 = r7.headers     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                java.lang.String r4 = "remote-addr"
                java.lang.String r5 = r7.remoteIp     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                r0.put(r4, r5)     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                java.util.Map<java.lang.String, java.lang.String> r0 = r7.headers     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                java.lang.String r4 = "http-client-ip"
                java.lang.String r5 = r7.remoteIp     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                r0.put(r4, r5)     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
            L_0x0097:
                java.lang.String r0 = "method"
                java.lang.Object r0 = r2.get(r0)     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                java.lang.String r0 = (java.lang.String) r0     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                fi.iki.elonen.NanoHTTPD$Method r0 = p016fi.iki.elonen.NanoHTTPD.Method.lookup(r0)     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                r7.method = r0     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                fi.iki.elonen.NanoHTTPD$Method r0 = r7.method     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                if (r0 == 0) goto L_0x0153
                java.lang.String r0 = "uri"
                java.lang.Object r0 = r2.get(r0)     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                java.lang.String r0 = (java.lang.String) r0     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                r7.uri = r0     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                fi.iki.elonen.NanoHTTPD$CookieHandler r0 = new fi.iki.elonen.NanoHTTPD$CookieHandler     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                fi.iki.elonen.NanoHTTPD r2 = p016fi.iki.elonen.NanoHTTPD.this     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                java.util.Map<java.lang.String, java.lang.String> r4 = r7.headers     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                r0.<init>(r4)     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                r7.cookies = r0     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                java.util.Map<java.lang.String, java.lang.String> r0 = r7.headers     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                java.lang.String r2 = "connection"
                java.lang.Object r0 = r0.get(r2)     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                java.lang.String r0 = (java.lang.String) r0     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                java.lang.String r2 = r7.protocolVersion     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                java.lang.String r4 = "HTTP/1.1"
                boolean r2 = r2.equals(r4)     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                r4 = 1
                if (r2 == 0) goto L_0x00df
                if (r0 == 0) goto L_0x00dd
                java.lang.String r2 = "(?i).*close.*"
                boolean r0 = r0.matches(r2)     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                if (r0 != 0) goto L_0x00df
            L_0x00dd:
                r0 = 1
                goto L_0x00e0
            L_0x00df:
                r0 = 0
            L_0x00e0:
                fi.iki.elonen.NanoHTTPD r2 = p016fi.iki.elonen.NanoHTTPD.this     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                fi.iki.elonen.NanoHTTPD$Response r2 = r2.serve(r7)     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                if (r2 == 0) goto L_0x0137
                java.util.Map<java.lang.String, java.lang.String> r1 = r7.headers     // Catch:{ SocketException -> 0x014f, SocketTimeoutException -> 0x014b, IOException -> 0x0148, ResponseException -> 0x0145, all -> 0x0141 }
                java.lang.String r5 = "accept-encoding"
                java.lang.Object r1 = r1.get(r5)     // Catch:{ SocketException -> 0x014f, SocketTimeoutException -> 0x014b, IOException -> 0x0148, ResponseException -> 0x0145, all -> 0x0141 }
                java.lang.String r1 = (java.lang.String) r1     // Catch:{ SocketException -> 0x014f, SocketTimeoutException -> 0x014b, IOException -> 0x0148, ResponseException -> 0x0145, all -> 0x0141 }
                fi.iki.elonen.NanoHTTPD$CookieHandler r5 = r7.cookies     // Catch:{ SocketException -> 0x014f, SocketTimeoutException -> 0x014b, IOException -> 0x0148, ResponseException -> 0x0145, all -> 0x0141 }
                r5.unloadQueue(r2)     // Catch:{ SocketException -> 0x014f, SocketTimeoutException -> 0x014b, IOException -> 0x0148, ResponseException -> 0x0145, all -> 0x0141 }
                fi.iki.elonen.NanoHTTPD$Method r5 = r7.method     // Catch:{ SocketException -> 0x014f, SocketTimeoutException -> 0x014b, IOException -> 0x0148, ResponseException -> 0x0145, all -> 0x0141 }
                r2.setRequestMethod(r5)     // Catch:{ SocketException -> 0x014f, SocketTimeoutException -> 0x014b, IOException -> 0x0148, ResponseException -> 0x0145, all -> 0x0141 }
                fi.iki.elonen.NanoHTTPD r5 = p016fi.iki.elonen.NanoHTTPD.this     // Catch:{ SocketException -> 0x014f, SocketTimeoutException -> 0x014b, IOException -> 0x0148, ResponseException -> 0x0145, all -> 0x0141 }
                boolean r5 = r5.useGzipWhenAccepted(r2)     // Catch:{ SocketException -> 0x014f, SocketTimeoutException -> 0x014b, IOException -> 0x0148, ResponseException -> 0x0145, all -> 0x0141 }
                if (r5 == 0) goto L_0x010f
                if (r1 == 0) goto L_0x010f
                java.lang.String r5 = "gzip"
                boolean r1 = r1.contains(r5)     // Catch:{ SocketException -> 0x014f, SocketTimeoutException -> 0x014b, IOException -> 0x0148, ResponseException -> 0x0145, all -> 0x0141 }
                if (r1 == 0) goto L_0x010f
                r3 = 1
            L_0x010f:
                r2.setGzipEncoding(r3)     // Catch:{ SocketException -> 0x014f, SocketTimeoutException -> 0x014b, IOException -> 0x0148, ResponseException -> 0x0145, all -> 0x0141 }
                r2.setKeepAlive(r0)     // Catch:{ SocketException -> 0x014f, SocketTimeoutException -> 0x014b, IOException -> 0x0148, ResponseException -> 0x0145, all -> 0x0141 }
                java.io.OutputStream r1 = r7.outputStream     // Catch:{ SocketException -> 0x014f, SocketTimeoutException -> 0x014b, IOException -> 0x0148, ResponseException -> 0x0145, all -> 0x0141 }
                r2.send(r1)     // Catch:{ SocketException -> 0x014f, SocketTimeoutException -> 0x014b, IOException -> 0x0148, ResponseException -> 0x0145, all -> 0x0141 }
                if (r0 == 0) goto L_0x012f
                java.lang.String r0 = "close"
                java.lang.String r1 = "connection"
                java.lang.String r1 = r2.getHeader(r1)     // Catch:{ SocketException -> 0x014f, SocketTimeoutException -> 0x014b, IOException -> 0x0148, ResponseException -> 0x0145, all -> 0x0141 }
                boolean r0 = r0.equalsIgnoreCase(r1)     // Catch:{ SocketException -> 0x014f, SocketTimeoutException -> 0x014b, IOException -> 0x0148, ResponseException -> 0x0145, all -> 0x0141 }
                if (r0 != 0) goto L_0x012f
                p016fi.iki.elonen.NanoHTTPD.safeClose(r2)
                goto L_0x019f
            L_0x012f:
                java.net.SocketException r0 = new java.net.SocketException     // Catch:{ SocketException -> 0x014f, SocketTimeoutException -> 0x014b, IOException -> 0x0148, ResponseException -> 0x0145, all -> 0x0141 }
                java.lang.String r1 = "NanoHttpd Shutdown"
                r0.<init>(r1)     // Catch:{ SocketException -> 0x014f, SocketTimeoutException -> 0x014b, IOException -> 0x0148, ResponseException -> 0x0145, all -> 0x0141 }
                throw r0     // Catch:{ SocketException -> 0x014f, SocketTimeoutException -> 0x014b, IOException -> 0x0148, ResponseException -> 0x0145, all -> 0x0141 }
            L_0x0137:
                fi.iki.elonen.NanoHTTPD$ResponseException r0 = new fi.iki.elonen.NanoHTTPD$ResponseException     // Catch:{ SocketException -> 0x014f, SocketTimeoutException -> 0x014b, IOException -> 0x0148, ResponseException -> 0x0145, all -> 0x0141 }
                fi.iki.elonen.NanoHTTPD$Response$Status r1 = p016fi.iki.elonen.NanoHTTPD.Response.Status.INTERNAL_ERROR     // Catch:{ SocketException -> 0x014f, SocketTimeoutException -> 0x014b, IOException -> 0x0148, ResponseException -> 0x0145, all -> 0x0141 }
                java.lang.String r3 = "SERVER INTERNAL ERROR: Serve() returned a null response."
                r0.<init>(r1, r3)     // Catch:{ SocketException -> 0x014f, SocketTimeoutException -> 0x014b, IOException -> 0x0148, ResponseException -> 0x0145, all -> 0x0141 }
                throw r0     // Catch:{ SocketException -> 0x014f, SocketTimeoutException -> 0x014b, IOException -> 0x0148, ResponseException -> 0x0145, all -> 0x0141 }
            L_0x0141:
                r0 = move-exception
                r1 = r2
                goto L_0x01d3
            L_0x0145:
                r0 = move-exception
                r1 = r2
                goto L_0x0184
            L_0x0148:
                r0 = move-exception
                r1 = r2
                goto L_0x01a6
            L_0x014b:
                r0 = move-exception
                r1 = r2
                goto L_0x01d0
            L_0x014f:
                r0 = move-exception
                r1 = r2
                goto L_0x01d2
            L_0x0153:
                fi.iki.elonen.NanoHTTPD$ResponseException r0 = new fi.iki.elonen.NanoHTTPD$ResponseException     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                fi.iki.elonen.NanoHTTPD$Response$Status r2 = p016fi.iki.elonen.NanoHTTPD.Response.Status.BAD_REQUEST     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                java.lang.String r3 = "BAD REQUEST: Syntax error."
                r0.<init>(r2, r3)     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                throw r0     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
            L_0x015d:
                java.io.BufferedInputStream r0 = r7.inputStream     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                p016fi.iki.elonen.NanoHTTPD.safeClose(r0)     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                java.io.OutputStream r0 = r7.outputStream     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                p016fi.iki.elonen.NanoHTTPD.safeClose(r0)     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                java.net.SocketException r0 = new java.net.SocketException     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                java.lang.String r2 = "NanoHttpd Shutdown"
                r0.<init>(r2)     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                throw r0     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
            L_0x016f:
                java.io.BufferedInputStream r0 = r7.inputStream     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                p016fi.iki.elonen.NanoHTTPD.safeClose(r0)     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                java.io.OutputStream r0 = r7.outputStream     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                p016fi.iki.elonen.NanoHTTPD.safeClose(r0)     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                java.net.SocketException r0 = new java.net.SocketException     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                java.lang.String r2 = "NanoHttpd Shutdown"
                r0.<init>(r2)     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
                throw r0     // Catch:{ SocketException -> 0x01d1, SocketTimeoutException -> 0x01cf, IOException -> 0x01a5, ResponseException -> 0x0183 }
            L_0x0181:
                r0 = move-exception
                goto L_0x01d3
            L_0x0183:
                r0 = move-exception
            L_0x0184:
                fi.iki.elonen.NanoHTTPD$Response$Status r2 = r0.getStatus()     // Catch:{ all -> 0x0181 }
                java.lang.String r3 = "text/plain"
                java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0181 }
                fi.iki.elonen.NanoHTTPD$Response r0 = p016fi.iki.elonen.NanoHTTPD.newFixedLengthResponse(r2, r3, r0)     // Catch:{ all -> 0x0181 }
                java.io.OutputStream r2 = r7.outputStream     // Catch:{ all -> 0x0181 }
                r0.send(r2)     // Catch:{ all -> 0x0181 }
                java.io.OutputStream r0 = r7.outputStream     // Catch:{ all -> 0x0181 }
                p016fi.iki.elonen.NanoHTTPD.safeClose(r0)     // Catch:{ all -> 0x0181 }
            L_0x019c:
                p016fi.iki.elonen.NanoHTTPD.safeClose(r1)
            L_0x019f:
                fi.iki.elonen.NanoHTTPD$TempFileManager r0 = r7.tempFileManager
                r0.clear()
                goto L_0x01ce
            L_0x01a5:
                r0 = move-exception
            L_0x01a6:
                fi.iki.elonen.NanoHTTPD$Response$Status r2 = p016fi.iki.elonen.NanoHTTPD.Response.Status.INTERNAL_ERROR     // Catch:{ all -> 0x0181 }
                java.lang.String r3 = "text/plain"
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0181 }
                r4.<init>()     // Catch:{ all -> 0x0181 }
                java.lang.String r5 = "SERVER INTERNAL ERROR: IOException: "
                r4.append(r5)     // Catch:{ all -> 0x0181 }
                java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0181 }
                r4.append(r0)     // Catch:{ all -> 0x0181 }
                java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x0181 }
                fi.iki.elonen.NanoHTTPD$Response r0 = p016fi.iki.elonen.NanoHTTPD.newFixedLengthResponse(r2, r3, r0)     // Catch:{ all -> 0x0181 }
                java.io.OutputStream r2 = r7.outputStream     // Catch:{ all -> 0x0181 }
                r0.send(r2)     // Catch:{ all -> 0x0181 }
                java.io.OutputStream r0 = r7.outputStream     // Catch:{ all -> 0x0181 }
                p016fi.iki.elonen.NanoHTTPD.safeClose(r0)     // Catch:{ all -> 0x0181 }
                goto L_0x019c
            L_0x01ce:
                return
            L_0x01cf:
                r0 = move-exception
            L_0x01d0:
                throw r0     // Catch:{ all -> 0x0181 }
            L_0x01d1:
                r0 = move-exception
            L_0x01d2:
                throw r0     // Catch:{ all -> 0x0181 }
            L_0x01d3:
                p016fi.iki.elonen.NanoHTTPD.safeClose(r1)
                fi.iki.elonen.NanoHTTPD$TempFileManager r1 = r7.tempFileManager
                r1.clear()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p016fi.iki.elonen.NanoHTTPD.HTTPSession.execute():void");
        }

        public long getBodySize() {
            if (this.headers.containsKey("content-length")) {
                return Long.parseLong(this.headers.get("content-length"));
            }
            if (this.splitbyte < this.rlen) {
                return (long) (this.rlen - this.splitbyte);
            }
            return 0;
        }

        public CookieHandler getCookies() {
            return this.cookies;
        }

        public final Map<String, String> getHeaders() {
            return this.headers;
        }

        public final InputStream getInputStream() {
            return this.inputStream;
        }

        public final Method getMethod() {
            return this.method;
        }

        public final Map<String, String> getParms() {
            return this.parms;
        }

        public String getQueryParameterString() {
            return this.queryParameterString;
        }

        public final String getUri() {
            return this.uri;
        }

        public void parseBody(Map<String, String> map) throws IOException, ResponseException {
            RandomAccessFile randomAccessFile;
            DataOutput dataOutput;
            ByteArrayOutputStream byteArrayOutputStream;
            ByteBuffer map2;
            StringTokenizer stringTokenizer;
            Map<String, String> map3 = map;
            try {
                long bodySize = getBodySize();
                if (bodySize < PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    randomAccessFile = null;
                    dataOutput = new DataOutputStream(byteArrayOutputStream);
                } else {
                    DataOutput tmpBucket = getTmpBucket();
                    randomAccessFile = tmpBucket;
                    byteArrayOutputStream = null;
                    dataOutput = tmpBucket;
                }
                try {
                    byte[] bArr = new byte[512];
                    while (this.rlen >= 0 && bodySize > 0) {
                        this.rlen = this.inputStream.read(bArr, 0, (int) Math.min(bodySize, 512));
                        bodySize -= (long) this.rlen;
                        if (this.rlen > 0) {
                            dataOutput.write(bArr, 0, this.rlen);
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        map2 = ByteBuffer.wrap(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
                    } else {
                        map2 = randomAccessFile.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, randomAccessFile.length());
                        randomAccessFile.seek(0);
                    }
                    ByteBuffer byteBuffer = map2;
                    if (Method.POST.equals(this.method)) {
                        String str = "";
                        String str2 = this.headers.get("content-type");
                        if (str2 != null) {
                            stringTokenizer = new StringTokenizer(str2, ",; ");
                            if (stringTokenizer.hasMoreTokens()) {
                                str = stringTokenizer.nextToken();
                            }
                        } else {
                            stringTokenizer = null;
                        }
                        if (!"multipart/form-data".equalsIgnoreCase(str)) {
                            byte[] bArr2 = new byte[byteBuffer.remaining()];
                            byteBuffer.get(bArr2);
                            String trim = new String(bArr2).trim();
                            if (HttpRequest.CONTENT_TYPE_FORM.equalsIgnoreCase(str)) {
                                decodeParms(trim, this.parms);
                            } else if (trim.length() != 0) {
                                map3.put("postData", trim);
                            }
                        } else if (stringTokenizer.hasMoreTokens()) {
                            decodeMultipartFormData(getAttributeFromContentHeader(str2, NanoHTTPD.BOUNDARY_PATTERN, (String) null), getAttributeFromContentHeader(str2, NanoHTTPD.CHARSET_PATTERN, "US-ASCII"), byteBuffer, this.parms, map);
                        } else {
                            throw new ResponseException(Response.Status.BAD_REQUEST, "BAD REQUEST: Content type is multipart/form-data but boundary missing. Usage: GET /example/file.html");
                        }
                    } else if (Method.PUT.equals(this.method)) {
                        map3.put(FirebaseAnalytics.Param.CONTENT, saveTmpFile(byteBuffer, 0, byteBuffer.limit(), (String) null));
                    }
                    NanoHTTPD.safeClose(randomAccessFile);
                } catch (Throwable th) {
                    th = th;
                    NanoHTTPD.safeClose(randomAccessFile);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile = null;
                NanoHTTPD.safeClose(randomAccessFile);
                throw th;
            }
        }
    }

    /* renamed from: fi.iki.elonen.NanoHTTPD$IHTTPSession */
    public interface IHTTPSession {
        void execute() throws IOException;

        CookieHandler getCookies();

        Map<String, String> getHeaders();

        InputStream getInputStream();

        Method getMethod();

        Map<String, String> getParms();

        String getQueryParameterString();

        String getUri();

        void parseBody(Map<String, String> map) throws IOException, ResponseException;
    }

    /* renamed from: fi.iki.elonen.NanoHTTPD$Method */
    public enum Method {
        GET,
        PUT,
        POST,
        DELETE,
        HEAD,
        OPTIONS,
        TRACE,
        CONNECT,
        PATCH;

        static Method lookup(String str) {
            for (Method method : values()) {
                if (method.toString().equalsIgnoreCase(str)) {
                    return method;
                }
            }
            return null;
        }
    }

    /* renamed from: fi.iki.elonen.NanoHTTPD$Response */
    public static class Response implements Closeable {
        private boolean chunkedTransfer;
        private long contentLength;
        private InputStream data;
        private boolean encodeAsGzip;
        private final Map<String, String> header = new HashMap();
        private boolean keepAlive;
        private String mimeType;
        private Method requestMethod;
        private IStatus status;

        /* renamed from: fi.iki.elonen.NanoHTTPD$Response$ChunkedOutputStream */
        private static class ChunkedOutputStream extends FilterOutputStream {
            public ChunkedOutputStream(OutputStream outputStream) {
                super(outputStream);
            }

            public void finish() throws IOException {
                this.out.write("0\r\n\r\n".getBytes());
            }

            public void write(int i) throws IOException {
                write(new byte[]{(byte) i}, 0, 1);
            }

            public void write(byte[] bArr) throws IOException {
                write(bArr, 0, bArr.length);
            }

            public void write(byte[] bArr, int i, int i2) throws IOException {
                if (i2 != 0) {
                    this.out.write(String.format("%x\r\n", new Object[]{Integer.valueOf(i2)}).getBytes());
                    this.out.write(bArr, i, i2);
                    this.out.write("\r\n".getBytes());
                }
            }
        }

        /* renamed from: fi.iki.elonen.NanoHTTPD$Response$IStatus */
        public interface IStatus {
            String getDescription();

            int getRequestStatus();
        }

        /* renamed from: fi.iki.elonen.NanoHTTPD$Response$Status */
        public enum Status implements IStatus {
            SWITCH_PROTOCOL(101, "Switching Protocols"),
            OK(200, "OK"),
            CREATED(201, "Created"),
            ACCEPTED(202, "Accepted"),
            NO_CONTENT(204, "No Content"),
            PARTIAL_CONTENT(206, "Partial Content"),
            REDIRECT(301, "Moved Permanently"),
            NOT_MODIFIED(304, "Not Modified"),
            BAD_REQUEST(TitleChanger.DEFAULT_ANIMATION_DELAY, "Bad Request"),
            UNAUTHORIZED(401, "Unauthorized"),
            FORBIDDEN(403, "Forbidden"),
            NOT_FOUND(404, "Not Found"),
            METHOD_NOT_ALLOWED(405, "Method Not Allowed"),
            NOT_ACCEPTABLE(406, "Not Acceptable"),
            REQUEST_TIMEOUT(408, "Request Timeout"),
            CONFLICT(409, "Conflict"),
            RANGE_NOT_SATISFIABLE(416, "Requested Range Not Satisfiable"),
            INTERNAL_ERROR(500, "Internal Server Error"),
            NOT_IMPLEMENTED(501, "Not Implemented"),
            UNSUPPORTED_HTTP_VERSION(505, "HTTP Version Not Supported");
            
            private final String description;
            private final int requestStatus;

            private Status(int i, String str) {
                this.requestStatus = i;
                this.description = str;
            }

            public String getDescription() {
                return "" + this.requestStatus + " " + this.description;
            }

            public int getRequestStatus() {
                return this.requestStatus;
            }
        }

        protected Response(IStatus iStatus, String str, InputStream inputStream, long j) {
            this.status = iStatus;
            this.mimeType = str;
            boolean z = false;
            if (inputStream == null) {
                this.data = new ByteArrayInputStream(new byte[0]);
                this.contentLength = 0;
            } else {
                this.data = inputStream;
                this.contentLength = j;
            }
            this.chunkedTransfer = this.contentLength < 0 ? true : z;
            this.keepAlive = true;
        }

        private static boolean headerAlreadySent(Map<String, String> map, String str) {
            boolean z = false;
            for (String equalsIgnoreCase : map.keySet()) {
                z |= equalsIgnoreCase.equalsIgnoreCase(str);
            }
            return z;
        }

        private void sendBody(OutputStream outputStream, long j) throws IOException {
            byte[] bArr = new byte[((int) PlaybackStateCompat.ACTION_PREPARE)];
            boolean z = j == -1;
            while (true) {
                if (j > 0 || z) {
                    int read = this.data.read(bArr, 0, (int) (z ? 16384 : Math.min(j, PlaybackStateCompat.ACTION_PREPARE)));
                    if (read > 0) {
                        outputStream.write(bArr, 0, read);
                        if (!z) {
                            j -= (long) read;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        }

        private void sendBodyWithCorrectEncoding(OutputStream outputStream, long j) throws IOException {
            if (this.encodeAsGzip) {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                sendBody(gZIPOutputStream, -1);
                gZIPOutputStream.finish();
                return;
            }
            sendBody(outputStream, j);
        }

        private void sendBodyWithCorrectTransferAndEncoding(OutputStream outputStream, long j) throws IOException {
            if (this.requestMethod == Method.HEAD || !this.chunkedTransfer) {
                sendBodyWithCorrectEncoding(outputStream, j);
                return;
            }
            ChunkedOutputStream chunkedOutputStream = new ChunkedOutputStream(outputStream);
            sendBodyWithCorrectEncoding(chunkedOutputStream, -1);
            chunkedOutputStream.finish();
        }

        protected static long sendContentLengthHeaderIfNotAlreadyPresent(PrintWriter printWriter, Map<String, String> map, long j) {
            for (String next : map.keySet()) {
                if (next.equalsIgnoreCase("content-length")) {
                    try {
                        return Long.parseLong(map.get(next));
                    } catch (NumberFormatException unused) {
                        return j;
                    }
                }
            }
            printWriter.print("Content-Length: " + j + "\r\n");
            return j;
        }

        public void addHeader(String str, String str2) {
            this.header.put(str, str2);
        }

        public void close() throws IOException {
            if (this.data != null) {
                this.data.close();
            }
        }

        public InputStream getData() {
            return this.data;
        }

        public String getHeader(String str) {
            for (String next : this.header.keySet()) {
                if (next.equalsIgnoreCase(str)) {
                    return this.header.get(next);
                }
            }
            return null;
        }

        public String getMimeType() {
            return this.mimeType;
        }

        public Method getRequestMethod() {
            return this.requestMethod;
        }

        public IStatus getStatus() {
            return this.status;
        }

        /* access modifiers changed from: protected */
        public void send(OutputStream outputStream) {
            String str = this.mimeType;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            try {
                if (this.status != null) {
                    PrintWriter printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream, HttpRequest.CHARSET_UTF8)), false);
                    printWriter.print("HTTP/1.1 " + this.status.getDescription() + " \r\n");
                    if (str != null) {
                        printWriter.print("Content-Type: " + str + "\r\n");
                    }
                    if (this.header == null || this.header.get(HttpRequest.HEADER_DATE) == null) {
                        printWriter.print("Date: " + simpleDateFormat.format(new Date()) + "\r\n");
                    }
                    if (this.header != null) {
                        for (String next : this.header.keySet()) {
                            printWriter.print(next + ": " + this.header.get(next) + "\r\n");
                        }
                    }
                    if (!headerAlreadySent(this.header, "connection")) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Connection: ");
                        sb.append(this.keepAlive ? "keep-alive" : "close");
                        sb.append("\r\n");
                        printWriter.print(sb.toString());
                    }
                    if (headerAlreadySent(this.header, "content-length")) {
                        this.encodeAsGzip = false;
                    }
                    if (this.encodeAsGzip) {
                        printWriter.print("Content-Encoding: gzip\r\n");
                        setChunkedTransfer(true);
                    }
                    long j = this.data != null ? this.contentLength : 0;
                    if (this.requestMethod != Method.HEAD && this.chunkedTransfer) {
                        printWriter.print("Transfer-Encoding: chunked\r\n");
                    } else if (!this.encodeAsGzip) {
                        j = sendContentLengthHeaderIfNotAlreadyPresent(printWriter, this.header, j);
                    }
                    printWriter.print("\r\n");
                    printWriter.flush();
                    sendBodyWithCorrectTransferAndEncoding(outputStream, j);
                    outputStream.flush();
                    NanoHTTPD.safeClose(this.data);
                    return;
                }
                throw new Error("sendResponse(): Status can't be null.");
            } catch (IOException e) {
                NanoHTTPD.LOG.log(Level.SEVERE, "Could not send response to the client", e);
            }
        }

        public void setChunkedTransfer(boolean z) {
            this.chunkedTransfer = z;
        }

        public void setData(InputStream inputStream) {
            this.data = inputStream;
        }

        public void setGzipEncoding(boolean z) {
            this.encodeAsGzip = z;
        }

        public void setKeepAlive(boolean z) {
            this.keepAlive = z;
        }

        public void setMimeType(String str) {
            this.mimeType = str;
        }

        public void setRequestMethod(Method method) {
            this.requestMethod = method;
        }

        public void setStatus(IStatus iStatus) {
            this.status = iStatus;
        }
    }

    /* renamed from: fi.iki.elonen.NanoHTTPD$ResponseException */
    public static final class ResponseException extends Exception {
        private static final long serialVersionUID = 6569838532917408380L;
        private final Response.Status status;

        public ResponseException(Response.Status status2, String str) {
            super(str);
            this.status = status2;
        }

        public ResponseException(Response.Status status2, String str, Exception exc) {
            super(str, exc);
            this.status = status2;
        }

        public Response.Status getStatus() {
            return this.status;
        }
    }

    /* renamed from: fi.iki.elonen.NanoHTTPD$SecureServerSocketFactory */
    public static class SecureServerSocketFactory implements ServerSocketFactory {
        private String[] sslProtocols;
        private SSLServerSocketFactory sslServerSocketFactory;

        public SecureServerSocketFactory(SSLServerSocketFactory sSLServerSocketFactory, String[] strArr) {
            this.sslServerSocketFactory = sSLServerSocketFactory;
            this.sslProtocols = strArr;
        }

        public ServerSocket create() throws IOException {
            SSLServerSocket sSLServerSocket = (SSLServerSocket) this.sslServerSocketFactory.createServerSocket();
            if (this.sslProtocols != null) {
                sSLServerSocket.setEnabledProtocols(this.sslProtocols);
            } else {
                sSLServerSocket.setEnabledProtocols(sSLServerSocket.getSupportedProtocols());
            }
            sSLServerSocket.setUseClientMode(false);
            sSLServerSocket.setWantClientAuth(false);
            sSLServerSocket.setNeedClientAuth(false);
            return sSLServerSocket;
        }
    }

    /* renamed from: fi.iki.elonen.NanoHTTPD$ServerRunnable */
    public class ServerRunnable implements Runnable {
        /* access modifiers changed from: private */
        public IOException bindException;
        /* access modifiers changed from: private */
        public boolean hasBinded;
        private final int timeout;

        private ServerRunnable(int i) {
            this.hasBinded = false;
            this.timeout = i;
        }

        public void run() {
            try {
                NanoHTTPD.this.myServerSocket.bind(NanoHTTPD.this.hostname != null ? new InetSocketAddress(NanoHTTPD.this.hostname, NanoHTTPD.this.myPort) : new InetSocketAddress(NanoHTTPD.this.myPort));
                this.hasBinded = true;
                do {
                    try {
                        Socket accept = NanoHTTPD.this.myServerSocket.accept();
                        if (this.timeout > 0) {
                            accept.setSoTimeout(this.timeout);
                        }
                        NanoHTTPD.this.asyncRunner.exec(NanoHTTPD.this.createClientHandler(accept, accept.getInputStream()));
                    } catch (IOException e) {
                        NanoHTTPD.LOG.log(Level.FINE, "Communication with the client broken", e);
                    }
                } while (!NanoHTTPD.this.myServerSocket.isClosed());
            } catch (IOException e2) {
                this.bindException = e2;
            }
        }
    }

    /* renamed from: fi.iki.elonen.NanoHTTPD$ServerSocketFactory */
    public interface ServerSocketFactory {
        ServerSocket create() throws IOException;
    }

    /* renamed from: fi.iki.elonen.NanoHTTPD$TempFile */
    public interface TempFile {
        void delete() throws Exception;

        String getName();

        OutputStream open() throws Exception;
    }

    /* renamed from: fi.iki.elonen.NanoHTTPD$TempFileManager */
    public interface TempFileManager {
        void clear();

        TempFile createTempFile(String str) throws Exception;
    }

    /* renamed from: fi.iki.elonen.NanoHTTPD$TempFileManagerFactory */
    public interface TempFileManagerFactory {
        TempFileManager create();
    }

    public NanoHTTPD(int i) {
        this((String) null, i);
    }

    public NanoHTTPD(String str, int i) {
        this.serverSocketFactory = new DefaultServerSocketFactory();
        this.hostname = str;
        this.myPort = i;
        setTempFileManagerFactory(new DefaultTempFileManagerFactory());
        setAsyncRunner(new DefaultAsyncRunner());
    }

    protected static Map<String, List<String>> decodeParameters(String str) {
        HashMap hashMap = new HashMap();
        if (str != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, "&");
            while (stringTokenizer.hasMoreTokens()) {
                String nextToken = stringTokenizer.nextToken();
                int indexOf = nextToken.indexOf(61);
                String trim = (indexOf >= 0 ? decodePercent(nextToken.substring(0, indexOf)) : decodePercent(nextToken)).trim();
                if (!hashMap.containsKey(trim)) {
                    hashMap.put(trim, new ArrayList());
                }
                String decodePercent = indexOf >= 0 ? decodePercent(nextToken.substring(indexOf + 1)) : null;
                if (decodePercent != null) {
                    ((List) hashMap.get(trim)).add(decodePercent);
                }
            }
        }
        return hashMap;
    }

    protected static Map<String, List<String>> decodeParameters(Map<String, String> map) {
        return decodeParameters(map.get(QUERY_STRING_PARAMETER));
    }

    protected static String decodePercent(String str) {
        try {
            return URLDecoder.decode(str, UrlUtils.UTF8);
        } catch (UnsupportedEncodingException e) {
            LOG.log(Level.WARNING, "Encoding not supported, ignored", e);
            return null;
        }
    }

    public static String getMimeTypeForFile(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        String str2 = lastIndexOf >= 0 ? mimeTypes().get(str.substring(lastIndexOf + 1).toLowerCase()) : null;
        return str2 == null ? "application/octet-stream" : str2;
    }

    private static void loadMimeTypes(Map<String, String> map, String str) {
        InputStream inputStream;
        IOException e;
        try {
            Enumeration<URL> resources = NanoHTTPD.class.getClassLoader().getResources(str);
            while (resources.hasMoreElements()) {
                URL nextElement = resources.nextElement();
                Properties properties = new Properties();
                try {
                    inputStream = nextElement.openStream();
                    try {
                        properties.load(nextElement.openStream());
                    } catch (IOException e2) {
                        e = e2;
                        try {
                            LOG.log(Level.SEVERE, "could not load mimetypes from " + nextElement, e);
                            safeClose(inputStream);
                            map.putAll(properties);
                        } catch (Throwable th) {
                            th = th;
                        }
                    }
                } catch (IOException e3) {
                    IOException iOException = e3;
                    inputStream = null;
                    e = iOException;
                    LOG.log(Level.SEVERE, "could not load mimetypes from " + nextElement, e);
                    safeClose(inputStream);
                    map.putAll(properties);
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = null;
                    safeClose(inputStream);
                    throw th;
                }
                safeClose(inputStream);
                map.putAll(properties);
            }
        } catch (IOException unused) {
            LOG.log(Level.INFO, "no mime types available at " + str);
        }
    }

    public static SSLServerSocketFactory makeSSLSocketFactory(String str, char[] cArr) throws IOException {
        try {
            KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
            instance.load(NanoHTTPD.class.getResourceAsStream(str), cArr);
            KeyManagerFactory instance2 = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            instance2.init(instance, cArr);
            return makeSSLSocketFactory(instance, instance2);
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }
    }

    public static SSLServerSocketFactory makeSSLSocketFactory(KeyStore keyStore, KeyManagerFactory keyManagerFactory) throws IOException {
        try {
            return makeSSLSocketFactory(keyStore, keyManagerFactory.getKeyManagers());
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }
    }

    public static SSLServerSocketFactory makeSSLSocketFactory(KeyStore keyStore, KeyManager[] keyManagerArr) throws IOException {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init(keyStore);
            SSLContext instance2 = SSLContext.getInstance("TLS");
            instance2.init(keyManagerArr, instance.getTrustManagers(), (SecureRandom) null);
            return instance2.getServerSocketFactory();
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }
    }

    public static Map<String, String> mimeTypes() {
        if (MIME_TYPES == null) {
            MIME_TYPES = new HashMap();
            loadMimeTypes(MIME_TYPES, "META-INF/nanohttpd/default-mimetypes.properties");
            loadMimeTypes(MIME_TYPES, "META-INF/nanohttpd/mimetypes.properties");
            if (MIME_TYPES.isEmpty()) {
                LOG.log(Level.WARNING, "no mime types found in the classpath! please provide mimetypes.properties");
            }
        }
        return MIME_TYPES;
    }

    public static Response newChunkedResponse(Response.IStatus iStatus, String str, InputStream inputStream) {
        return new Response(iStatus, str, inputStream, -1);
    }

    public static Response newFixedLengthResponse(Response.IStatus iStatus, String str, InputStream inputStream, long j) {
        return new Response(iStatus, str, inputStream, j);
    }

    public static Response newFixedLengthResponse(Response.IStatus iStatus, String str, String str2) {
        byte[] bArr;
        if (str2 == null) {
            return newFixedLengthResponse(iStatus, str, new ByteArrayInputStream(new byte[0]), 0);
        }
        try {
            bArr = str2.getBytes(HttpRequest.CHARSET_UTF8);
        } catch (UnsupportedEncodingException e) {
            LOG.log(Level.SEVERE, "encoding problem, responding nothing", e);
            bArr = new byte[0];
        }
        return newFixedLengthResponse(iStatus, str, new ByteArrayInputStream(bArr), (long) bArr.length);
    }

    public static Response newFixedLengthResponse(String str) {
        return newFixedLengthResponse(Response.Status.OK, MIME_HTML, str);
    }

    /* access modifiers changed from: private */
    public static final void safeClose(Object obj) {
        if (obj != null) {
            try {
                if (obj instanceof Closeable) {
                    ((Closeable) obj).close();
                } else if (obj instanceof Socket) {
                    ((Socket) obj).close();
                } else if (obj instanceof ServerSocket) {
                    ((ServerSocket) obj).close();
                } else {
                    throw new IllegalArgumentException("Unknown object to close");
                }
            } catch (IOException e) {
                LOG.log(Level.SEVERE, "Could not close", e);
            }
        }
    }

    public synchronized void closeAllConnections() {
        stop();
    }

    /* access modifiers changed from: protected */
    public ClientHandler createClientHandler(Socket socket, InputStream inputStream) {
        return new ClientHandler(inputStream, socket);
    }

    /* access modifiers changed from: protected */
    public ServerRunnable createServerRunnable(int i) {
        return new ServerRunnable(i);
    }

    public String getHostname() {
        return this.hostname;
    }

    public final int getListeningPort() {
        if (this.myServerSocket == null) {
            return -1;
        }
        return this.myServerSocket.getLocalPort();
    }

    public ServerSocketFactory getServerSocketFactory() {
        return this.serverSocketFactory;
    }

    public TempFileManagerFactory getTempFileManagerFactory() {
        return this.tempFileManagerFactory;
    }

    public final boolean isAlive() {
        return wasStarted() && !this.myServerSocket.isClosed() && this.myThread.isAlive();
    }

    public void makeSecure(SSLServerSocketFactory sSLServerSocketFactory, String[] strArr) {
        this.serverSocketFactory = new SecureServerSocketFactory(sSLServerSocketFactory, strArr);
    }

    public Response serve(IHTTPSession iHTTPSession) {
        HashMap hashMap = new HashMap();
        Method method = iHTTPSession.getMethod();
        if (Method.PUT.equals(method) || Method.POST.equals(method)) {
            try {
                iHTTPSession.parseBody(hashMap);
            } catch (IOException e) {
                Response.Status status = Response.Status.INTERNAL_ERROR;
                return newFixedLengthResponse(status, MIME_PLAINTEXT, "SERVER INTERNAL ERROR: IOException: " + e.getMessage());
            } catch (ResponseException e2) {
                return newFixedLengthResponse(e2.getStatus(), MIME_PLAINTEXT, e2.getMessage());
            }
        }
        Map<String, String> parms = iHTTPSession.getParms();
        parms.put(QUERY_STRING_PARAMETER, iHTTPSession.getQueryParameterString());
        return serve(iHTTPSession.getUri(), method, iHTTPSession.getHeaders(), parms, hashMap);
    }

    @Deprecated
    public Response serve(String str, Method method, Map<String, String> map, Map<String, String> map2, Map<String, String> map3) {
        return newFixedLengthResponse(Response.Status.NOT_FOUND, MIME_PLAINTEXT, "Not Found");
    }

    public void setAsyncRunner(AsyncRunner asyncRunner2) {
        this.asyncRunner = asyncRunner2;
    }

    public void setServerSocketFactory(ServerSocketFactory serverSocketFactory2) {
        this.serverSocketFactory = serverSocketFactory2;
    }

    public void setTempFileManagerFactory(TempFileManagerFactory tempFileManagerFactory2) {
        this.tempFileManagerFactory = tempFileManagerFactory2;
    }

    public void start() throws IOException {
        start(SOCKET_READ_TIMEOUT);
    }

    public void start(int i) throws IOException {
        start(i, true);
    }

    public void start(int i, boolean z) throws IOException {
        this.myServerSocket = getServerSocketFactory().create();
        this.myServerSocket.setReuseAddress(true);
        ServerRunnable createServerRunnable = createServerRunnable(i);
        this.myThread = new Thread(createServerRunnable);
        this.myThread.setDaemon(z);
        this.myThread.setName("NanoHttpd Main Listener");
        this.myThread.start();
        while (!createServerRunnable.hasBinded && createServerRunnable.bindException == null) {
            try {
                Thread.sleep(10);
            } catch (Throwable unused) {
            }
        }
        if (createServerRunnable.bindException != null) {
            throw createServerRunnable.bindException;
        }
    }

    public void stop() {
        try {
            safeClose(this.myServerSocket);
            this.asyncRunner.closeAll();
            if (this.myThread != null) {
                this.myThread.join();
            }
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Could not stop all connections", e);
        }
    }

    /* access modifiers changed from: protected */
    public boolean useGzipWhenAccepted(Response response) {
        return response.getMimeType() != null && response.getMimeType().toLowerCase().contains("text/");
    }

    public final boolean wasStarted() {
        return (this.myServerSocket == null || this.myThread == null) ? false : true;
    }
}
