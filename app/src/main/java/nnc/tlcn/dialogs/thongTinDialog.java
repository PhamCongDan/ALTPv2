package nnc.tlcn.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;

import nnc.tlcn.R;

/**
 * Created by GauHeo on 11/7/2017.
 */

public class thongTinDialog extends Dialog {
    Button btnClose;

    public thongTinDialog(Context context) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.thongtin_dialog);
        btnClose= (Button) findViewById(R.id.buttonDong);

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
    }
}
