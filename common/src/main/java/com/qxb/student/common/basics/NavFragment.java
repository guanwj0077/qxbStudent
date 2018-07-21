package com.qxb.student.common.basics;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.qxb.student.common.module.bean.attr.NavAttr;

import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.NavHost;
import androidx.navigation.Navigation;
import androidx.navigation.Navigator;
import androidx.navigation.fragment.FragmentNavigator;
import androidx.navigation.fragment.NavHostFragment;

/**
 * 自定导航宿主
 * 处理不需要默认Destination,可跳转指定fragment
 *
 * @author winky
 * @date 2018/7/20
 */
public class NavFragment extends Fragment implements NavHost {

    private static final String KEY_NAV_CONTROLLER_STATE = "android-support-nav:fragment:navControllerState";

    private NavController mNavController;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Context context = requireContext();

        mNavController = new NavController(context);
        mNavController.getNavigatorProvider().addNavigator(createFragmentNavigator());

        Bundle navState = null;
        if (savedInstanceState != null) {
            navState = savedInstanceState.getBundle(KEY_NAV_CONTROLLER_STATE);
        }
        if (navState != null) {
            mNavController.restoreState(navState);
        } else {
            navigation();
        }
    }

    private void navigation() {
        NavAttr navAttr = null;
        if (getArguments() != null) {
            navAttr = getArguments().getParcelable(NavAttr.TAG);
        }
        if (navAttr == null) {
            throw new IllegalArgumentException("Navigation input can not be empty");
        }
        final int graphId = navAttr.getGraphResId();
        if (graphId != 0) {
            NavGraph navGraph = mNavController.getNavInflater().inflate(graphId);
            int navId = navAttr.getNavigationId();
            if (navId != 0) {
                navGraph.setStartDestination(navId);
            }
            NavDestination destination = navGraph.findNode(navGraph.getStartDestination());
            if (destination != null && navAttr.getBundle() != null) {
                destination.setDefaultArguments(navAttr.getBundle());
            }
            mNavController.setGraph(navGraph);
        } else {
            mNavController.setMetadataGraph();
        }
    }

    @NonNull
    protected Navigator<? extends FragmentNavigator.Destination> createFragmentNavigator() {
        return new FragmentNavigator(requireContext(), getChildFragmentManager(), getId());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        FrameLayout frameLayout = new FrameLayout(inflater.getContext());
        frameLayout.setId(getId());
        return frameLayout;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (!(view instanceof ViewGroup)) {
            throw new IllegalStateException("created host view " + view + " is not a ViewGroup");
        }
        View rootView = view.getParent() != null ? (View) view.getParent() : view;
        Navigation.setViewNavController(rootView, mNavController);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Bundle navState = mNavController.saveState();
        if (navState != null) {
            outState.putBundle(KEY_NAV_CONTROLLER_STATE, navState);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @NonNull
    public static NavController findNavController(@NonNull Fragment fragment) {
        Fragment findFragment = fragment;
        while (findFragment != null) {
            if (findFragment instanceof NavHostFragment) {
                return ((NavHostFragment) findFragment).getNavController();
            }
            Fragment primaryNavFragment = findFragment.requireFragmentManager()
                    .getPrimaryNavigationFragment();
            if (primaryNavFragment instanceof NavHostFragment) {
                return ((NavHostFragment) primaryNavFragment).getNavController();
            }
            findFragment = findFragment.getParentFragment();
        }

        View view = fragment.getView();
        if (view != null) {
            return Navigation.findNavController(view);
        }
        throw new IllegalStateException("Fragment " + fragment
                + " does not have a NavController set");
    }

    @NonNull
    @Override
    public NavController getNavController() {
        if (mNavController == null) {
            throw new IllegalStateException("NavController is not available before onCreate()");
        }
        return mNavController;
    }

    public static NavFragment create(@NonNull Bundle bundle) {
        final NavFragment fragment = new NavFragment();
        fragment.setArguments(bundle);
        return fragment;
    }
}
