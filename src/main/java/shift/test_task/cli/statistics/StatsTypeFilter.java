package shift.test_task.cli.statistics;

import shift.test_task.cli.statistics.model.FloatFullStats;
import shift.test_task.cli.statistics.model.IntFullStats;
import shift.test_task.cli.statistics.model.StringFullStats;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StatsTypeFilter {

     public void shortStats(File intFile, File floatFile, File stringFile){
        if(intFile.exists()){
            try {
                long intLineCount = Files.lines(Paths.get(intFile.getAbsolutePath())).count();
                System.out.println("Количество целых чисел: " + intLineCount);
            }catch (IOException e){
                System.out.println("Ошибка при чтении файла с целыми числами " + intFile.getName());
            }
        }
        if(floatFile.exists()){
            try {
                long floatLineCount = Files.lines(Paths.get(floatFile.getAbsolutePath())).count();
                System.out.println("Количество чисел с плавающей точкой: " + floatLineCount);
            }catch (IOException e){
                System.out.println("Ошибка при чтении файла с числами с плавающей точкой " + floatFile.getName());
            }
        }
        if(stringFile.exists()){
            try {
                long stringLineCount = Files.lines(Paths.get(stringFile.getAbsolutePath())).count();
                System.out.println("Количество строк: " + stringLineCount);
            }catch (IOException e){
                System.out.println("Ошибка при чтении файла со строками" + stringFile.getName());
            }
        }
    }

    private void getIntFullStats(ArrayList<Long> arrayFromIntFile){
         new IntFullStats(
                arrayFromIntFile.stream().mapToLong(Long::longValue).min().getAsLong(),
                arrayFromIntFile.stream().mapToLong(Long::longValue).max().getAsLong(),
                arrayFromIntFile.stream().mapToLong(Long::longValue).sum(),
                arrayFromIntFile.stream().mapToLong(Long::longValue).average().getAsDouble(),
                arrayFromIntFile.size());
    }

    private void getFloatFullStats(ArrayList<Double> arrayFromFloatFile){
        new FloatFullStats(
                arrayFromFloatFile.stream().mapToDouble(Double::doubleValue).min().getAsDouble(),
                arrayFromFloatFile.stream().mapToDouble(Double::doubleValue).max().getAsDouble(),
                arrayFromFloatFile.stream().mapToDouble(Double::doubleValue).sum(),
                arrayFromFloatFile.stream().mapToDouble(Double::doubleValue).average().getAsDouble(),
                arrayFromFloatFile.size()
        );
    }

    private void getStringFullStats(List<String> arrayFromStringFile){
        new StringFullStats(
                arrayFromStringFile.stream().min(Comparator.comparingInt(String::length)).get(),
                arrayFromStringFile.stream().min(Comparator.comparingInt(String::length)).get().length(),
                arrayFromStringFile.stream().max(Comparator.comparingInt(String::length)).get(),
                arrayFromStringFile.stream().max(Comparator.comparingInt(String::length)).get().length(),
                arrayFromStringFile.size()
        );
    }

    public void fullStats(File intFile, File floatFile, File stringFile){
        if(intFile.exists()){
            try {
                BufferedReader reader = new BufferedReader(new FileReader(intFile));
                ArrayList<Long> arrayFromIntFile = new ArrayList<>();
                String line;
                while ((line = reader.readLine()) != null){
                    try {
                        arrayFromIntFile.add(Long.parseLong(line.trim()));
                    }catch (NumberFormatException _){};
                }
                if(!arrayFromIntFile.isEmpty()){
                    getIntFullStats(arrayFromIntFile);
                }
                else System.out.println("Файл с целыми числами пуст");
            }catch (IOException e){
                System.out.println("Ошибка при чтении файла с целыми числами" + intFile.getName());
            }
        }
        if(floatFile.exists()){
            try {
                BufferedReader reader = new BufferedReader(new FileReader(floatFile));
                ArrayList<Double> arrayFromFloatFile = new ArrayList<>();
                String line;
                while ((line = reader.readLine()) != null){
                    try{
                        arrayFromFloatFile.add(Double.parseDouble(line.trim()));
                    }catch (NumberFormatException _){};
                }
                if(!arrayFromFloatFile.isEmpty()){
                    getFloatFullStats(arrayFromFloatFile);
                }
                else System.out.println("Файл числами с плавающей точкой пуст");
            }catch (IOException e){
                System.out.println("Ошибка при чтении файла с числами с плавающей точкой" + floatFile.getName());
            }
        }
        if(stringFile.exists()){
            try {
                BufferedReader reader = new BufferedReader(new FileReader(stringFile));
                List<String> arrayFromStringFile = reader.lines().map(String::trim).filter(s -> !s.isEmpty())
                        .toList();
                if(!arrayFromStringFile.isEmpty()){
                    getStringFullStats(arrayFromStringFile);
                }
                else System.out.println("Файл со строками пуст");
            }catch (IOException e){
                System.out.println("Ошибка при чтении файла со строками " + stringFile.getName());
            }
        }
    }
}
