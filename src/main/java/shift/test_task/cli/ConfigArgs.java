package shift.test_task.cli;

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
