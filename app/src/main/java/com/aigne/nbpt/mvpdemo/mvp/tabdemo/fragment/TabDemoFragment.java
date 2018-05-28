package com.aigne.nbpt.mvpdemo.mvp.tabdemo.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aigne.mvp.base.BaseFragment;
import com.aigne.nbpt.mvpdemo.R;
import com.aigne.nbpt.mvpdemo.mvp.tabdemo.TabDemoContract;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author jazzeZhou
 * @date 2018/5/2
 */
public class TabDemoFragment extends BaseFragment<TabDemoContract.Presenter>
        implements TabDemoContract.View {

    Unbinder unbinder;

    public static TabDemoFragment newInstance() {
        TabDemoFragment fragment = new TabDemoFragment();
        return fragment;
    }

    public TabDemoFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);


        return rootView;
    }

    @Override
    protected int attachLayoutId() {
        return R.layout.fragment_tabdemo;
    }

    @Override
    protected void initData() throws NullPointerException {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void onFailure(String e) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
