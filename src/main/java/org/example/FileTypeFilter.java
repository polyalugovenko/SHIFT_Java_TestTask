package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileTypeFilter {

    public boolean isInteger(String s){
        try {
            Long.parseLong(s);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    public boolean isFloat(String s){
        try {
            Float.parseFloat(s);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
    public static void intWriterProcess(String line, String path, boolean append){
        try{
            BufferedWriter intWriter = new BufferedWriter(new FileWriter(path + "integers.txt", append));
            intWriter.write(line);
            intWriter.newLine();
            intWriter.flush();
        }catch (IOException e){
            System.out.println("Ошибка при создании файла для записи целых чисел " + e.getMessage());
        }
    }

    public static void floatWriterProcess(String line, String path, boolean append){
        try{BufferedWriter floatWriter = new BufferedWriter(new FileWriter(path + "floats.txt", append));
            floatWriter.write(line);
            floatWriter.newLine();
            floatWriter.flush();
        }catch (IOException e){
            System.out.println("Ошибка при создании файла для записи чисел с плавающей точкой" + e.getMessage());
        }
    }

    public static void stringWriterProcess(String line, String path, boolean append){
        try{BufferedWriter stringWriter = new BufferedWriter(new FileWriter(path + "strings.txt", append));
            stringWriter.write(line);
            stringWriter.newLine();
            stringWriter.flush();
        }catch (IOException e){
            System.out.println("Ошибка при создании файла для записи строк " + e.getMessage());
        }
    }
}
