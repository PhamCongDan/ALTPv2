package nnc.tlcn.Activity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import nnc.tlcn.R;
import nnc.tlcn.dialogs.thongBaoDialog;
import nnc.tlcn.fragments.HomeFragment;

public class MainActivity extends AppCompatActivity {
    public static String DATABASE_NAME="ALTPdb.sqlite";
    private static final String DB_PATH_SUFFIX="/databases/";
    public static SQLiteDatabase  database=null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        setContentView(R.layout.activity_main);

        saoChepCSDL();
        initComponents();


    }

    private void initComponents() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.bg_circle_rotate);
        animation.setDuration(3000);
        findViewById(R.id.load).startAnimation(animation);
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
                .replace(R.id.frame_main, new HomeFragment())
                .commit();
    }

    @Override
    public void onBackPressed() {
        final thongBaoDialog thongBaoDialog = new thongBaoDialog(this);
        thongBaoDialog.setCancelable(true);
        thongBaoDialog.setNotification("Bạn muốn thoát trò chơi ?", "Đồng ý", "Hủy", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.btn_ok) {
                    finish();

                }
                thongBaoDialog.dismiss();
            }
        });
        thongBaoDialog.show();
    }
    //lần đầu chạy thì chạy 3 hàm này để kêt nối db
    private void saoChepCSDL(){

        File dbFile=getDatabasePath(DATABASE_NAME);

        //if(!dbFile.exists()){
        try{

            CopyDatabaseFromAsset();
            Toast.makeText(this,"copy thành công",Toast.LENGTH_SHORT).show();
        }
        catch (Exception e)
        {
            Toast.makeText(this,""+e.toString(),Toast.LENGTH_SHORT).show();
        }
        // }

    }

    private void CopyDatabaseFromAsset() {
        try{
            InputStream myInput=getAssets().open(DATABASE_NAME);
            String outFileName=layDuongDan();
            //kiem tra
            File f=new File(getApplicationInfo().dataDir+DB_PATH_SUFFIX);
            if(!f.exists()){
                f.mkdir();

            }

            OutputStream myOutput=new FileOutputStream(outFileName);
            //
            byte[] buffer=new byte[1024];
            int lenght;
            while((lenght=myInput.read(buffer))>0){
                myOutput.write(buffer,0,lenght);
            }
            //close stream
            myOutput.flush();
            myOutput.close();
            myInput.close();


        }catch (Exception ex){
            Log.e("",ex.toString());
        }
    }

    private String layDuongDan(){
        return getApplicationInfo().dataDir+DB_PATH_SUFFIX+DATABASE_NAME;
    }
}
