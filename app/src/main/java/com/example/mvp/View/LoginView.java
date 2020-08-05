package com.example.mvp.View;

public interface LoginView {
    void showProgress();
    void HideProgress();
    void setUserNameError();
    void setPasswordError();
    void navigateToHome();
}
