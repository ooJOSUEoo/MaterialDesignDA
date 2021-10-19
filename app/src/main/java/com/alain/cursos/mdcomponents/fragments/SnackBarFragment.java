package com.alain.cursos.mdcomponents.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.fragment.app.Fragment;

import com.alain.cursos.mdcomponents.R;
import com.alain.cursos.mdcomponents.utils.Component;
import com.alain.cursos.mdcomponents.utils.Constants;
import com.google.android.material.snackbar.Snackbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class SnackBarFragment extends Fragment {

    public static final String TAG = "Snackbar";

    private static Component mInstance;

    Unbinder mUmbinder;
    @BindView(R.id.containerMain)
    FrameLayout containerMain;

    public static Component getmInstance(){
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_singleline_action);
        mInstance.setType(Constants.STATIC);
        return mInstance;
    }

    public SnackBarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_snack_bar, container, false);
        mUmbinder = ButterKnife.bind(this, view);

        Snackbar.make(containerMain, R.string.message_action_success, Snackbar.LENGTH_LONG)
                .setAction("Volver", view1 -> getActivity().finish())
                .show();

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUmbinder.unbind();
    }
}