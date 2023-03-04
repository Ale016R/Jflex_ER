package com.expresiones;

import picocli.CommandLine;

import java.io.StringReader;
import java.util.Scanner;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "lexer", mixinStandardHelpOptions = true, version = "0.0.1",
description = "lexer que reconoce identificadores y enteros")
public class App implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (!input.equals("exit")) {
            System.out.println("Ingresa la cadena >> ");
            input = scanner.nextLine();
            if (input.equals("exit")) {
                break;
            }
            Lexer lexer = new Lexer(new StringReader(input));
            Token token = lexer.yylex();
            System.out.println(token);
        }
        return 0;
    }
    public static void main( String[] args ){
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
