package shift.test_task.cli.processing;

import java.io.*;
import java.util.List;

public class FileTypeFilterManager {
    List<String> files;
    String path;
    boolean append;

    public FileTypeFilterManager(List<String> files,
    String path,
    boolean append){
        this.files = files;
        this.path = path;
        this.append = append;
    }

    public void filterManage() {
        FileTypeFilter fileTypeFilter = new FileTypeFilter();

        if (files == null || files.isEmpty()) {
            System.out.println("Нет файлов для обработки");
            return;
        }

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
            }catch (IOException e){
                System.out.println("Ошибка при чтении файла " + fileName + ": " + e.getMessage());
            }
        }
    }
}
