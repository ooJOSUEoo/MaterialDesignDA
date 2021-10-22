package com.alain.cursos.mdcomponents.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.alain.cursos.mdcomponents.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class FullScreenDialogFragment extends DialogFragment {

    public static final String TAG = "FullScreenDialogFragment";

    //private static Component mInstance;
    Unbinder mUmbinder;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    /*public static Component getmInstance(){
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_dialog_mobile_alert);
        mInstance.setType(Constants.STATIC);
        return mInstance;
    }*/

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialog);
    }

    public FullScreenDialogFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_full_screen_dialog, container, false);
        mUmbinder = ButterKnife.bind(this, view);

        toolbar.setNavigationIcon(R.drawable.ic_close);
        toolbar.setNavigationOnClickListener(view1 -> dismiss());
        toolbar.setTitle(R.string.dialog_full_screen);

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUmbinder.unbind();
    }

    @OnClick(R.id.btnSave)
    public  void  onViewClicked(){
        Toast.makeText(getActivity(), R.string.message_action_success, Toast.LENGTH_SHORT).show();
        dismiss();
    }
}