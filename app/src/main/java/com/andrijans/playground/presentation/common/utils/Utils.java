package com.andrijans.playground.presentation.common.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;

import com.andrijans.playground.presentation.common.constants.Constants;

import static android.graphics.Paint.ANTI_ALIAS_FLAG;

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

    public static Bitmap textAsBitmap(String text, float textSize, int textColor) {
        Paint paint = new Paint(ANTI_ALIAS_FLAG);
        paint.setTextSize(textSize);
        paint.setColor(textColor);
        paint.setTextAlign(Paint.Align.LEFT);
        float baseline = -paint.ascent(); // ascent() is negative
        int width = (int) (paint.measureText(text) + 0.0f); // round
        int height = (int) (baseline + paint.descent() + 0.0f);
        Bitmap image = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(image);
        canvas.drawText(text, 0, baseline, paint);
        return image;
    }
}
