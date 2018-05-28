package com.aigne.nbpt.mvpdemo.mvp.tabdemo.presenter;

import com.aigne.nbpt.mvpdemo.mvp.tabdemo.TabDemoContract;
import com.aigne.nbpt.mvpdemo.mvp.tabdemo.model.TabDemoModel;

/**
 * @author jazzeZhou
 * @date 2018/5/24
 */
public class TabDemoPresenter<T extends TabDemoContract.View>
    implements TabDemoContract.Presenter {

    private T mMvpView;
    private TabDemoModel mModel;

    public TabDemoPresenter(T view) {
        this.mMvpView = view;
        this.mModel = new TabDemoModel();
    }


}
