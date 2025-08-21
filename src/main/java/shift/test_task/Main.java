package shift.test_task;
import org.apache.commons.cli.*;
import shift.test_task.cli.cliArgs.CommandLineHandler;
import shift.test_task.cli.cliArgs.ConfigArgs;
import shift.test_task.cli.processing.FileTypeFilterManager;
import shift.test_task.cli.processing.ParseLocalException;
import shift.test_task.cli.statistics.StatsTypeFilterManager;

public class Main {

    public static void main(String[] args) {
        Options options = new Options();
        CommandLineHandler commandLineHandler = new CommandLineHandler();
        Option filePath = commandLineHandler.createOption("o", "output",
                "The path to the directory where to save the output files", false, true);
        Option prefix = commandLineHandler.createOption("p", "prefix",
                "Prefix for output file names", false, true);
        Option append = commandLineHandler.createOption("a", "append",
                "Mode for adding data to existing files", false, false);
        Option shortStatistic = commandLineHandler.createOption("s", "short",
                "Display short statistics", false, false);
        Option fullStatistic = commandLineHandler.createOption("f", "full",
                "Display full statistics", false, false);

        options.addOption(filePath)
                .addOption(prefix)
                .addOption(append)
                .addOption(shortStatistic)
                .addOption(fullStatistic);

        try{
        ConfigArgs configArgs = commandLineHandler.parseCommandLineArgs(options, args);
        String path = configArgs.outputDir() + "/" + configArgs.prefix();

            FileTypeFilterManager fileTypeFilterManager = new FileTypeFilterManager(configArgs.inputFiles(),
                    path, configArgs.append());
            fileTypeFilterManager.filterManage();

            StatsTypeFilterManager statsTypeFilterManager = new StatsTypeFilterManager(configArgs.shortStats(), configArgs.fullStats(), path);
            statsTypeFilterManager.statsManage();

        }catch (ParseLocalException e){
            System.err.println("Программа завершена по причине:\n" + e.getLocalizedMessage());
        }
    }
}