package org.example;

import java.io.*;

public class FileTypeFilterManager {
    static String[] files;
    static String outputDir;
    static String prefix;
    static boolean append;

    FileTypeFilterManager(String[] files,
    String outputDir,
    String prefix,
    boolean append){
        FileTypeFilterManager.files = files;
        FileTypeFilterManager.outputDir = outputDir;
        FileTypeFilterManager.prefix = prefix;
        FileTypeFilterManager.append = append;
    }

    public static void filterManage() {
        String path = outputDir + "/" + prefix;
        FileTypeFilter fileTypeFilter = new FileTypeFilter();
        for (String fileName: files){
            try{
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null){
                if (fileTypeFilter.isInteger(line)){
                    FileTypeFilter.intWriterProcess(line, path, append);
                }
                else if (fileTypeFilter.isFloat(line)){
                    FileTypeFilter.floatWriterProcess(line, path, append);
                }
                else{
                    FileTypeFilter.stringWriterProcess(line, path, append);
                }
            }
            }catch (IOException _){
                System.out.println("Ошибка при чтении файла " + fileName);
            }
        }
    }
}
