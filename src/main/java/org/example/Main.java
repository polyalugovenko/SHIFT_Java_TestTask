package org.example;
import org.apache.commons.cli.*;

public class Main {

    public static Option createOption(String shortArgName, String longArgName, String description,
                               boolean required,  boolean hasArg){
        return Option.builder(shortArgName)
                .longOpt(longArgName)
                .desc(description)
                .required(required)
                .hasArg(hasArg)
                .build();
    }

    public static ConfigArgs parseCommandLineArgs(Options options, String[] args) throws ParseException {
        CommandLineParser commandLineParser= new DefaultParser();
        CommandLine commandLine = commandLineParser.parse(options, args);

        return new ConfigArgs(
                commandLine.getOptionValue("-o", commandLine.getOptionValue("--output", ".")),
                commandLine.getOptionValue("-p", commandLine.getOptionValue("--prefix", "")),
                commandLine.hasOption("-a") || commandLine.hasOption("--append"),
                commandLine.hasOption("-s") || commandLine.hasOption("--short"),
                commandLine.hasOption("-f")||commandLine.hasOption("--full"),
                commandLine.getArgs()
        );
    }

    public static void main(String[] args) {
        Options options = new Options();

        Option filePath = createOption("o", "output",
                "The path to the directory where to save the output files", false, true);
        Option prefix = createOption("p", "prefix",
                "Prefix for output file names", false, true);
        Option append = createOption("a", "append",
                "Mode for adding data to existing files", false, false);
        Option shortStatistic = createOption("s", "short",
                "Display short statistics", false, false);
        Option fullStatistic = createOption("f", "full",
                "Display full statistics", false, false);

        options.addOption(filePath)
                .addOption(prefix)
                .addOption(append)
                .addOption(shortStatistic)
                .addOption(fullStatistic);

        try{
        ConfigArgs configArgs = parseCommandLineArgs(options, args);
            System.out.println(configArgs);
            for (String file: configArgs.inputFiles()){
                System.out.println(file);
            }
        }catch (ParseException | IllegalArgumentException e){
            System.err.println(e.getMessage());
        }
    }
}