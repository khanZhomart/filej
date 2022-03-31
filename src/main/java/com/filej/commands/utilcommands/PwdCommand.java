package com.filej.commands.utilcommands;

import com.filej.commands.Command;
import com.filej.controllers.StateController;

public class PwdCommand implements Command {
    private StateController stateController = new StateController();

    @Override
    public void run() throws Exception {
        System.out.println("real path: " + stateController.getRealPath() + "\nproject path: " + stateController.getCurrentPath());        
    }
    
}
