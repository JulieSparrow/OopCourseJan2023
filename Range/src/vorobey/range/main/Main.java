package vorobey.range.main;

import vorobey.range.Range;

class Main {
    public static void main(String[] args) {
        Range range = new Range(13.25, 18.15);

        System.out.println("Задан диапазон " + range);
        System.out.println("Длина диапазона " + range);

        double number = 14.05;

        if (range.isInside(number)) {
            System.out.println("Число принадлежит указанному диапазону");
        } else {
            System.out.println("Число не принадлежит указанному диапазону");
        }

        Range range1 = new Range(16.0, 18.7);
        Range range2 = new Range(16.6, 17.6);
        Range rangeIntersection = range1.getIntersection(range2);

        if (rangeIntersection == null) {
            System.out.println("Указанные диапазоны не пересекаются");
        } else {
            System.out.println("Интервал пересечения равен " + rangeIntersection);
        }

        Range[] union = range1.getUnion(range2);
        System.out.print("Объединение диапазонов происходит в интервале (интервалах): ");

        for (Range item : union) {
            System.out.print(item + " ");
        }

        System.out.println();

        Range[] difference = range1.getDifference(range2);
        if (difference == null) {
            System.out.println("Разность диапазонов равна 0");
        } else {
            System.out.print("Диапазон " + range1 + " минус диапазон " + range2 + " равно ");

            for (Range value : difference) System.out.print(value + " ");
        }
    }
}