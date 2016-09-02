package com.sinwao.mvpdemo.controller;

import com.sinwao.mvpdemo.entity.User;
import com.sinwao.mvpdemo.present.ILoginPresenter;
import com.sinwao.mvpdemo.present.ILoginView;

/**
 * Created by Administrator on 2016/9/2 0002.
 */
public class LoginPresenterCompl implements ILoginPresenter {

    private ILoginView mView;
    private User user;

    public LoginPresenterCompl(ILoginView view){
        this.mView = view;
        this.user = new User("adc","123456");
    }

    @Override
    public void clear() {
        mView.clearText();
    }

    @Override
    public void doLogin(String name, String password) {
        boolean result = false;
        int code = 0;
        if (name.equals(user.username) && password.equals(user.password)){
            result = true;
            code = 1;
        }else {
            result = false;
            code = 0;
        }
        mView.onLoginResult(result,code);
    }
}
