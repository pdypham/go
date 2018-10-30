package com.woz.wozpi.activities;

import android.support.design.widget.TextInputLayout;

import com.woz.core.WozActivity;
import com.woz.wozpi.R;


public class LoginActivity extends WozActivity{

    private TextInputLayout textInputLayout;

    @Override
    protected int setLayoutView() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        textInputLayout = findViewById(R.id.textInputLayout);
    }

    @Override
    protected void loadData() {

    }
}
