package com.alain.cursos.mdcomponents.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.alain.cursos.mdcomponents.R;
import com.alain.cursos.mdcomponents.utils.Component;
import com.alain.cursos.mdcomponents.utils.Constants;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public class AlertDialogFragment extends Fragment {

    public static final String TAG = "Dialog";

    private static Component mInstance;
    Unbinder mUmbinder;

    public static Component getmInstance(){
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_dialog_mobile_alert);
        mInstance.setType(Constants.STATIC);
        return mInstance;
    }

    public AlertDialogFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dialog, container, false);
        mUmbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUmbinder.unbind();
    }
}