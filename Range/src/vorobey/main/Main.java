package vorobey.main;
import vorobey.range.*;

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

        Range range1 = new Range(13.0, 13.5);
        Range range2 = new Range(13.5, 15);
        Range rangeIntersection = range1.getRangeIntersection(range2);

        if (rangeIntersection == null) {
            System.out.println("Указанные диапазоны не пересекаются");
        } else {
            System.out.println("Интервал пересечения равен " + rangeIntersection);
        }
    }
}

