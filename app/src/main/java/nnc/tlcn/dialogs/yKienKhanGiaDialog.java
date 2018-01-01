package nnc.tlcn.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import nnc.tlcn.R;

/**
 * Created by Dan Pham on 12/05/2017.
 */

public class yKienKhanGiaDialog extends Dialog {
    ProgressBar caseA,caseB,caseC,caseD;
    TextView txtA,txtB,txtC,txtD;
    Button btnDong;
    public yKienKhanGiaDialog(Context context) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.ykienkhangia_dialog);
        getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        caseA= (ProgressBar) findViewById(R.id.dapanA);
        caseB= (ProgressBar) findViewById(R.id.dapanB);
        caseC= (ProgressBar) findViewById(R.id.dapanC);
        caseD= (ProgressBar) findViewById(R.id.dapanD);

        txtA= (TextView) findViewById(R.id.txtA);
        txtB= (TextView) findViewById(R.id.txtB);
        txtC= (TextView) findViewById(R.id.txtC);
        txtD= (TextView) findViewById(R.id.txtD);


        btnDong= (Button) findViewById(R.id.btn_close);

        caseA.setMax(100);


        caseA.setProgress(12);


        btnDong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();

            }
        });
    }
    public void setTyLe(int cauA,int cauB,int cauC,int cauD){
        caseA.setProgress(cauA);
        txtA.setText(cauA+"%");

        caseB.setProgress(cauB);
        txtB.setText(cauB+"%");

        caseC.setProgress(cauC);
        txtC.setText(cauC+"%");

        caseD.setProgress(cauD);
        txtD.setText(cauD+"%");
    }





}
