package com.aigne.nbpt.mvpdemo.mvp.base;

import com.aigne.mvp.base.BaseModel;
import com.aigne.mvp.base.BasePresenter;
import com.aigne.mvp.base.BaseView;

/**
 * @author jazzeZhou
 * @date 2018/5/28
 */
public interface MainContract {

    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter {

    }

    interface Model extends BaseModel {

    }

}
