package com.liruya.base;

import android.content.Context;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import java.lang.ref.WeakReference;

public class BaseFragmentPresenter<T extends BaseFragment> {

    protected final String TAG = this.getClass().getSimpleName();

    private WeakReference<T> mFragment;

    public BaseFragmentPresenter(T t) {
        mFragment = new WeakReference<>(t);
    }

    protected Fragment getFragment() {
        return mFragment.get();
    }

    protected FragmentActivity getActivity() {
        if (mFragment.get() != null) {
            return mFragment.get().getActivity();
        }
        return null;
    }

    protected Context getContext() {
        if (mFragment.get() != null) {
            return mFragment.get().getContext();
        }
        return null;
    }

    protected void runOnUiThread(Runnable runnable) {
        if (getActivity() != null) {
            getActivity().runOnUiThread(runnable);
        }
    }

    protected boolean isViewExist() {
        return mFragment.get() != null;
    }

    protected String getString(@StringRes int res) {
        if (getContext() != null) {
            return getContext().getString(res);
        }
        return null;
    }
}
