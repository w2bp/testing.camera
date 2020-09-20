package com.wang.base.testing.camera.ui.base;


import android.os.Bundle;

import androidx.annotation.Nullable;

import com.afollestad.materialdialogs.MaterialDialog;
import com.wang.base.testing.camera.MainActivity;
import com.wang.base.testing.camera.R;
import com.wang.base.testing.camera.utils.AppUtils;

public abstract class BaseDialogFragment extends BaseFragment implements BaseMvpView {
    public MaterialDialog progressDialog, alertDialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createAlertDialog();
        createProgressDialog();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupDialogTitle();
    }

    @Override
    public void createProgressDialog() {
        progressDialog = AppUtils.createProgressDialog(getActivity(), getString(R.string.app_name));
    }

    @Override
    public void createAlertDialog() {
        alertDialog = AppUtils.createAlertDialog(getActivity(), getString(R.string.app_name));
    }

    protected abstract void setupDialogTitle();

    @Override
    public void dismissDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }

        if (alertDialog != null && alertDialog.isShowing()) {
            alertDialog.dismiss();
        }
    }

    @Override
    public void showProgressDialog(boolean value) {
        if (value) {
            progressDialog.show();
        } else {
            progressDialog.dismiss();
        }
    }

    @Override
    public void showAlertDialog(String errorMessage) {
        alertDialog.setContent(errorMessage);
        alertDialog.show();
    }

    @Override
    public void onDestroyView() {
        dismissDialog();
        super.onDestroyView();
    }

    @Override
    public void notifyError(String error) {
        if (activity instanceof MainActivity) {
            ((MainActivity) activity).showErrorMessage(error);
        }
    }

    @Override
    public void notifyError(int errorResId) {
        notifyError(getString(errorResId));
    }

    @Override
    public void notifyError(int errorResId, String error) {
        notifyError(getString(errorResId) + " " + error);
    }

    @Override
    public void setProgressDialogCancelable(boolean value) {
        progressDialog.setCancelable(value);
    }

    public void onReload() {
    }
}