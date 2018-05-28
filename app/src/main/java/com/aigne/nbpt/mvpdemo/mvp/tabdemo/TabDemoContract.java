package com.aigne.nbpt.mvpdemo.mvp.tabdemo;

import com.aigne.mvp.base.BaseModel;
import com.aigne.mvp.base.BasePresenter;
import com.aigne.mvp.base.BaseView;

/**
 * 用于tab的子界面
 * @author jazzeZhou
 * @date 2018/5/28
 */
public interface TabDemoContract {

    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter {

    }

    interface Model extends BaseModel {

    }

}
