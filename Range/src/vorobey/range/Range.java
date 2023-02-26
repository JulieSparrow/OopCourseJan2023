package vorobey.range;
import java.util.Objects;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public Range() {

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
        return "Range{" +
                "from=" + from +
                ", to=" + to +
                '}';
    }

    public Range getRangeIntersection(Range range) {
        Range rangeIntersection = null;

        if (range.isInside(this.from)) {
            rangeIntersection = new Range();
            rangeIntersection.setFrom(this.from);
        }

        if (range.isInside(this.to)) {
            if (rangeIntersection == null) {
                rangeIntersection = new Range();
            }

            rangeIntersection.setTo(this.to);
        }

        if (this.isInside(range.getFrom())) {
            if (rangeIntersection == null) {
                rangeIntersection = new Range();
            }

            rangeIntersection.setFrom(range.getFrom());
        }

        if (this.isInside(range.getTo())) {
            if (rangeIntersection == null) {
                rangeIntersection = new Range();
            }

            rangeIntersection.setTo(range.getTo());
        }

        if (Objects.requireNonNull(rangeIntersection).getLength() == 0) {
            return null;
        }

        return rangeIntersection;
    }
}

