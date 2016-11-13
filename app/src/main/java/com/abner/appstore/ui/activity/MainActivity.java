package com.abner.appstore.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.abner.appstore.R;
import com.abner.appstore.ui.fragment.BaseFragment;
import com.abner.appstore.ui.fragment.FragmentFactory;
import com.abner.appstore.ui.view.PagerTab;
import com.abner.appstore.utils.UIUtils;

public class MainActivity extends BaseActivity {

    private PagerTab pagetab;
    private MyAdapter mAdapter;
    private ViewPager viewpage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.pagetab = (PagerTab) findViewById(R.id.pager_tab);
        this.viewpage = (ViewPager) findViewById(R.id.view_page);


        mAdapter = new MyAdapter(getSupportFragmentManager());
        viewpage.setAdapter(mAdapter);
        pagetab.setViewPager(viewpage);

        pagetab.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                BaseFragment fragment = FragmentFactory.createFragment(position);
                fragment.loadData();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    class MyAdapter extends FragmentPagerAdapter {

        private String[] mTabNames;

        public MyAdapter(FragmentManager fm) {
            super(fm);
            mTabNames = UIUtils.getStringArray(R.array.tab_names);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTabNames[position];
        }

        @Override
        public Fragment getItem(int position) {
            BaseFragment fragment = FragmentFactory.createFragment(position);
            return fragment;
        }

        @Override
        public int getCount() {
            return mTabNames.length;
        }
    }
}
