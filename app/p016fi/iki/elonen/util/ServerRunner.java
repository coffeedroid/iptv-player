package p016fi.iki.elonen.util;

import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import p016fi.iki.elonen.NanoHTTPD;

/* renamed from: fi.iki.elonen.util.ServerRunner */
public class ServerRunner {
    private static final Logger LOG = Logger.getLogger(ServerRunner.class.getName());

    public static void executeInstance(NanoHTTPD nanoHTTPD) {
        try {
            nanoHTTPD.start(NanoHTTPD.SOCKET_READ_TIMEOUT, false);
        } catch (IOException e) {
            PrintStream printStream = System.err;
            printStream.println("Couldn't start server:\n" + e);
            System.exit(-1);
        }
        System.out.println("Server started, Hit Enter to stop.\n");
        try {
            System.in.read();
        } catch (Throwable unused) {
        }
        nanoHTTPD.stop();
        System.out.println("Server stopped.\n");
    }

    public static <T extends NanoHTTPD> void run(Class<T> cls) {
        try {
            executeInstance((NanoHTTPD) cls.newInstance());
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Cound nor create server", e);
        }
    }
}
