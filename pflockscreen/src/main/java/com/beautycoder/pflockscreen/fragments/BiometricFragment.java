package com.beautycoder.pflockscreen.fragments;

import androidx.annotation.NonNull;
import androidx.biometric.BiometricPrompt;
import androidx.fragment.app.FragmentActivity;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class BiometricFragment {
    private PFFingerprintAuthListener mCallback;
    public BiometricFragment(FragmentActivity activity, final PFFingerprintAuthListener mCallback) {
        Executor executor = Executors.newSingleThreadExecutor();
        final BiometricPrompt biometricPrompt = new BiometricPrompt(activity, executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                mCallback.onError();
            }

            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                mCallback.onAuthenticated();
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
            }
        });
        biometricPrompt.authenticate(createBiometricDialog());
    }

    private BiometricPrompt.PromptInfo createBiometricDialog() {
        return new BiometricPrompt.PromptInfo.Builder()
                .setTitle("Bảo mật vân tay")
                .setSubtitle("")
                .setDescription("Vui lòng chạm vào cảm biến vân tay để bắt đầu ứng dụng")
                .setNegativeButtonText("Cancel")
                .build();
    }
}
