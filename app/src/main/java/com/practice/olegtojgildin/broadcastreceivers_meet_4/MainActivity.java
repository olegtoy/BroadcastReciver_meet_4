package com.practice.olegtojgildin.broadcastreceivers_meet_4;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.support.v4.content.LocalBroadcastManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private CustomBroadcastReceiver mReciver;
    private IntentFilter mIntentFilter;
    TextView textView;
    Button changeStatus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initviews();
        initListener();
        init();
    }

    public void init() {
        mReciver = new CustomBroadcastReceiver(new ViewCallbackImpl());
        mIntentFilter = new IntentFilter("com.practice.olegtojgildin.SEND_MESSAGES_FILTER");
    }

    public void initviews() {
        textView = findViewById(R.id.Status);
        changeStatus = findViewById(R.id.changeStatus);
    }

    public void initListener() {

        changeStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(MyIntentService.newIntent(MainActivity.this));
                Log.d("state", "click");

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(mReciver,mIntentFilter,"com.practice.olegtojgildin.SEND_MESSAGES_PERMISSION",null);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mReciver);
    }

    private class ViewCallbackImpl implements ViewCallback {
        @Override
        public void onStatusChanged(String newStatus) {
            Log.d("state", newStatus);
            textView.setText(newStatus);
        }
    }
}
