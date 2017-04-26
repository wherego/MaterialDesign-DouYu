package com.jiezzzo.douyu.common.base;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiezzzo.douyu.AppApplication;
import com.jiezzzo.douyu.AppComponent;
import com.trello.rxlifecycle2.components.support.RxFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by oaier on 2017/4/24.
 */

public abstract class RxBaseLazyFragment extends RxFragment {

    private View mView;

    private FragmentActivity mActivity;

    //是否初始化完成
    protected boolean isPrepared;

    //fragment是否可见
    protected boolean isVisible;

    private Unbinder mUnbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(setContentView(), container, false);
        mActivity = getSupportActivity();
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUnbinder = ButterKnife.bind(this, view);
        setupFragmentAppComponent(AppApplication.get(getApplicationContext()).getAppComponent());
        if (savedInstanceState == null) {
            firstInit();
        }
        initViews(savedInstanceState);
    }

    @LayoutRes
    protected abstract int setContentView();

    protected abstract void initViews(Bundle savedInstanceState);

    protected void setupFragmentAppComponent(AppComponent appComponent){}

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity = (FragmentActivity) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.mActivity = null;
    }

    public FragmentActivity getSupportActivity() {

        return super.getActivity();
    }

    public Context getApplicationContext() {

        return this.mActivity == null
                ? (getActivity() == null ? null :
                getActivity().getApplicationContext())
                : this.mActivity.getApplicationContext();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    protected void firstInit(){}
    protected void onInvisible() {}
    protected void onVisible(){
        lazyLoad();
    }
    protected void lazyLoad() {}
    protected void loadData(){}
    protected void showProgressBar(){}
    protected void hideProgressBar(){}
    protected void initRecyclerView(){}
    protected void initRefreshLayout(){}
    protected void refreshFinish(){}

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
