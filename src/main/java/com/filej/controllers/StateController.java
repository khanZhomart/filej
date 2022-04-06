package com.filej.controllers;

import com.filej.states.TreeState;

public class StateController implements Controllable {
    private final TreeState state = TreeState.INSTANCE;

    @Override
    public void pushToPath(String path) {
        state.addPath(path);
    }

    @Override
    public void popFromPath() {
        state.popPath();
    }

    @Override
    public String getPseudoPath() {
        return state.toString();
    }

    @Override
    public String getRealPath() {
        return state.getRealPath();
    }
}
