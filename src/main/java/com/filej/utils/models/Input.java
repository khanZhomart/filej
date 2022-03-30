package com.filej.utils.models;

import com.filej.utils.constants.Commands;

public class Input {
    private String command;
    private boolean verbose;
    private String target;

    private Input(Builder builder) {
        this.command = builder.command;
        this.verbose = builder.verbose;
        this.target = builder.target;
    }

    public String getCommand() {
        return this.command;
    }

    public boolean verbose() {
        return this.verbose;
    }

    public String getTarget() {
        return this.target;
    }

    public static class Builder {
        private String command;
        private boolean verbose;
        private String target;

        public Builder command(String command) {
            this.command = command;
            return this;
        }

        public Builder args(String args[]) {
            if (args.length == 3 && Commands.Options.VERBOSE.contains(args[1])) {
                this.verbose = true;
                this.target = args[2];
            } else {
                this.target = args[1];
            }

            return this;
        }

        public Input build() {
            return new Input(this);
        }
    }
}
