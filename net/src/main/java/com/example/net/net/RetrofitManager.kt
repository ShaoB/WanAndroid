package com.example.net.net

import com.example.net.cookie.AppCookieJar
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.net.ssl.HttpsURLConnection

/**
 *    author : Bin
 *    date   : 2022/1/10 16:54
 *    desc   : retrofit管理
 */
class RetrofitManager private constructor() {

    private var retrofit: Retrofit

    companion object {
        val instance: RetrofitManager by lazy { RetrofitManager() }
    }

    init {
        retrofit = Retrofit.Builder()
            .client(initClient())
            //提前验证标识
            .validateEagerly(true)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(UrlConfig.BaseUrl)
            .build()
    }

    private var hostNames: Array<String>? = null

    /**
     * 请求头拦截器
     */
    private var headInterceptor = Interceptor { chain ->
        val original = chain.request()
        val requestBuilder: Request.Builder = original.newBuilder()
            .addHeader("token", "1563")
        chain.proceed(requestBuilder.build())
    }

    /**
     * 初始化 okhttpClient
     */
    private fun initClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .callTimeout(15, TimeUnit.SECONDS)
            ///连接超时时间
            .connectTimeout(15, TimeUnit.SECONDS)
            //读取超时时间
            .readTimeout(15, TimeUnit.SECONDS)
            //写入超时时间
            .writeTimeout(15, TimeUnit.SECONDS)
            //错误重连
            .retryOnConnectionFailure(true)
            //禁用重定向
            .followRedirects(false)
            //设置用于读取和写入缓存响应的响应缓存
            //.cache(Cache(MainApp.cacheDir, Long.MAX_VALUE))
            //保存和更新Cookie
            .cookieJar(AppCookieJar())
            //主机名验证器
            .hostnameVerifier { hostname, session ->
                if (hostNames != null) {
                    //检测是否包含该主机
                    listOf(*hostNames!!)
                        .contains(hostname)
                } else {
                    HttpsURLConnection.getDefaultHostnameVerifier().verify(hostname, session)
                }
            }
            //HTTPS连接的套接字工厂和信任管理器
            //.sslSocketFactory()
            //添加一个日志拦截器
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            //添加请求头拦截器
            //.addInterceptor(headInterceptor)
            .build()
    }

    /**
     *  创建对应的service
     */
    fun <T> create(service: Class<T>): T {
        return retrofit.create(service)
    }
}