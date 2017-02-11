package com.andrijans.playground.framework.api;

import com.andrijans.playground.presentation.common.constants.Constants;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by andrijanstankovic on 09/02/2017.
 */

@Module
public class ApiModule {
    @Provides
    @Singleton
    public okhttp3.OkHttpClient provideHttpClient() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        AuthenticationInterceptor authenticationInterceptor = new AuthenticationInterceptor();

        okhttp3.OkHttpClient httpClient = new okhttp3.OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(authenticationInterceptor)
                .connectTimeout(20 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(30 * 1000, TimeUnit.MILLISECONDS)
                .build();

        return httpClient;
    }

    @Provides
    @Singleton
    public Retrofit provideRestAdapter(okhttp3.OkHttpClient httpClient) {
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.API_URL)
                .client(httpClient)
                .build();
    }

    @Provides
    @Singleton
    public IApiService provideApiService(Retrofit restAdapter) {
        return restAdapter.create(IApiService.class);
    }
}
