package com.liruya.base;

import android.content.Context;
import android.support.annotation.StringRes;

import java.lang.ref.WeakReference;

public class BaseActivityPresenter<T extends BaseActivity> {

    protected final String TAG = this.getClass().getSimpleName();

    private WeakReference<T> mActivity;

    public BaseActivityPresenter(T t) {
        mActivity = new WeakReference<>(t);
    }

    protected T getActivity() {
        return mActivity.get();
    }

    protected Context getContext() {
        return mActivity.get();
    }

    protected void runOnUiThread(Runnable runnable) {
        if (getActivity() != null) {
            getActivity().runOnUiThread(runnable);
        }
    }

    protected boolean isViewExist() {
        return mActivity.get() != null;
    }

    protected String getString(@StringRes int res) {
        if (getContext() != null) {
            return getContext().getString(res);
        }
        return null;
    }
}
