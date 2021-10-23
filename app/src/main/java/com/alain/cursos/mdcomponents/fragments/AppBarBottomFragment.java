package com.alain.cursos.mdcomponents.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.DialogFragment;

import com.alain.cursos.mdcomponents.R;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class AppBarBottomFragment extends DialogFragment {

    public static final String TAG = "AppBarBottomFragment";

    Unbinder mUmbinder;

    private  boolean isCentered;

    @BindView(R.id.bottom_app_bar)
    BottomAppBar bottom_app_bar;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.containerMain)
    CoordinatorLayout containerMain;

    public AppBarBottomFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialog);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_app_bar_bottom, container, false);
        mUmbinder = ButterKnife.bind(this, view);

        bottom_app_bar.setOnMenuItemClickListener(item -> {
            int resMessage;
            switch (item.getItemId()){
                case R.id.action_favorites:
                    resMessage = R.string.menu_favorites;
                    break;
                case R.id.action_profile:
                    resMessage = R.string.menu_profile;
                    break;
                default:
                    resMessage = R.string.menu_start;
                    break;
            }
            Snackbar.make(containerMain, resMessage, Snackbar.LENGTH_LONG)
                    .setAnchorView(fab)
                    .show();

            return true;
        });

        bottom_app_bar.setNavigationOnClickListener(view1 -> {
            Snackbar.make(containerMain, R.string.message_action_success, Snackbar.LENGTH_LONG)
                    .setAnchorView(fab)
                    .show();
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUmbinder.unbind();
    }

    @OnClick(R.id.fab)
    public void onViewClicked(){
        if (isCentered){
            bottom_app_bar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_END);
        }else {
            bottom_app_bar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_CENTER);
        }
        isCentered = !isCentered;
    }
}