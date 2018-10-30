package com.woz.wozpi.utils;

import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.util.Patterns;

public class AppUtil {

    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    public static boolean isValidPhone(CharSequence target) {
        return (!TextUtils.isEmpty(target) &&
                PhoneNumberUtils.isGlobalPhoneNumber(target.toString()));
    }


    public static boolean isPassword(CharSequence target) {
        return target.length() >= 5;
    }
}

