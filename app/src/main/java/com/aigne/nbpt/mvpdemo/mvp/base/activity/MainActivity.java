package com.aigne.nbpt.mvpdemo.mvp.base.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.aigne.mvp.base.BaseContractActivity;
import com.aigne.nbpt.mvpdemo.R;
import com.aigne.nbpt.mvpdemo.mvp.base.MainContract;
import com.aigne.nbpt.mvpdemo.mvp.base.presenter.MainPresenter;
import com.aigne.nbpt.mvpdemo.mvp.tabdemo.fragment.TabDemoFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.PageBottomTabLayout;
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectedListener;

/**
 * @author jazzeZhou
 * @date 2018/4/9
 */
public class MainActivity extends BaseContractActivity<MainContract.Presenter>
        implements MainContract.View {

    @BindView(R.id.tab)
    PageBottomTabLayout tab;
    @BindView(R.id.vp_main)
    ViewPager vpMain;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private ArrayList<Fragment> fragments = new ArrayList<>();
    private ViewPagerAdapter vpAdapter;
    private ArrayList<String> tabNames = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initStatusBar();
        initToolBar(toolbar, false);

        initMainViewPager();

    }

    private void initMainViewPager() {
        tabNames.add("tab1");
        tabNames.add("tab2");
        tabNames.add("tab3");
        tabNames.add("tab4");
        toolbarTitle.setText(tabNames.get(0));
        NavigationController navigationController = tab.material()
                .addItem(R.mipmap.tab_cloud_normal, tabNames.get(0))
                .addItem(R.mipmap.tab_cloud_normal, tabNames.get(1))
                .addItem(R.mipmap.tab_cloud_normal, tabNames.get(2))
                .addItem(R.mipmap.tab_cloud_normal, tabNames.get(3))
                .build();
        fragments.add(TabDemoFragment.newInstance());
        fragments.add(TabDemoFragment.newInstance());
        fragments.add(TabDemoFragment.newInstance());
        fragments.add(TabDemoFragment.newInstance());
        vpAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        vpMain.setAdapter(vpAdapter);
        navigationController.setupWithViewPager(vpMain);
        navigationController.addTabItemSelectedListener(new OnTabItemSelectedListener() {
            @Override
            public void onSelected(int index, int old) {
                toolbarTitle.setText(tabNames.get(index));
            }

            @Override
            public void onRepeat(int index) {

            }
        });


    }

    @Override
    public void initPresenter() {
        mPresenter = new MainPresenter<>(this);
    }

    @Override
    public void onFailure(String e) {
        showToast(e);
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }

}
