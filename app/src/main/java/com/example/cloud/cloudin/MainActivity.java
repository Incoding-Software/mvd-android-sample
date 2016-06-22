package com.example.cloud.cloudin;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cloud.Incoding.JsonModelStateData;
import com.example.cloud.Incoding.IStartSessionCommandListener;
import com.example.cloud.Incoding.StartSessionCommandRequest;
import com.example.cloud.Incoding.StartSessionCommandResponse;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Context context = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       Button  btnSendSession = (Button) findViewById(R.id.btnSendSession);
        btnSendSession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View f) {
                new StartSessionCommandRequest(context)
                        .On(new IStartSessionCommandListener() {
                            @Override
                            public void Success(StartSessionCommandResponse response) {
                                //do domething success
                            }
                            @Override
                            public void Error(JsonModelStateData[] modelState) {

                            }
                        });
            }
        });

    }
}
