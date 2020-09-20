package com.wang.base.testing.camera.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.afollestad.materialdialogs.MaterialDialog;
import com.wang.base.testing.camera.R;

public class AppUtils {

    public static boolean isConnectivityAvailable(Context context) {
        ConnectivityManager conn = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = conn.getActiveNetworkInfo();
        return info != null && info.isAvailable() && info.isConnectedOrConnecting();
    }

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
