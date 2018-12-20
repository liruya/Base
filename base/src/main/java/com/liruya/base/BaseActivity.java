package com.liruya.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    protected final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRes());

        Intent intent = getIntent();
        if (intent != null) {
            getIntentData();
        }
        initView();
    }

    protected abstract void getIntentData();

    protected abstract @LayoutRes int getLayoutRes();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void initEvent();
}
