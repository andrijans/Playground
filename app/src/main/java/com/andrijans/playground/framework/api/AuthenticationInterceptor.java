package com.andrijans.playground.framework.api;

import com.andrijans.playground.presentation.App;
import com.andrijans.playground.presentation.common.constants.Constants;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by andrijanstankovic on 10/02/2017.
 */

public class AuthenticationInterceptor implements Interceptor {

    public AuthenticationInterceptor() {
        App.get(null).getAppComponent().inject(this);
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        HttpUrl originalHttpUrl = original.url();

        HttpUrl url = originalHttpUrl.newBuilder()
                .addQueryParameter(Constants.API_KEY_NAME, Constants.API_KEY)
                .build();

        Request.Builder requestBuilder = original.newBuilder()
                .url(url);

        Request request = requestBuilder.build();
        return chain.proceed(request);

    }
}
