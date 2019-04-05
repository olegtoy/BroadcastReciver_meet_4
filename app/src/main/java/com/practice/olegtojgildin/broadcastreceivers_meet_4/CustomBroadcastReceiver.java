package com.practice.olegtojgildin.broadcastreceivers_meet_4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by olegtojgildin on 23/12/2018.
 */

public class CustomBroadcastReceiver extends BroadcastReceiver {

    private ViewCallback mViewCallback;

    public CustomBroadcastReceiver(ViewCallback viewCallback) {
        this.mViewCallback = viewCallback;
    }

    public CustomBroadcastReceiver(){

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        StatusManager stateManager = StatusManager.getInstanse();

        boolean isUpdate = intent.getBooleanExtra("update", false);
        if (isUpdate) {
            mViewCallback.onStatusChanged(stateManager.getState().toString());
        } else {
            stateManager.updateState();
            mViewCallback.onStatusChanged(stateManager.getState().toString());
        }
    }
}
