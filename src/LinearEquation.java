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

    public double distance() {
        double distance = Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
        return Math.round(distance * 100) / 100.0; //Rounded Distance
    }
    public double yIntercept() {
        return y1 - slope() * (x1); //Y-Intercept
    }
    public double slope() {
        return (double) (y2 - y1) / (x2-x1); //Slope
    }
    public String equation() {
        if (y1 == y2) {
            return "y = " + y1;
        }
        int wholeNumber = (int) slope();
        double decimalNumber = slope() - wholeNumber;
        int denominator = (int) (1 / decimalNumber);
        int numerator = wholeNumber * denominator;
        int leftover = (int) (decimalNumber / denominator);
        numerator += leftover;

        return "y = " + numerator + "/" + denominator + "x + " + yIntercept();
    }
    public String coordinateForX(double x) {
        double yValue = slope() * x + yIntercept();
        return "(" + x + "," + yValue + ")";
    }
    public String lineInfo() {
        String message = "";
        message += "The two points are: (" + x1 + "," + y1 + ") and " + "(" + x2 + "," + y2 + ")" + "\n";
        message += "The equation of the line between these points is: " + equation() + "\n";
        message += "The y-intercept of this line is: " + yIntercept() + "\n";
        message += "The slope of this line is: " + slope() + "\n";
        message += "The distance between these points is " + distance();
        return message;
    }

}
