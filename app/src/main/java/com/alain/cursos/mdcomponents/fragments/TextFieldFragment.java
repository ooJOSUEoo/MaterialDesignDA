package com.alain.cursos.mdcomponents.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.alain.cursos.mdcomponents.R;
import com.alain.cursos.mdcomponents.utils.Component;
import com.alain.cursos.mdcomponents.utils.Constants;

import butterknife.Unbinder;


public class TextFieldFragment extends Fragment {

    public static final String TAG = "Text Fields";

    private static Component mInstance;

    Unbinder mUmbinder;

    public static Component getmInstance(){
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_textfields_outlined_active);
        mInstance.setType(Constants.SCROLL);
        return mInstance;
    }

    public TextFieldFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_text_field, container, false);
    }
}