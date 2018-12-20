package com.liruya.base;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;

public class BaseViewModel<T> extends ViewModel {
    protected final String TAG = this.getClass().getSimpleName();

    private final MutableLiveData<T> mLiveData = new MutableLiveData<>();

    public void observe(LifecycleOwner owner, Observer<T> observer) {
        mLiveData.observe(owner, observer);
    }
}
