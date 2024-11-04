public class LinearEquation {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    private double roundedToHundredth(double toRound) {
        return Math.round(toRound * 100) / 100.0;
    }

    public double distance() {
        double distance = Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
        return roundedToHundredth(distance); //Rounded Distance
    }

    public double yIntercept() {
        double yInt = y1 - slope() * (x1);
        return roundedToHundredth(yInt); //Y-Intercept
    }

    public double slope() {
        return (double) (y2 - y1) / (x2 - x1);
    }

    public String equation() {
        if (x1 == x2) {
            return "x = " + x1;
        }

        if (y1 == y2) {
            return "y = " + y1;
        }

        double slopeValue = slope();
        int wholeNumber = (int) slopeValue;
        double decimalPart = slopeValue - wholeNumber;

        if (decimalPart == 0) {
            return "y = " + wholeNumber + "x +" + yIntercept();
        }

        int denominator = (int) Math.round(1 / decimalPart);
        int numerator = wholeNumber * denominator;

        double remainingPart = decimalPart * denominator;
        int times = (int) Math.round(remainingPart);

        numerator += times;

        return "y = " + numerator + "/" + denominator + "x + " + yIntercept();
    }

    public String coordinateForX(double x) {
        double yValue = slope() * x + yIntercept();
        return "(" + x + "," + yValue + ")";
    }
    public String lineInfo() {
        String message = "";
        if (x1 == x2) {
            return "These points on a vertical line: " + equation() + "\n" + "The slope is undefined";
        }
        message += "The two points are: (" + x1 + "," + y1 + ") and " + "(" + x2 + "," + y2 + ")" + "\n";
        message += "The equation of the line between these points is: " + equation() + "\n";
        message += "The slope of this line is: " + slope() + "\n";
        message += "The y-intercept of this line is: " + yIntercept() + "\n";
        message += "The distance between these points is " + distance();
        return message;
    }
}
