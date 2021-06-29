package wseemann.media2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.FileDescriptor;
import java.util.HashMap;
import java.util.Map;

class FFmpegMediaMetadataRetriever {
    public static Bitmap.Config IN_PREFERRED_CONFIG = null;
    private static final String[] JNI_LIBRARIES = {"avutil", "swscale", "avcodec", "avformat", "ffmpeg_mediametadataretriever_jni"};
    public static final String METADATA_CHAPTER_COUNT = "chapter_count";
    public static final String METADATA_KEY_ALBUM = "album";
    public static final String METADATA_KEY_ALBUM_ARTIST = "album_artist";
    public static final String METADATA_KEY_ARTIST = "artist";
    public static final String METADATA_KEY_AUDIO_CODEC = "audio_codec";
    public static final String METADATA_KEY_CHAPTER_END_TIME = "chapter_end_time";
    public static final String METADATA_KEY_CHAPTER_START_TIME = "chapter_start_time";
    public static final String METADATA_KEY_COMMENT = "comment";
    public static final String METADATA_KEY_COMPOSER = "composer";
    public static final String METADATA_KEY_COPYRIGHT = "copyright";
    public static final String METADATA_KEY_CREATION_TIME = "creation_time";
    public static final String METADATA_KEY_DATE = "date";
    public static final String METADATA_KEY_DISC = "disc";
    public static final String METADATA_KEY_DURATION = "duration";
    public static final String METADATA_KEY_ENCODED_BY = "encoded_by";
    public static final String METADATA_KEY_ENCODER = "encoder";
    public static final String METADATA_KEY_FILENAME = "filename";
    public static final String METADATA_KEY_FILESIZE = "filesize";
    public static final String METADATA_KEY_FRAMERATE = "framerate";
    public static final String METADATA_KEY_GENRE = "genre";
    public static final String METADATA_KEY_ICY_METADATA = "icy_metadata";
    public static final String METADATA_KEY_LANGUAGE = "language";
    public static final String METADATA_KEY_PERFORMER = "performer";
    public static final String METADATA_KEY_PUBLISHER = "publisher";
    public static final String METADATA_KEY_SERVICE_NAME = "service_name";
    public static final String METADATA_KEY_SERVICE_PROVIDER = "service_provider";
    public static final String METADATA_KEY_TITLE = "title";
    public static final String METADATA_KEY_TRACK = "track";
    public static final String METADATA_KEY_VARIANT_BITRATE = "bitrate";
    public static final String METADATA_KEY_VIDEO_CODEC = "video_codec";
    public static final String METADATA_KEY_VIDEO_ROTATION = "rotate";
    public static final int OPTION_CLOSEST = 3;
    public static final int OPTION_CLOSEST_SYNC = 2;
    public static final int OPTION_NEXT_SYNC = 1;
    public static final int OPTION_PREVIOUS_SYNC = 0;
    private static final String TAG = "FFmpegMediaMetadataRetriever";
    private int mNativeContext;

    public FFmpegMediaMetadataRetriever() {
        nativesetup();
    }

    private native byte[] _getFrameAtTime(long j, int i);

    private native byte[] _getScaledFrameAtTime(long j, int i, int i2, int i3);

    private native void _setDataSource(String str, String[] strArr, String[] strArr2) throws IllegalArgumentException;

    private Bitmap.Config getInPreferredConfig() {
        return IN_PREFERRED_CONFIG != null ? IN_PREFERRED_CONFIG : Bitmap.Config.RGB_565;
    }

    private final native void native_finalize();

    private final native HashMap<String, String> native_getMetadata(boolean z, boolean z2, HashMap<String, String> hashMap);

    private static native void native_init();

    private native void nativesetup();

    public native String extractMetadata(String str);

