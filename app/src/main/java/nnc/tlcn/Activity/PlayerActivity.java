package nnc.tlcn.Activity;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import nnc.tlcn.R;
import nnc.tlcn.dialogs.thongBaoDialog;
import nnc.tlcn.layout.tienThuongLayout;

import static nnc.tlcn.Activity.MainActivity.DATABASE_NAME;
import static nnc.tlcn.Activity.MainActivity.database;


public class PlayerActivity extends Activity implements View.OnClickListener {
    private DrawerLayout drawerLayout;
    private tienThuongLayout tienThuongLayout;
    private LinearLayout layoutPlay;
    private ImageButton btnStop,btnCall, btnKhanGia, btn5050, btnChange;
    private thongBaoDialog thongBaoDialog;
    private Button btnSanSang;

    private DrawerLayout.DrawerListener drawerListener;

    private TextView tvTien,tvcaseA,tvcaseB,tvcaseC,tvcaseD,tvQuestion,tvLevel;
    Animation animSlideToRight;

    private boolean isPlaying;

    boolean clickDapAn=false;
    int cauSo=1,level=1;
    String luaChon="",dapAn="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        thongBaoDialog = new thongBaoDialog(this);

        findViewByIds();
        setEvents();
        loadRules();
        //hienThiCauHoi();
    }

    public PlayerActivity() {

    }

    private void findViewByIds() {
        drawerLayout = (DrawerLayout) findViewById(R.id.activity_player);
        btnSanSang = (Button) findViewById(R.id.btn_sansang);
        tienThuongLayout = (tienThuongLayout) findViewById(R.id.layout_money);

        tienThuongLayout.findViewByIds();
        layoutPlay = (LinearLayout) findViewById(R.id.ln_play);

        btnStop = (ImageButton) findViewById(R.id.btn_stop);
        btnCall=(ImageButton) findViewById(R.id.btn_call);
        btnKhanGia=(ImageButton)findViewById(R.id.btn_khangia) ;
        btn5050=(ImageButton) findViewById(R.id.btn_5050);
        btnChange=(ImageButton) findViewById(R.id.btn_change);

        tvTien=(TextView) findViewById(R.id.tv_tien);
        tvcaseA= (TextView) findViewById(R.id.tv_case_a);
        tvcaseB= (TextView) findViewById(R.id.tv_case_b);
        tvcaseC= (TextView) findViewById(R.id.tv_case_c);
        tvcaseD= (TextView) findViewById(R.id.tv_case_d);
        tvQuestion= (TextView) findViewById(R.id.tv_question);
        tvLevel= (TextView) findViewById(R.id.tv_level);
        //anh xa anim
        animSlideToRight= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_to_right);


        drawerListener = new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {


            }

            @Override
            public void onDrawerOpened(View drawerView) {
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                drawerLayout.removeDrawerListener(drawerListener);

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        };

    }
    private void loadRules() {
        drawerLayout.openDrawer(GravityCompat.START);
        //thongBaoDialog.setCancelable(true);

    }
    private void setEvents(){
        btnSanSang.setOnClickListener(this);

        btnStop.setOnClickListener(this);
        btnCall.setOnClickListener(this);
        btnKhanGia.setOnClickListener(this);
        btnChange.setOnClickListener(this);
        btn5050.setOnClickListener(this);


        //layoutPlay.setVisibility(View.GONE);
        tvTien.setText("0");
        tvcaseA.setOnClickListener(this);
        tvcaseB.setOnClickListener(this);
        tvcaseC.setOnClickListener(this);
        tvcaseD.setOnClickListener(this);

    }

    public void stop() {
        thongBaoDialog.setCancelable(true);
        thongBaoDialog.setNotification("Cảm ơn bạn đã đến với chúng tôi ?", "Đồng ý", "Hủy bỏ", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.btn_ok) {
                    thongBaoDialog.dismiss();
                    stopThread();
                    finish();
                }
                thongBaoDialog.dismiss();
            }
        });
        thongBaoDialog.show();
    }
    public void sanSang(){

        thongBaoDialog.setCancelable(true);
        thongBaoDialog.setNotification("Bạn đã sẵn sàng chưa ?", "Sẵn sàng", "Hủy bỏ", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.btn_ok) {
                    thongBaoDialog.dismiss();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    hienThiCauHoi();
                }
                thongBaoDialog.dismiss();
            }
        });
        thongBaoDialog.show();
    }
    public void comingsoon(){
        thongBaoDialog.setCancelable(true);
        thongBaoDialog.setNotification("Coming Soon", "Ok", "Hủy bỏ", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.btn_ok) {
                    thongBaoDialog.dismiss();
                }
                thongBaoDialog.dismiss();
            }
        });
        thongBaoDialog.show();
    }
    private void xuLyChonDapAn(final View view){
        if(!clickDapAn) {
            clickDapAn=true;
            view.setBackgroundResource(R.drawable.player_answer_background_selected);
            new CountDownTimer(4000, 4000) {
                @Override
                public void onTick(long l) {

                }

                @Override
                public void onFinish() {
                    new CountDownTimer(4500, 500) {
                        boolean green=false;
                        @Override

                        public void onTick(long l) {
                            //tra loi dung thi txt doi mau green-blue
                            if(luaChon.equals(dapAn)) {

                                if (!green) {
                                    green = true;
                                    view.setBackgroundResource(R.drawable.player_answer_background_true);
                                } else {
                                    view.setBackgroundResource(R.drawable.player_answer_background_selected);
                                    green = false;
                                }
                            }
                            //tra loi sai
                            else
                            {

                                if (!green) {

                                    green = true;
                                    switch (dapAn){
                                        case "A":
                                            tvcaseA.setBackgroundResource(R.drawable.player_answer_background_true);
                                            break;
                                        case "B":
                                            tvcaseB.setBackgroundResource(R.drawable.player_answer_background_true);
                                            break;
                                        case "C":
                                            tvcaseC.setBackgroundResource(R.drawable.player_answer_background_true);
                                            break;
                                        case "D":
                                            tvcaseD.setBackgroundResource(R.drawable.player_answer_background_true);
                                            break;


                                    }

                                } else {

                                    switch (dapAn) {
                                        case "A":
                                            tvcaseA.setBackgroundResource(R.drawable.player_answer_background_normal);
                                            break;
                                        case "B":
                                            tvcaseB.setBackgroundResource(R.drawable.player_answer_background_normal);
                                            break;
                                        case "C":
                                            tvcaseC.setBackgroundResource(R.drawable.player_answer_background_normal);
                                            break;
                                        case "D":
                                            tvcaseD.setBackgroundResource(R.drawable.player_answer_background_normal);
                                            break;
                                    }
                                    green=false;
                                }
                            }
                        }

                        @Override
                        public void onFinish() {
                            //neu tra loi dung thi hien tien thuong layout sau do wa cau tiep theo
                            drawerLayout.startAnimation(animSlideToRight);
                            //tra ve trang thai ban dau
                            tvcaseA.setBackgroundResource(R.drawable.player_answer_background_normal);
                            tvcaseB.setBackgroundResource(R.drawable.player_answer_background_normal);
                            tvcaseC.setBackgroundResource(R.drawable.player_answer_background_normal);
                            tvcaseD.setBackgroundResource(R.drawable.player_answer_background_normal);

                            //

                            cauSo++;
                            if (cauSo==6)level=2;
                            if(cauSo==10)level=3;

                            tvLevel.setText("cau so "+cauSo);
                            Toast.makeText(getApplicationContext(),""+level,Toast.LENGTH_SHORT).show();
                            hienThiCauHoi();




                            //neu tra loi sai thi hien cho luu diem




//                            layoutCauHoi.startAnimation(animationSlidetoLeft);
//                            //
//                            layoutCauHoi.setVisibility(View.GONE);
//                            causo++;
//
//
//                            layoutCauHoi.setVisibility(View.VISIBLE);
//                            tvQuestion.setText("Câu số "+causo);
//                            layoutCauHoi.startAnimation(animationSlidefromRight);
//                            hienThiCauHoi();
//                            btnA.setBackgroundResource(R.drawable.custom_btn);
//                            btnB.setBackgroundResource(R.drawable.custom_btn);
//                            btnC.setBackgroundResource(R.drawable.custom_btn);
//                            btnD.setBackgroundResource(R.drawable.custom_btn);
                            clickDapAn=false;
                        }
                    }.start();
                }
            }.start();

        }
    }
    private void hienThiCauHoi(){
        //mở csdl
        Toast.makeText(getApplicationContext(),""+cauSo,Toast.LENGTH_SHORT).show();
        database=openOrCreateDatabase(DATABASE_NAME,MODE_PRIVATE,null);
        Cursor cursor = database.rawQuery("SELECT * FROM CauHoi where level="+level+" ORDER BY RANDOM() LIMIT 1;", null);

        if(cursor.moveToNext()){

            tvQuestion.setText("Câu số "+cauSo+"\n"+cursor.getString(1));
            tvcaseA.setText("A. "+cursor.getString(2));
            tvcaseB.setText("B. "+cursor.getString(3));
            tvcaseC.setText("C. "+cursor.getString(4));
            tvcaseD.setText("D. "+cursor.getString(5));
            dapAn=cursor.getString(6);

        }
        cursor.close();



    }




    @Override
    public void onClick(final View v) {
        switch (v.getId()) {


            case R.id.btn_stop:
                stopGame();
                break;
            case R.id.iv_player:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.btn_sansang:
                //drawerLayout.closeDrawer(GravityCompat.START);
                sanSang();
                break;
            case R.id.btn_change:
                comingsoon();
                break;
            case R.id.btn_5050:
                comingsoon();
                break;
            case R.id.btn_khangia:
                comingsoon();
                break;
            case R.id.btn_call:
                comingsoon();
                break;
            case R.id.tv_case_a:
                luaChon="A";
                xuLyChonDapAn(tvcaseA);
                break;
            case R.id.tv_case_b:
                luaChon="B";
                xuLyChonDapAn(tvcaseB);
                break;
            case R.id.tv_case_c:
                luaChon="C";
                xuLyChonDapAn(tvcaseC);
                break;
            case R.id.tv_case_d:
                luaChon="D";
                xuLyChonDapAn(tvcaseD);
                break;
            default:
                break;
        }
    }


    public void stopGame() {
        thongBaoDialog.setCancelable(true);
        thongBaoDialog.setNotification("Bạn thực sự muốn dừng cuộc chơi ?", "Đồng ý", "Hủy bỏ", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.btn_ok) {
                    stopThread();
                    finish();
                }
                thongBaoDialog.dismiss();
            }
        });
        thongBaoDialog.show();
    }

    public void stopThread() {
        isPlaying = false;
        Thread.currentThread().interrupt();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }


    @Override
    protected void onResume() {
        super.onResume();
    }


}
