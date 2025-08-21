package shift.test_task.cli.statistics;

import java.io.File;

public class StatsTypeFilterManager {
    boolean shortStatistic;
    boolean fullStatistic;
    String path;

    public StatsTypeFilterManager(boolean shortStatistic, boolean fullStatistic, String path){
        this.shortStatistic = shortStatistic;
        this.fullStatistic = fullStatistic;
        this.path = path;
    }
    public void statsManage(){
        StatsTypeFilter statsTypeFilter = new StatsTypeFilter();
        String intFullPath = path + "integers.txt";
        String floatFullPath = path + "floats.txt";
        String stringFullPath = path + "strings.txt";
        File intFile = new File(intFullPath);
        File floatFile = new File(floatFullPath);
        File stringFile = new File(stringFullPath);
        if (fullStatistic){
            statsTypeFilter.fullStats(intFile,floatFile, stringFile);
        }
        else if (shortStatistic){
            statsTypeFilter.shortStats(intFile,floatFile, stringFile);
        }
    }
}
