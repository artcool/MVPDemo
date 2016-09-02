package com.sinwao.mvpdemo.present;

/**
 * Created by Administrator on 2016/9/2 0002.
 */
public interface ILoginView {

    /**
     * 清楚edittext数据
     */
    void clearText();

    /**
     * 登录结果回调
     * @param result
     * @param code
     */
     void onLoginResult(Boolean result,int code);

}
