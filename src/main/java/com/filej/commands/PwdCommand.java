package com.filej.commands;

import com.filej.controllers.StateController;

public class PwdCommand implements Command {
    protected StateController stateController = new StateController();

    @Override
    public void run() throws Exception {
        System.out.println("real path: " + stateController.getRealPath() + "\nproject path: " + stateController.getCurrentPath());        
    }
    
}
