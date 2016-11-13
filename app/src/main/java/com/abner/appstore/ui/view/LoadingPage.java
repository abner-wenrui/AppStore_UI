package com.abner.appstore.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.abner.appstore.R;
import com.abner.appstore.utils.UIUtils;

/**
 * Project   com.abner.appstore.ui.view
 *
 * @Author Abner
 * Time   2016/11/2.16:26
 */

public abstract class LoadingPage extends FrameLayout {

    private static final int STATE_LOAD_UNDO = 1;
    private static final int STATE_LOAD_LOADING = 2;
    private static final int STATE_LOAD_ERROR = 3;
    private static final int STATE_LOAD_EMPTY = 4;
    private static final int STATE_LOAD_SUCCESS = 5;
    private int mCurrentState = STATE_LOAD_UNDO;
    private View mLoadingPage;
    private View mErrorPage;
    private View mEmptyPage;
    private View mSuccessPage;

    public LoadingPage(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public LoadingPage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    public LoadingPage(Context context) {
        super(context);
        initView();
    }

    private void initView() {
        if (mLoadingPage == null) {
            mLoadingPage = UIUtils.inflate(R.layout.page_loading);
            addView(mLoadingPage);
        }

        if (mErrorPage == null) {
            mErrorPage = UIUtils.inflate(R.layout.page_error);
            addView(mErrorPage);
        }

        if (mEmptyPage == null) {
            mEmptyPage = UIUtils.inflate(R.layout.page_empty);
            addView(mEmptyPage);
        }

        showRightPage();
    }

    private void showRightPage() {
        mLoadingPage.setVisibility((mCurrentState == STATE_LOAD_UNDO || mCurrentState == STATE_LOAD_LOADING) ? View.VISIBLE : View.GONE);
        mErrorPage.setVisibility((mCurrentState == STATE_LOAD_ERROR) ? View.VISIBLE : View.GONE);
        mEmptyPage.setVisibility((mCurrentState == STATE_LOAD_EMPTY) ? View.VISIBLE : View.GONE);

        if (mSuccessPage == null && mCurrentState == STATE_LOAD_SUCCESS) {
            mSuccessPage = onCreateSuccessView();
            if (mSuccessPage != null) {
                addView(mSuccessPage);
            }
        }

        if (mSuccessPage != null) {
            mSuccessPage.setVisibility((mCurrentState == STATE_LOAD_SUCCESS) ? View.VISIBLE : View.GONE);
        }
    }

    public void loadData() {
        if (mCurrentState != STATE_LOAD_LOADING) {
            mCurrentState = STATE_LOAD_LOADING;
            new Thread() {
                @Override
                            public void run() {
                                final ResultState resultState = onLoad();
                                UIUtils.runOnMainThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        if (resultState != null) {
                                            mCurrentState = resultState.getState();
                                            showRightPage();
                                        }
                        }
                    });
                }
            }.start();
        }
    }

    //加载成功后显示布局
    public abstract View onCreateSuccessView();

    //加载网络数据
    public abstract ResultState onLoad();

    public enum ResultState {
        STATE_SUCCESS(STATE_LOAD_SUCCESS), STATE_EMPTY(STATE_LOAD_EMPTY), STATE_ERROR(STATE_LOAD_ERROR);
        private int state;

        private ResultState(int state) {
            this.state = state;
        }

        public int getState() {
            return state;
        }
    }

}
