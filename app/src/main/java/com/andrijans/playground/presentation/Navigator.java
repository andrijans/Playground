package com.andrijans.playground.presentation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * Created by andrijanstankovic on 08/02/2017.
 */

public class Navigator {

    private void startActivity(Context ctx, Intent intent, boolean shouldFinish) {
        Activity activity = (Activity) ctx;
        activity.startActivity(intent);
        if (shouldFinish) {
            activity.finish();
        }
    }
}
