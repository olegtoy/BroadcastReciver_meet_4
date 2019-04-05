package com.practice.olegtojgildin.broadcastreceivers_meet_4;

/**
 * Created by olegtojgildin on 05/04/2019.
 */

public enum State {
    A, B, C, D, E;

    private static State[] values = values();

    public State nextState() {
        return values[(this.ordinal() + 1) % values.length];
    }

}
