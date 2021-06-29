package com.adcolony.sdk;

import java.net.URL;

/* renamed from: com.adcolony.sdk.t */
class C0796t {

    /* renamed from: a */
    URL f1087a;

    public C0796t(URL url) {
        this.f1087a = url;
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0088  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int mo10915a(java.lang.String r7) throws java.io.IOException {
        /*
            r6 = this;
            r0 = 1
            r1 = 0
            r2 = 0
            java.net.URL r3 = r6.f1087a     // Catch:{ IOException -> 0x0073, all -> 0x006f }
            java.net.URLConnection r3 = r3.openConnection()     // Catch:{ IOException -> 0x0073, all -> 0x006f }
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch:{ IOException -> 0x0073, all -> 0x006f }
            java.lang.String r4 = "POST"
            r3.setRequestMethod(r4)     // Catch:{ IOException -> 0x006d, all -> 0x006b }
            java.lang.String r4 = "Content-Encoding"
            java.lang.String r5 = "gzip"
            r3.setRequestProperty(r4, r5)     // Catch:{ IOException -> 0x006d, all -> 0x006b }
            java.lang.String r4 = "Content-Type"
            java.lang.String r5 = "application/json"
            r3.setRequestProperty(r4, r5)     // Catch:{ IOException -> 0x006d, all -> 0x006b }
            r3.setDoInput(r0)     // Catch:{ IOException -> 0x006d, all -> 0x006b }
            java.util.zip.GZIPOutputStream r4 = new java.util.zip.GZIPOutputStream     // Catch:{ IOException -> 0x006d, all -> 0x006b }
            java.io.OutputStream r5 = r3.getOutputStream()     // Catch:{ IOException -> 0x006d, all -> 0x006b }
            r4.<init>(r5)     // Catch:{ IOException -> 0x006d, all -> 0x006b }
            java.io.DataOutputStream r5 = new java.io.DataOutputStream     // Catch:{ IOException -> 0x0069, all -> 0x0067 }
            r5.<init>(r4)     // Catch:{ IOException -> 0x0069, all -> 0x0067 }
            java.lang.String r1 = "UTF-8"
            java.nio.charset.Charset r1 = java.nio.charset.Charset.forName(r1)     // Catch:{ IOException -> 0x0063, all -> 0x0060 }
            byte[] r7 = r7.getBytes(r1)     // Catch:{ IOException -> 0x0063, all -> 0x0060 }
            r5.write(r7)     // Catch:{ IOException -> 0x0063, all -> 0x0060 }
            r5.close()     // Catch:{ IOException -> 0x0063, all -> 0x0060 }
            int r7 = r3.getResponseCode()     // Catch:{ IOException -> 0x005d, all -> 0x0059 }
            r4.close()
            if (r3 == 0) goto L_0x0058
            java.io.InputStream r0 = r3.getInputStream()
            if (r0 == 0) goto L_0x0055
            java.io.InputStream r0 = r3.getInputStream()
            r0.close()
        L_0x0055:
            r3.disconnect()
        L_0x0058:
            return r7
        L_0x0059:
            r7 = move-exception
            r1 = r5
            r2 = 1
            goto L_0x007a
        L_0x005d:
            r7 = move-exception
            r2 = 1
            goto L_0x0064
        L_0x0060:
            r7 = move-exception
            r1 = r5
            goto L_0x007a
        L_0x0063:
            r7 = move-exception
        L_0x0064:
            r0 = r2
            r1 = r5
            goto L_0x0077
        L_0x0067:
            r7 = move-exception
            goto L_0x007a
        L_0x0069:
            r7 = move-exception
            goto L_0x0076
        L_0x006b:
            r7 = move-exception
            goto L_0x0071
        L_0x006d:
            r7 = move-exception
            goto L_0x0075
        L_0x006f:
            r7 = move-exception
            r3 = r1
        L_0x0071:
            r4 = r1
            goto L_0x007a
        L_0x0073:
            r7 = move-exception
            r3 = r1
        L_0x0075:
            r4 = r1
        L_0x0076:
            r0 = 0
        L_0x0077:
            throw r7     // Catch:{ all -> 0x0078 }
        L_0x0078:
            r7 = move-exception
            r2 = r0
        L_0x007a:
            if (r1 == 0) goto L_0x0081
            if (r2 != 0) goto L_0x0081
            r1.close()
        L_0x0081:
            if (r4 == 0) goto L_0x0086
            r4.close()
        L_0x0086:
            if (r3 == 0) goto L_0x0098
            java.io.InputStream r0 = r3.getInputStream()
            if (r0 == 0) goto L_0x0095
            java.io.InputStream r0 = r3.getInputStream()
            r0.close()
        L_0x0095:
            r3.disconnect()
        L_0x0098:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.C0796t.mo10915a(java.lang.String):int");
    }
}
