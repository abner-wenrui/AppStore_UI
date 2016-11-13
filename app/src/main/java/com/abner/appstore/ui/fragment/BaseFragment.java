package com.abner.appstore.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abner.appstore.ui.view.LoadingPage;
import com.abner.appstore.utils.UIUtils;

/**
 * Project   com.abner.appstore.ui.fragment
 *
 * @Author Abner
 * Time   2016/11/2.14:20
 */

public abstract class BaseFragment extends Fragment {

    private LoadingPage mLoadingPage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mLoadingPage = new LoadingPage(UIUtils.getContext()) {
            @Override
            public View onCreateSuccessView() {
                return BaseFragment.this.onCreateSuccessView();
            }

            @Override
            public ResultState onLoad() {
                return BaseFragment.this.onLoad();
            }
        };
        return mLoadingPage ;
    }

    public abstract View onCreateSuccessView();
    public abstract LoadingPage.ResultState onLoad();

    public void loadData(){
        if (mLoadingPage != null){
            mLoadingPage.loadData();
        }
    }
}
