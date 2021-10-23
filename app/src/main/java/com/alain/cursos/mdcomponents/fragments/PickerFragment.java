package com.alain.cursos.mdcomponents.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.alain.cursos.mdcomponents.R;
import com.alain.cursos.mdcomponents.utils.Component;
import com.alain.cursos.mdcomponents.utils.Constants;
import com.google.android.material.datepicker.MaterialDatePicker;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class PickerFragment extends Fragment {

    public static final String TAG = "Picker";

    private static Component mInstance;
    Unbinder mUmbinder;

    @BindView(R.id.containerMain)
    LinearLayout containerMain;

    public static Component getmInstance(){
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_picker);
        mInstance.setType(Constants.STATIC);
        return mInstance;
    }

    public PickerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_picker, container, false);
        mUmbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUmbinder.unbind();
    }
    @OnClick({R.id.btnDialog, R.id.btnFullScreen})
    public void onViewClicked(View view){
        switch (view.getId()){
            case R.id.btnDialog:
                MaterialDatePicker.Builder<Long> builder = MaterialDatePicker.Builder.datePicker();
                builder.setTitleText(R.string.picker_title);
                builder.setTheme(R.style.ThemeOverlay_MaterialComponents_MaterialCalendar);
                MaterialDatePicker<?> picker = builder.build();
                picker.show(getFragmentManager(), picker.toString());
                break;
            case R.id.btnFullScreen:
                break;
        }
}