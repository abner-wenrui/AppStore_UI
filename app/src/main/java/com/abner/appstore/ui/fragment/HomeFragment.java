package com.abner.appstore.ui.fragment;

import android.view.View;
import android.widget.TextView;

import com.abner.appstore.ui.view.LoadingPage;
import com.abner.appstore.utils.UIUtils;

/**
 * Project   com.abner.appstore.ui.fragment
 *
 * @Author Abner
 * Time   2016/11/2.14:22
 */
public class HomeFragment extends BaseFragment {
    @Override
    public View onCreateSuccessView() {
        TextView textView = new TextView(UIUtils.getContext());
        textView.setText(getClass().getSimpleName().toString());
        return textView;
    }

    @Override
    public LoadingPage.ResultState onLoad() {
        return LoadingPage.ResultState.STATE_SUCCESS;
    }
}
