package com.qxb.student.common.basics;

import android.arch.lifecycle.HolderFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.qxb.student.common.listener.IBinding;
import com.qxb.student.common.utils.NavigationUtils;

import java.lang.ref.WeakReference;
import java.util.Objects;

/**
 * fragment基类
 * @author winky
 */
public abstract class BaseFragment extends HolderFragment implements IBinding {

    private WeakReference<Fragment> weakReference = null;
    private View contentView;
    private String title;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        weakReference = new WeakReference<Fragment>(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        contentView = inflater.inflate(bindLayout(), container, false);
        init(contentView, savedInstanceState);
        return contentView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    /**
     * 使用fragment的menu
     */
    public void setSupportActionBar(Toolbar toolbar) {
        ((AppCompatActivity) Objects.requireNonNull(getActivity())).setSupportActionBar(toolbar);
        setHasOptionsMenu(true);
    }

    /**
     * 视图是否已经对用户可见，系统的方法
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
    }

    public Fragment getFragment() {
        return weakReference.get();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        weakReference.clear();
        weakReference = null;
    }

    public <T extends View> T findViewById(@IdRes int id) {
        return contentView.findViewById(id);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        contentView = null;
    }

    public String getTitle() {
        return title;
    }

    public BaseFragment setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            if (!NavigationUtils.getInstance().goBack(getFragment())) {
                Objects.requireNonNull(getActivity()).finish();
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
