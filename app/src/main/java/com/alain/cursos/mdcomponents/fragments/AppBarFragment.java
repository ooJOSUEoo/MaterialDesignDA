package com.alain.cursos.mdcomponents.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.alain.cursos.mdcomponents.R;
import com.alain.cursos.mdcomponents.utils.Component;
import com.alain.cursos.mdcomponents.utils.Constants;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class AppBarFragment extends Fragment {

    public static final String TAG = "AppBar";

    private static Component mInstance;
    Unbinder mUmbinder;

    public static Component getmInstance(){
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_topappbar);
        mInstance.setType(Constants.STATIC);
        return mInstance;
    }

    public AppBarFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_app_bar, container, false);
        mUmbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUmbinder.unbind();
    }

    @OnClick({R.id.btnTop, R.id.btnBottom})
    public void onViewClicked(View view){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        switch (view.getId()){
            case R.id.btnTop:
                FullScreenDialogFragment TopFragment = new FullScreenDialogFragment();
                TopFragment.show(transaction, FullScreenDialogFragment.TAG);
                break;
            case R.id.btnBottom:
                FullScreenDialogFragment bottomFragment = new FullScreenDialogFragment();
                bottomFragment.show(transaction, FullScreenDialogFragment.TAG);
                break;
        }
    }

}