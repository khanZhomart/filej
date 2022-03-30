package com.filej;

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
    
    public static void main( String[] args ) {
        System.out.println( "\u001B[31m Hello World! \u001B[0m" );
    }
}
