package com.alain.cursos.mdcomponents.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.alain.cursos.mdcomponents.R;
import com.alain.cursos.mdcomponents.utils.Component;
import com.alain.cursos.mdcomponents.utils.Constants;
import com.buildware.widget.indeterm.IndeterminateCheckBox;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class CheckBoxFragment extends Fragment {

    public static final String TAG = "Checkbox";

    private static Component mInstance;

    Unbinder mUmbinder;
    @BindView(R.id.cbEnable)
    CheckBox cbEnable;
    @BindView(R.id.cbEnableIndeterminate)
    IndeterminateCheckBox cbEnableIndeterminate;

    public static Component getmInstance(){
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_checkboxes);
        mInstance.setType(Constants.SCROLL);
        return mInstance;
    }

    public CheckBoxFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_check_box, container, false);
        mUmbinder = ButterKnife.bind(this, view);

        cbEnable.setOnClickListener(view1 -> {
            String status = cbEnable.isChecked()? "Activo." : "Inactivo";
            Toast.makeText(getActivity(), status, Toast.LENGTH_SHORT).show();

            cbEnableIndeterminate.setIndeterminate(cbEnable.isChecked());
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        mUmbinder.unbind();
    }
}