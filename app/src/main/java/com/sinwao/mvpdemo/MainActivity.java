package com.sinwao.mvpdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sinwao.mvpdemo.controller.LoginPresenterCompl;
import com.sinwao.mvpdemo.present.ILoginView;

/**
 * mvp设计模式
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener,ILoginView {

    private EditText mEtUser;
    private EditText mEtPassword;
    private Button mBtLogin;
    private String user;
    private String password;
    private LoginPresenterCompl presenterCompl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mEtUser = (EditText) findViewById(R.id.et_user);
        mEtPassword = (EditText) findViewById(R.id.et_password);
        mBtLogin = (Button) findViewById(R.id.bt_login);

        mBtLogin.setOnClickListener(this);
        presenterCompl = new LoginPresenterCompl(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_login:
                submit();

                break;
        }
    }

    private void submit() {
        // validate
        user = mEtUser.getText().toString().trim();
        if (TextUtils.isEmpty(user)) {
            Toast.makeText(this, "请输入用户名", Toast.LENGTH_SHORT).show();
            return;
        }

        password = mEtPassword.getText().toString().trim();
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }
        // TODO validate success, do something
        presenterCompl.doLogin(user,password);

    }

    @Override
    public void clearText() {
        mEtUser.setText("");
        mEtPassword.setText("");
        Toast.makeText(getApplicationContext(),"clear",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginResult(Boolean result, int code) {
        if (result){
            Toast.makeText(getApplicationContext(),"登录成功",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(),"登录失败",Toast.LENGTH_SHORT).show();
        }
    }
}
