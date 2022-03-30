package com.filej;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;

import com.filej.commands.Command;
import com.filej.controllers.CommandController;
import com.filej.controllers.StateController;
import com.filej.utils.constants.Colors;
import com.filej.utils.models.Input;

/**
 * Консольное приложение, в котором будут шорт-команды. 
 * Будет слушатель, который будет обрабатывать вводимую команду с консоли.

 * Стартовый каталог с командами:
 *      "создать каталог", 
 *      "переход в каталог", 
 *      "просмотр содержимого каталога", 
 *      "создание файла", 
 *      "запись/чтение данных с файла", 
 *      "удаление каталога/файла с подтверждением", 
 *      "обработка исключений"
 *
 * Наименование команд:
 *      md <dirname>
 *      cd <dirname>
 *      list <dirname> | .
 *      touch [optional: -v | --verbose] <filename>
 *      write [optional: -v | --verbose] <string> <filename>
 *      read [optional: -v | --verbose] <filename>
 *      del [optional: -v | --verbose] [optional: -f | --force] <filename>
 *      rmd [optional: -v | --verbose] [optional: -f | --force] <dirname>
 */

public class App {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
    private static final CommandController commandController = new CommandController();
    private static final StateController stateController = new StateController();
    private static Input input;

    public static void main(String[] args) throws Exception {
        clearWindow();
            run();
    }

    static void run() throws Exception {
        while (true) {
            displayPath();
            String[] args = reader.readLine().split(" ");
            
            if (args.length > 1 && args.length < 4)
                input = new Input.Builder()
                    .command(args[0])
                    .args(args)
                    .build();

            Command command = commandController.defineType(input);

            try {
                command.run();
            } catch (NoSuchElementException e) {
                System.out.println(e.getMessage());
            }

            startNewLine();
        }
    }

    static void clearWindow() {
        System.out.println(Colors.ANSI_CLS);
    }

    static void displayPath() {
        System.out.print(Colors.ANSI_YELLOW + stateController.getCurrentPath() + Colors.ANSI_RESET + "> ");
    }

    static void startNewLine() {
        System.out.println();
    }
}
