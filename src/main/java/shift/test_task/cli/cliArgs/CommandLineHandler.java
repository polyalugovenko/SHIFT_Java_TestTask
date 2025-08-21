package shift.test_task.cli.cliArgs;

import org.apache.commons.cli.*;
import shift.test_task.cli.processing.ParseLocalException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CommandLineHandler {
    public Option createOption(String shortArgName, String longArgName, String description,
                                      boolean required, boolean hasArg){
        return Option.builder(shortArgName)
                .longOpt(longArgName)
                .desc(description)
                .required(required)
                .hasArg(hasArg)
                .build();
    }

    private List<String> validateFiles(String[] files){
        Pattern pattern = Pattern.compile("^.+\\.txt$");
        List<String> validFiles = new ArrayList<>();
        for (String file: files){
            if (pattern.matcher(file).matches()){
                validFiles.add(file);
            }
            else{
                System.out.println(file + " не является названием файла");
            }
        }
        return validFiles;
    }

    public ConfigArgs parseCommandLineArgs(Options options, String[] args) throws ParseLocalException {
        CommandLineParser commandLineParser= new DefaultParser();
        try {
            CommandLine commandLine = commandLineParser.parse(options, args);
            return new ConfigArgs(
                    commandLine.getOptionValue("-o", commandLine.getOptionValue("--output", ".")),
                    commandLine.getOptionValue("-p", commandLine.getOptionValue("--prefix", "")),
                    commandLine.hasOption("-a") || commandLine.hasOption("--append"),
                    commandLine.hasOption("-s") || commandLine.hasOption("--short"),
                    commandLine.hasOption("-f")||commandLine.hasOption("--full"),
                    validateFiles(commandLine.getArgs())
            );
        }catch (ParseException e){
            throw new ParseLocalException(e.getMessage());
        }
    }
}
