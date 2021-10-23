package com.alain.cursos.mdcomponents.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.alain.cursos.mdcomponents.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class AppBarTopFragment extends DialogFragment {

    public static final String TAG = "FullScreenDialogFragment";

    Unbinder mUmbinder;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    public AppBarTopFragment() {
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
        View view = inflater.inflate(R.layout.fragment_app_bar_top, container, false);
        mUmbinder = ButterKnife.bind(this, view);

        toolbar.setNavigationOnClickListener(view1 -> dismiss());

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUmbinder.unbind();
    }
}