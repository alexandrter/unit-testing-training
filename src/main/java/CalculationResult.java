import java.awt.*;
import java.util.Objects;

public class CalculationResult {

    private double number;
    private Color color;

    //noargs constructor
    public CalculationResult() {

    }
    //allargs constructor
    public CalculationResult(final double number, final Color color) {
        this.number = number;
        this.color = color;
    }

    //getters & setters
    public double getNumber() {
        return number;
    }

    public void setNumber(final double number) {
        this.number = number;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(final Color color) {
        this.color = color;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final CalculationResult that = (CalculationResult) o;
        return Double.compare(that.number, number) == 0 &&
                Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, color);
    }
}
