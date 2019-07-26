package com.beautycoder.pflockscreen.security;

import android.os.Build;

public class BiometricUtils {
    public static boolean isBiometricPromptEnabled() {
        return (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P);
    }
}
