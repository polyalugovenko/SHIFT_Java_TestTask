package shift.test_task.cli.cliArgs;

import java.util.List;

public record ConfigArgs(
     String outputDir,
     String prefix,
     boolean append,
     boolean shortStats,
     boolean fullStats,
     List<String> inputFiles)
{
    public ConfigArgs{
        if (shortStats && fullStats){
            shortStats = false;
        }
    }
}
