package model;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.web3j.protocol.http.HttpService;

import java.util.concurrent.TimeUnit;

/**
 * @author jiazy
 * @data 2022/9/16
 */
public class httpServiceEx extends HttpService {
//    private static OkHttpClient createOkHttpClient() {
//        OkHttpClient.Builder builder = new OkHttpClient.Builder();
//        configureLogging(builder);
//        MyOkHttpRetryInterceptor myOkHttpRetryInterceptor = new MyOkHttpRetryInterceptor.Builder()
//                .executionCount(3).retryInterval(1000).build();
//        builder.addInterceptor(myOkHttpRetryInterceptor);
//        builder.retryOnConnectionFailure(true);
//        log.info("---------设置超时时间--------{}秒",120);
//        builder.connectionPool(new ConnectionPool())
//                .connectTimeout(120, TimeUnit.SECONDS)
//                .readTimeout(120, TimeUnit.SECONDS).build();
//        return builder.build();
//    }
}
