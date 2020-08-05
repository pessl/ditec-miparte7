package com.example.mvp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mvp.Model.LoginInteractorImpl;
import com.example.mvp.Presenter.LoginPresenter;
import com.example.mvp.Presenter.LoginPresenterImpl;
import com.example.mvp.View.LoginView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginView {
    LoginPresenter loginPresenter;

    @BindView(R.id.edtUsuario)
    EditText edtUsuario;

    @BindView(R.id.edtPassword)
    EditText edtPassword;

    @BindView(R.id.progresslogin)
    ProgressBar progresslogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        loginPresenter = new LoginPresenterImpl(this, new LoginInteractorImpl());
    }

    @Override
    public void showProgress() {
        progresslogin.setVisibility(View.VISIBLE);
    }

    @Override
    public void HideProgress() {
        progresslogin.setVisibility(View.GONE);
    }

    @Override
    public void setUserNameError() {
        Toast.makeText(this,"El campo usuario esta vacio",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPasswordError() {
        Toast.makeText(this,"El campo password esta vacio",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToHome() {
        startActivity(new Intent(this,MainActivity.class));
    }

    @OnClick(R.id.btnLogin)
    public void onViewClicked() {
        loginPresenter.validateCredentials(edtUsuario.getText().toString(), edtPassword.getText().toString());
    }
}