package shift.test_task.cli.statistics.model;

public record IntFullStats(
        long minValue,
        long maxValue,
        long sumValue,
        double meanValue,
        int intCount )
{
    public IntFullStats{
        System.out.println("Полная статистика для целых чисел:");
        System.out.println("- Минимальное значение: " + minValue);
        System.out.println("- Максимальное значение: " + maxValue);
        System.out.println("- Сумма: " + sumValue);
        System.out.println("- Среднее арифметическое: " + meanValue);
        System.out.println("- Количество чисел: " + intCount);
    }
}
