package nnc.tlcn.dialogs;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import nnc.tlcn.R;


public class diemSoDialog extends Dialog implements View.OnClickListener {
    private int score;
    private EditText edtName;
    private TextView tvScore;



    public diemSoDialog(Context context) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.diemso_dialog);
        getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        edtName = (EditText) findViewById(R.id.edt_name);
        tvScore = (TextView) findViewById(R.id.tv_score);
        findViewById(R.id.btn_ok).setOnClickListener(this);



    }

    public void setScore(String score) {
        tvScore.setText(score + " VNĐ");
        this.score = Integer.parseInt(score.replaceAll(",", ""));
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_ok){
            if (edtName.getText().toString().isEmpty()) {
                return;
            }
            ContentValues values = new ContentValues();
            values.put("Name", edtName.getText().toString().trim());
            values.put("Score", score);
            dismiss();

        }
    }

}