    public native String extractMetadataFromChapter(String str, int i);

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            native_finalize();
        } finally {
            super.finalize();
        }
    }

    public native byte[] getEmbeddedPicture();

    public Bitmap getFrameAtTime() {
        return getFrameAtTime(-1, 2);
    }

    public Bitmap getFrameAtTime(long j) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = getInPreferredConfig();
        options.inDither = false;
        byte[] _getFrameAtTime = _getFrameAtTime(j, 2);
        if (_getFrameAtTime != null) {
            return BitmapFactory.decodeByteArray(_getFrameAtTime, 0, _getFrameAtTime.length, options);
        }
        return null;
    }

    public Bitmap getFrameAtTime(long j, int i) {
        if (i < 0 || i > 3) {
            throw new IllegalArgumentException("Unsupported option: " + i);
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = getInPreferredConfig();
        options.inDither = false;
        byte[] _getFrameAtTime = _getFrameAtTime(j, i);
        if (_getFrameAtTime != null) {
            return BitmapFactory.decodeByteArray(_getFrameAtTime, 0, _getFrameAtTime.length, options);
        }
        return null;
    }

    public Metadata getMetadata() {
        Metadata metadata = new Metadata();
        HashMap<String, String> native_getMetadata = native_getMetadata(false, false, (HashMap<String, String>) null);
        if (native_getMetadata != null && metadata.parse(native_getMetadata)) {
            return metadata;
        }
        return null;
    }

    public Bitmap getScaledFrameAtTime(long j, int i, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = getInPreferredConfig();
        options.inDither = false;
        byte[] _getScaledFrameAtTime = _getScaledFrameAtTime(j, 2, i, i2);
        if (_getScaledFrameAtTime != null) {
            return BitmapFactory.decodeByteArray(_getScaledFrameAtTime, 0, _getScaledFrameAtTime.length, options);
        }
        return null;
    }

    public Bitmap getScaledFrameAtTime(long j, int i, int i2, int i3) {
        if (i < 0 || i > 3) {
            throw new IllegalArgumentException("Unsupported option: " + i);
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = getInPreferredConfig();
        options.inDither = false;
        byte[] _getScaledFrameAtTime = _getScaledFrameAtTime(j, i, i2, i3);
        if (_getScaledFrameAtTime != null) {
            return BitmapFactory.decodeByteArray(_getScaledFrameAtTime, 0, _getScaledFrameAtTime.length, options);
        }
        return null;
    }

    public native void release();

    /* JADX WARNING: Can't wrap try/catch for region: R(3:29|30|31) */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x005b, code lost:
        throw new java.lang.IllegalArgumentException();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0056 */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0060 A[SYNTHETIC, Splitter:B:35:0x0060] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0067 A[SYNTHETIC, Splitter:B:43:0x0067] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setDataSource(android.content.Context r8, android.net.Uri r9) throws java.lang.IllegalArgumentException, java.lang.SecurityException {
        /*
            r7 = this;
            if (r9 == 0) goto L_0x007a
            java.lang.String r0 = r9.getScheme()
            if (r0 == 0) goto L_0x0072
            java.lang.String r1 = "file"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0011
            goto L_0x0072
        L_0x0011:
            r0 = 0
            android.content.ContentResolver r8 = r8.getContentResolver()     // Catch:{ SecurityException -> 0x0064, all -> 0x005c }
            java.lang.String r1 = "r"
            android.content.res.AssetFileDescriptor r8 = r8.openAssetFileDescriptor(r9, r1)     // Catch:{ FileNotFoundException -> 0x0056 }
            if (r8 == 0) goto L_0x004e
            java.io.FileDescriptor r2 = r8.getFileDescriptor()     // Catch:{ SecurityException -> 0x0065, all -> 0x0054 }
            boolean r0 = r2.valid()     // Catch:{ SecurityException -> 0x0065, all -> 0x0054 }
            if (r0 == 0) goto L_0x0048
            long r0 = r8.getDeclaredLength()     // Catch:{ SecurityException -> 0x0065, all -> 0x0054 }
            r3 = 0
            int r5 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x0036
            r7.setDataSource((java.io.FileDescriptor) r2)     // Catch:{ SecurityException -> 0x0065, all -> 0x0054 }
            goto L_0x0042
        L_0x0036:
            long r3 = r8.getStartOffset()     // Catch:{ SecurityException -> 0x0065, all -> 0x0054 }
            long r5 = r8.getDeclaredLength()     // Catch:{ SecurityException -> 0x0065, all -> 0x0054 }
            r1 = r7
            r1.setDataSource(r2, r3, r5)     // Catch:{ SecurityException -> 0x0065, all -> 0x0054 }
        L_0x0042:
            if (r8 == 0) goto L_0x0047
            r8.close()     // Catch:{ IOException -> 0x0047 }
        L_0x0047:
            return
        L_0x0048:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ SecurityException -> 0x0065, all -> 0x0054 }
            r0.<init>()     // Catch:{ SecurityException -> 0x0065, all -> 0x0054 }
            throw r0     // Catch:{ SecurityException -> 0x0065, all -> 0x0054 }
        L_0x004e:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ SecurityException -> 0x0065, all -> 0x0054 }
            r0.<init>()     // Catch:{ SecurityException -> 0x0065, all -> 0x0054 }
            throw r0     // Catch:{ SecurityException -> 0x0065, all -> 0x0054 }
        L_0x0054:
            r9 = move-exception
            goto L_0x005e
        L_0x0056:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException     // Catch:{ SecurityException -> 0x0064, all -> 0x005c }
            r8.<init>()     // Catch:{ SecurityException -> 0x0064, all -> 0x005c }
            throw r8     // Catch:{ SecurityException -> 0x0064, all -> 0x005c }
        L_0x005c:
            r9 = move-exception
            r8 = r0
        L_0x005e:
            if (r8 == 0) goto L_0x0063
            r8.close()     // Catch:{ IOException -> 0x0063 }
        L_0x0063:
            throw r9
        L_0x0064:
            r8 = r0
        L_0x0065:
            if (r8 == 0) goto L_0x006a
            r8.close()     // Catch:{ IOException -> 0x006a }
        L_0x006a:
            java.lang.String r8 = r9.toString()
            r7.setDataSource((java.lang.String) r8)
            return
        L_0x0072:
            java.lang.String r8 = r9.getPath()
            r7.setDataSource((java.lang.String) r8)
            return
        L_0x007a:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            r8.<init>()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: wseemann.media2.FFmpegMediaMetadataRetriever.setDataSource(android.content.Context, android.net.Uri):void");
    }

    public void setDataSource(FileDescriptor fileDescriptor) throws IllegalArgumentException {
        setDataSource(fileDescriptor, 0, 576460752303423487L);
    }

    public native void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IllegalArgumentException;

    public native void setDataSource(String str) throws IllegalArgumentException;

    public void setDataSource(String str, Map<String, String> map) throws IllegalArgumentException {
        String[] strArr = new String[map.size()];
        String[] strArr2 = new String[map.size()];
        int i = 0;
        for (Map.Entry next : map.entrySet()) {
            strArr[i] = (String) next.getKey();
            strArr2[i] = (String) next.getValue();
            i++;
        }
        _setDataSource(str, strArr, strArr2);
    }
}
