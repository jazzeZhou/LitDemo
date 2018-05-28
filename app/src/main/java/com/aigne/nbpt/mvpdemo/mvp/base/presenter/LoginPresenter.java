package com.aigne.nbpt.mvpdemo.mvp.base.presenter;

import android.annotation.SuppressLint;

import com.aigne.nbpt.mvpdemo.http.HttpCallbackListener;
import com.aigne.nbpt.mvpdemo.http.ResponseBean;
import com.aigne.nbpt.mvpdemo.http.bean.AuthInfoBean;
import com.aigne.nbpt.mvpdemo.mvp.base.LoginContract;
import com.aigne.nbpt.mvpdemo.mvp.base.model.LoginModel;
import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.PhoneUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author jazzeZhou
 * @date 2018/5/24
 */
public class LoginPresenter<T extends LoginContract.View>
    implements LoginContract.Presenter {

    private T mMvpView;
    private LoginModel mModel;

    public LoginPresenter(T view) {
        this.mMvpView = view;
        this.mModel = new LoginModel();
    }

    @SuppressLint("MissingPermission")
    @Override
    public void goLogin(String name, String pwd) {
        String imei = PhoneUtils.getIMEI();
        this.mModel.login(name, pwd, imei)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(this.mMvpView.<ResponseBean>bindToLife())
                .subscribe(new HttpCallbackListener<ResponseBean>() {
                    @Override
                    public void onSuccess(String result) {
                        AuthInfoBean loginBean = JSON.parseObject(result, AuthInfoBean.class);
                        if (loginBean.code == 1) {
                            // 成功
                            mMvpView.showLoginResult(true, loginBean.message);
                        } else {
                            // 失败
                            mMvpView.showLoginResult(false, loginBean.message);
                        }
                    }

                    @Override
                    public void onFailure(int code, String message) {
                        mMvpView.showLoginResult(false, message);
                    }
                });
    }
}
