package com.wang.base.testing.camera.ui.base;

import io.reactivex.disposables.CompositeDisposable;

public class BasePresenter<V extends MvpView> implements Presenter<V> {
    private V mMvpView;

    @Override
    public void attachView(V mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void detachView() {
        mMvpView = null;
    }

    public boolean isViewAttached() {
        return mMvpView != null;
    }

    public V getMvpView() {
        return mMvpView;
    }

    protected void dispose(CompositeDisposable compositeSubscription) {
        if (compositeSubscription != null) {
            compositeSubscription.dispose();
        }
    }
}
