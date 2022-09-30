package com.oro.taxi.chofer.activity;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

import com.oro.taxi.chofer.settings.LocaleManager;

public class MultiLanguageApp extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleManager.setLocale(base));
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        LocaleManager.setLocale(this);
    }
}
