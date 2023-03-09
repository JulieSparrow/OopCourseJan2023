package vorobey.range;

import java.util.Objects;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double number) {
        return number >= from && number <= to;
    }

    @Override
    public String toString() {
        return "Range(" +
                +from +
                "; " + to +
                ')';
    }

    public Range getIntersection(Range range) {
        Range intersection = null;

        double intersectionFrom = Math.max(range.getFrom(), from);
        double intersectionTo = Math.min(range.getTo(), to);

        if (intersectionTo - intersectionFrom > 0) {
            intersection = new Range(intersectionFrom,intersectionTo);
        }

        return intersection;
    }

    public Range[] getUnion(Range range) {
        Range[] union = null;

        if ((range.getFrom() < from && range.getTo() < from) || (from < range.getFrom() && to < range.getFrom())) {
            union = new Range[2];
            union[0] = new Range(Math.min(range.getFrom(), from), Math.min(range.getTo(), to));
            union[1] = new Range(Math.max(range.getFrom(), from), Math.max(range.getTo(), to));
        } else {
            union = new Range[1];
            union[0] = new Range(Math.min(range.getFrom(), from), Math.max(range.getTo(), to));
        }

        return union;
    }

    public Range[] getDifference(Range range) {
        Range[] difference = null;

        if (range.getFrom() != from && range.getTo() != to) {
            if ((range.getFrom() > from && range.getTo() < to)) {
                difference = new Range[2];
                difference[0] = new Range(from, range.getFrom());
                difference[1] = new Range(range.getTo(), to);
            } else {
                difference = new Range[1];
                if (range.getFrom() > from && range.getFrom() < to) {
                    difference[0] = new Range(from, range.getFrom());
                } else if (range.getTo() > from && range.getTo() < to) {
                    difference[0] = new Range(range.getTo(), to);
                }
            }
        }

        return difference;
    }
}