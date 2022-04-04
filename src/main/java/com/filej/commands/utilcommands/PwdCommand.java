package com.filej.commands.utilcommands;

import com.filej.commands.Command;

public class PwdCommand extends UtilCommand {
    private static final PwdCommand INSTANCE = new PwdCommand();

    public static Command getInstance() {
        return INSTANCE;
    }
    
    @Override
    public void run() throws Exception {
        System.out.println("real_path: " + stateController.getRealPath() + "\npseudo_path: " + stateController.getPseudoPath());        
    }
}
