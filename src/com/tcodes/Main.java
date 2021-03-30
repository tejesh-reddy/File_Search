package com.tcodes;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        FileSearcher fileSearcher = new FileSearcher();
        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            System.out.println("Enter file regex (Type \\exit to exit):");
            String regex = scanner.next();

            if(regex.equals("\\exit"))
                break;

            fileSearcher.getFiles(regex);
        }
    }
}
