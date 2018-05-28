package com.aigne.nbpt.mvpdemo.mvp.base.presenter;

import com.aigne.nbpt.mvpdemo.mvp.base.MainContract;
import com.aigne.nbpt.mvpdemo.mvp.base.model.MainModel;

/**
 * @author jazzeZhou
 * @date 2018/5/24
 */
public class MainPresenter<T extends MainContract.View>
    implements MainContract.Presenter {

    private T mMvpView;
    private MainModel mModel;

    public MainPresenter(T view) {
        this.mMvpView = view;
        this.mModel = new MainModel();
    }


}
