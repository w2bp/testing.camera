package com.wang.base.testing.camera.utils;

import android.content.Context;

import com.afollestad.materialdialogs.MaterialDialog;
import com.wang.base.testing.camera.R;

public class AppUtils {

    public static MaterialDialog createProgressDialog(Context context, String title) {
        return new MaterialDialog.Builder(context)
                .title(title)
                .content(R.string.msg_wait)
                .progress(true, 0)
                .cancelable(false)
                .build();
    }

    public static MaterialDialog createAlertDialog(Context context, String title) {
        return new MaterialDialog.Builder(context)
                .title(title)
                .positiveText("OK")
                .build();
    }
}
