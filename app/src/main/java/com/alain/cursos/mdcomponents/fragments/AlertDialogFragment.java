package com.alain.cursos.mdcomponents.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.alain.cursos.mdcomponents.R;
import com.alain.cursos.mdcomponents.utils.Component;
import com.alain.cursos.mdcomponents.utils.Constants;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import butterknife.ButterKnife;
import butterknife.OnClick;
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

    @OnClick(R.id.btnDialogInfo)
    public void onInfoClicked(){
        new MaterialAlertDialogBuilder(getActivity())
                .setTitle(R.string.card_message_demo_small)
                .setPositiveButton(R.string.dialog_ok, null)
                .show();
    }

    @OnClick(R.id.btnDialogChooser)
    public void onChooserClicked(){
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.select_dialog_item);
        adapter.add("Opción 1");
        adapter.add("Opción 2");
        adapter.add("Opción 3");
        new MaterialAlertDialogBuilder(getActivity())
                .setTitle(R.string.dialog_chooser)
                .setAdapter(adapter, (dialogInterface, i) ->
                        Toast.makeText(getActivity(), adapter.getItem(i),Toast.LENGTH_SHORT))
                .show();
    }

    @OnClick(R.id.btnDialogConfirm)
    public void onConfirmClicked(){
        //new MaterialAlertDialogBuilder(getActivity())
        //new MaterialAlertDialogBuilder(getActivity(), R.style.ThemeOverlay_MaterialComponents_Dialog)
        new MaterialAlertDialogBuilder(getActivity(), R.style.MaterialAlertDialog_MaterialComponents_Title_Icon)
                .setTitle(R.string.dialog_confirm_title)
                .setMessage(R.string.card_message_demo_small)
                .setPositiveButton(R.string.dialog_confirm, (dialogInterface, i) ->
                        Toast.makeText(getActivity(), R.string.message_action_success, Toast.LENGTH_SHORT).show())
                .setNegativeButton(R.string.dialog_cancel, null)
                .show();
    }

    @OnClick(R.id.btnDialogFullScreen)
    public void onFullScreenClicked(){
        FullScreenDialogFragment dialogFragment = new FullScreenDialogFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        dialogFragment.show(transaction, FullScreenDialogFragment.TAG);
    }
}