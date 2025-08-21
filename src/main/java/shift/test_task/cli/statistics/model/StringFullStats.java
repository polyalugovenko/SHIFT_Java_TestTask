package shift.test_task.cli.statistics.model;

public record StringFullStats(
        String shortestWord,
        int shortestWordLength,
        String longestWord,
        int longestWordLength,
        int stringCount
) {
    public StringFullStats{
        System.out.println("Полная статистика для строк:");
        System.out.println("- Самая короткая строка: " + shortestWord + " (" + shortestWordLength
                + " символов)");
        System.out.println("- Самая длинная строка: " + longestWord + " (" + longestWordLength
                + " символов)");
        System.out.println("- Количество строк: " + stringCount);
    }
}
