package nnc.tlcn.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import nnc.tlcn.Activity.PlayerActivity;
import nnc.tlcn.R;
import nnc.tlcn.dialogs.DiemCaoDialog;
import nnc.tlcn.dialogs.diemSoDialog;
import nnc.tlcn.dialogs.thongTinDialog;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.bg_circle_rotate);
        (view.findViewById(R.id.bg_circle_anim)).setAnimation(animation);
        view.findViewById(R.id.btn_setting).setOnClickListener(this);
        view.findViewById(R.id.btn_play).setOnClickListener(this);
        view.findViewById(R.id.btn_high_score).setOnClickListener(this);
        view.findViewById(R.id.btn_about).setOnClickListener(this);

        return view;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
            }
        }, 2500);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_setting:
                DiemCaoDialog diemCaoDialog=new DiemCaoDialog(getContext());
                diemCaoDialog.show();
                break;

            case R.id.btn_play:
                Intent intent1 = new Intent(getContext(), PlayerActivity.class);
                startActivity(intent1);
                break;
            case R.id.btn_high_score:
                diemSoDialog diemSoDialog=new diemSoDialog(getContext());
                diemSoDialog.show();
                break;

            case R.id.btn_about:
                thongTinDialog thongTinDialog = new thongTinDialog(getContext());
                thongTinDialog.show();
                break;

                default:
                break;

        }
    }
}
