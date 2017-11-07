package nnc.tlcn.Activity;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import nnc.tlcn.R;
import nnc.tlcn.dialogs.thongBaoDialog;
import nnc.tlcn.layout.tienThuongLayout;


public class PlayerActivity extends Activity implements View.OnClickListener {
    private DrawerLayout drawerLayout;
    private tienThuongLayout tienThuongLayout;
    private LinearLayout layoutPlay;
    private ImageButton btnStop,btnCall, btnKhanGia, btn5050, btnChange;
    private thongBaoDialog thongBaoDialog;
    private Button btnSanSang;

    private DrawerLayout.DrawerListener drawerListener;

    private TextView tvTien;

    private boolean isPlaying;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        thongBaoDialog = new thongBaoDialog(this);

        findViewByIds();
        setEvents();
        loadRules();
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
