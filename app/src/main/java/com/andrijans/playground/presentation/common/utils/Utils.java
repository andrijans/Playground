package com.andrijans.playground.presentation.common.utils;

import android.net.Uri;

import com.andrijans.playground.presentation.common.constants.Constants;

/**
 * Created by andrijanstankovic on 11/02/2017.
 */

public class Utils {

    public static Uri getPosterUri(String posterPath) {
        return Uri.parse(Constants.IMAGE_URL_POSTER + posterPath);
    }


    public static Uri getBackdropUri(String backdropPath) {
        return Uri.parse(Constants.IMAGE_URL_BACKDROP + backdropPath);
    }
}
