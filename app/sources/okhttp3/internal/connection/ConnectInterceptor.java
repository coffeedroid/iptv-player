package okhttp3.internal.connection;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.http.RealInterceptorChain;
import p017io.fabric.sdk.android.services.network.HttpRequest;

public final class ConnectInterceptor implements Interceptor {
    public final OkHttpClient client;

    public ConnectInterceptor(OkHttpClient okHttpClient) {
        this.client = okHttpClient;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Request request = realInterceptorChain.request();
        StreamAllocation streamAllocation = realInterceptorChain.streamAllocation();
        return realInterceptorChain.proceed(request, streamAllocation, streamAllocation.newStream(this.client, chain, !request.method().equals(HttpRequest.METHOD_GET)), streamAllocation.connection());
    }
}
