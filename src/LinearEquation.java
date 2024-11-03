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
        if (x1 == x2) {
            return "x = " + x1;
        }

        if (y1 == y2) {
            return "y = " + y1;
        }  // 1.25 --> 5/4  w = 1 d = 0.25
           // 2.75 --> 11/4  w = 2 d = 0.25
           // 3.5 --> 7/2   w = 3 d = 0.5

        double slopeValue = slope();
        int wholeNumber = (int) slopeValue;
        double decimalPart = slopeValue - wholeNumber;

        if (decimalPart == 0) {
            return "y = " + wholeNumber + "x +" + yIntercept();
        }

        int denominator = (int) (1 / decimalPart);
        int numerator = wholeNumber * denominator;

        double remainingPart = decimalPart * denominator;
        int times = (int) Math.round(remainingPart);

        numerator += times;

        return "y = " + numerator + "/" + denominator + "x + " + yIntercept();

//
//        if (slope() > 0) {
//        int wholeNumber = (int) slope();
//        double decimalNumber = slope() - wholeNumber;
//        System.out.println("Decimal Number: " + decimalNumber); //(6, -60), (-18, 12)
//        int denominator = (int) (1 / decimalNumber);
//        int numerator = wholeNumber * denominator;
//
//        double oneOverDenom = (double) 1 / denominator;
//        System.out.println("Denominator " + denominator);
//        System.out.println("oneOverDemon: " + oneOverDenom);
//        int times = 0;
//        while (decimalNumber > 0) {
//            decimalNumber -= oneOverDenom;
//            times += 1;
//        }

//        int leftover = 0;
//        double divisor = (double) 1 / denominator;
//        while (true) {
//            if (decimalNumber > 0) {
//                decimalNumber -= divisor;
//                leftover += 1;
//            } else {
//                break;
//            }
//        }
//        double leftover = (int) (decimalNumber / 1);

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
