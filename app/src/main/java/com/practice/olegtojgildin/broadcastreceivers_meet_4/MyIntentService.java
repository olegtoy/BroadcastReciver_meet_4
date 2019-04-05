package com.practice.olegtojgildin.broadcastreceivers_meet_4;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by olegtojgildin on 23/12/2018.
 */

public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Intent broadcastIntent = new Intent("com.practice.olegtojgildin.SEND_MESSAGES_FILTER");
        boolean isUpdate = intent.getBooleanExtra("update", false);
        if (isUpdate)
            broadcastIntent.putExtra("update", true);
        sendBroadcast(broadcastIntent, "com.practice.olegtojgildin.SEND_MESSAGES_PERMISSION");
    }

    public static final Intent newIntent(Context context) {
        Intent intent = new Intent(context, MyIntentService.class);
        return intent;
    }
}
