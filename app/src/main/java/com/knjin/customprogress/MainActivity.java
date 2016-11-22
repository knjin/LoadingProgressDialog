package com.knjin.customprogress;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import pl.tajchert.sample.DotsTextView;

public class MainActivity extends AppCompatActivity {
    DotsTextView dotsTextView;
    Button btn;
    Button load;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dotsTextView = (DotsTextView) findViewById(R.id.dots);
        btn  = (Button) findViewById(R.id.btn);
        load = (Button) findViewById(R.id.loading);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dotsTextView.isPlaying()) {
                    dotsTextView.stop();
                }else {
                    dotsTextView.start();
                }
            }
        });
        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomProgress.show(MainActivity.this, "加载中...", true, new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        Toast.makeText(MainActivity.this, "你好", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
