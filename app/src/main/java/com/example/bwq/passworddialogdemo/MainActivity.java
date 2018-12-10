package com.example.bwq.passworddialogdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bwq.passworddialogdemo.dialog.PayPwdDialog;

public class MainActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tv);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new PayPwdDialog(MainActivity.this, "3").setListener(new PayPwdDialog.PwdFullListener() {
                    @Override
                    public void pwdFull(String pwd) {
                        Toast.makeText(MainActivity.this, pwd, Toast.LENGTH_LONG).show();
                    }
                }).show();
            }
        });
    }
}
