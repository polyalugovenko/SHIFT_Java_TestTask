package shift.test_task.cli.statistics.model;

public record FloatFullStats(
        double minValue,
        double maxValue,
        double sumValue,
        double meanValue,
        int floatCount
) {
    public FloatFullStats {
        System.out.println("Полная статистика для чисел с плавающей точкой:");
        System.out.println("- Минимальное значение: " + minValue);
        System.out.println("- Максимальное значение: " + maxValue);
        System.out.println("- Сумма: " + sumValue);
        System.out.println("- Среднее арифметическое: " + meanValue);
        System.out.println("- Количество чисел: " + floatCount);
    }
}
