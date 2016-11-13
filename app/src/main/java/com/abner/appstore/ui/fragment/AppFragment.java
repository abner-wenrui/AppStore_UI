package com.abner.appstore.ui.fragment;

import android.view.View;

import com.abner.appstore.ui.view.LoadingPage;

/**
 * Project   com.abner.appstore.ui.fragment
 *
 * @Author Abner
 * Time   2016/11/2.14:23
 */
public class AppFragment extends BaseFragment {
    @Override
    public View onCreateSuccessView() {
        return null;
    }

    @Override
    public LoadingPage.ResultState onLoad() {
        return LoadingPage.ResultState.STATE_ERROR;
    }
}
