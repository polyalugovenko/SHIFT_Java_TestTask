package org.example;

public record ConfigArgs(
     String outputDir,
     String prefix,
     boolean append,
     boolean shortStats,
     boolean fullStats,
     String[] inputFiles)
{
    public ConfigArgs{
        if (shortStats && fullStats){
            throw new IllegalArgumentException("Options -s and -f cannot be used together");
        }
    }
}
