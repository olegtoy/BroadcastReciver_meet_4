package com.practice.olegtojgildin.broadcastreceivers_meet_4;

import android.util.Log;

/**
 * Created by olegtojgildin on 23/12/2018.
 */

public class StatusManager {
    private static final StatusManager mInstance;
    private State mState;

    static {
        mInstance = new StatusManager();
    }

    private StatusManager() {
        mState = State.A;
    }

    public static StatusManager getInstanse() {
        return mInstance;
    }

    public State getState() {
        return mState;
    }

    public void updateState() {
        mState = mState.nextState();
    }


}
