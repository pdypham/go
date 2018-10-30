package com.woz.core;

import android.app.Application;

public class WozApplication extends Application {

    protected WozActivity currentActivity;

    public void setCurrentActivity(WozActivity currentActivity){
        this.currentActivity = currentActivity;
    }
}