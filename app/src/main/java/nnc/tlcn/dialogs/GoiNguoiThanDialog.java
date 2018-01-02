package nnc.tlcn.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import nnc.tlcn.R;

/**
 * Created by Dan Pham on 01/02/2018.
 */

public class GoiNguoiThanDialog extends Dialog implements View.OnClickListener {
    ImageButton btn1,btn2,btn3,btn4;
    TextView txtGoiY;
    Button btnClose;
    boolean flag=false;
    public GoiNguoiThanDialog(Context context) {

        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.goinguoithan_dialog);
        getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        btn1= (ImageButton) findViewById(R.id.btnPerson1);
        btn2= (ImageButton) findViewById(R.id.btnPerson2);
        btn3= (ImageButton) findViewById(R.id.btnPerson3);
        btn4= (ImageButton) findViewById(R.id.btnPerson4);
        btnClose= (Button) findViewById(R.id.btn_close);
        txtGoiY= (TextView) findViewById(R.id.txtGoiY);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btnClose.setOnClickListener(this);




    }
    public void getDapAn(int a){
        switch (a){
            case 0: txtGoiY.setText("Theo tôi đáp án là A");
                break;
            case 1: txtGoiY.setText("Theo tôi đáp án là B");
                break;
            case 2: txtGoiY.setText("Theo tôi đáp án là C");
                break;
            case 3: txtGoiY.setText("Theo tôi đáp án là D");
                break;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnPerson1:
                flag=true;
                txtGoiY.setVisibility(View.VISIBLE);
                break;
            case R.id.btnPerson2:
                flag=true;
                txtGoiY.setVisibility(View.VISIBLE);
                break;
            case R.id.btnPerson3:
                flag=true;
                txtGoiY.setVisibility(View.VISIBLE);
                break;
            case R.id.btnPerson4:
                flag=true;
                txtGoiY.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_close:
                onBackPressed();
                break;
            default:break;
        }
    }
}
