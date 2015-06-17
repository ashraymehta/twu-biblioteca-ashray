package com.twu;

import java.io.PrintStream;
import java.util.Scanner;

public class LoginView {
    private PrintStream out;
    private Scanner scanner;

    public LoginView(PrintStream out, Scanner scanner) {
        this.out = out;
        this.scanner = scanner;
    }

    public String getUserInput() {
        return scanner.nextLine();
    }
}
