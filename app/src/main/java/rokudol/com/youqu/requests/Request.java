package rokudol.com.youqu.requests;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rokudol.com.youqu.constants.Constants;


/**
 * Created by rokudo on 2017/4/11.
 * 网络请求的工具类
 */

public class Request {
	public static RequestServer getApi(String baseUrl) {
		Interceptor interceptor = new Interceptor() {
			@Override
			public Response intercept(Chain chain) throws IOException {
				okhttp3.Request request = chain.request().newBuilder().build();
				Log.i("``````````````", request.toString());

				return chain.proceed(request);
			}
		};
		OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(baseUrl)
				.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
				.addConverterFactory(GsonConverterFactory.create())
				.client(client)
				.build();

		RequestServer api = retrofit.create(RequestServer.class);
		return api;
	}

	public static RequestServer RequestAliYun(String baseUrl) {
		Interceptor interceptor = new Interceptor() {
			@Override
			public Response intercept(Chain chain) throws IOException {
				okhttp3.Request request = chain.request().newBuilder().
						addHeader("Authorization", "APPCODE " + Constants.APPCODE).build();
				Log.i("``````````````", request.toString());

				return chain.proceed(request);
			}
		};
		OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(baseUrl)
				.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
				.addConverterFactory(GsonConverterFactory.create())
				.client(client)
				.build();

		RequestServer api = retrofit.create(RequestServer.class);
		return api;
	}
}
