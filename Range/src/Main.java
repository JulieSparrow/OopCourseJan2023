import Range.Range;

public class Main {
    public static void main(String[] args) {
        Range range = new Range(13.25, 18.15);

        System.out.println("Задан диапазон " + range.getFrom() + " " + range.getTo());
        System.out.println("Длина диапазона " + range.getLength());

        double number = 14.05;

        if (range.isInside(number)) {
            System.out.println("Число принадлежит указанному диапазону");
        } else {
            System.out.println("Число не принадлежит указанному диапазону");
        }
    }
}
