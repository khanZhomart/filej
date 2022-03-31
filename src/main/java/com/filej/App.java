package com.filej;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;

import com.filej.controllers.CommandController;
import com.filej.utils.WindowUtil;
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
 *      +md <dirname>                                                        
 *      +cd <dirname>                                                        
 *      +list <dirname> | .                                                  
 *      +rmd [optional: -v | --verbose] [optional: -f | --force] <dirname>   
 *      +touch [optional: -v | --verbose] <filename>                         
 *      write [optional: -v | --verbose] <string> <filename>
 *      read [optional: -v | --verbose] <filename>
 *      +del [optional: -v | --verbose] [optional: -f | --force] <filename>
 */

public class App {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
    private static final CommandController commandController = new CommandController();
    private static Input input;

    public static void main(String[] args) throws Exception {
        WindowUtil.clearWindow();
        WindowUtil.showTitle();
        run();
    }

    static void run() throws Exception {
        while (true) {
            WindowUtil.displayPath();
            String[] args = reader.readLine().split(" ");

            input = new Input.Builder()
                .command(args[0])
                .args(args)
                .build();

            try {
                commandController.defineType(input).run();
            } catch (NoSuchElementException e) {
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (NullPointerException e) {
                System.out.println("error: arguments are not specifed.");
            }

            WindowUtil.startNewLine();
        }
    }
}
