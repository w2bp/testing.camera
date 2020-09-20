package com.wang.base.testing.camera.ui.base;

public interface BaseMvpView extends MvpView {

    void createProgressDialog();

    void createAlertDialog();

    void showProgressDialog(boolean value);

    void showAlertDialog(String errorMessage);

    void setProgressDialogCancelable(boolean value);

    void dismissDialog();

    void notifyError(String error);

    void notifyError(int errorResId);

    void notifyError(int errorResId, String error);
}
