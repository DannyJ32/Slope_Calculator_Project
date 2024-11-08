import java.util.Scanner;

public class LinearEquationLogic {
    private Scanner scan;
    private String cord1;
    private String cord2;
    private String x1;
    private String x2;
    private String y1;
    private String y2;
    private int x1Int;
    private int y1Int;
    private int x2Int;
    private int y2Int;

    public LinearEquationLogic() {
        scan = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to the linear equation calculator!");
        while (true) {
            System.out.print("Enter coordinate 1: ");
            cord1 = scan.nextLine();
            System.out.print("Enter coordinate 2: ");
            cord2 = scan.nextLine();
            coordinateGetter();
            LinearEquation l = new LinearEquation(x1Int, y1Int, x2Int, y2Int);
            System.out.println();
            System.out.println(l.lineInfo());
            System.out.println();
            System.out.print("Enter a value for x: ");
            double xValue = scan.nextDouble();
            System.out.println();
            if (x1Int == x2Int) {
                System.out.println("The x-coordinate cannot be used for vertical lines.");
            } else {
                System.out.println("The point on the line is " + l.coordinateForX(xValue));
            }
            scan.nextLine();
            System.out.print("Would you like to enter another pair of coordinates? y/n: ");
            String answer = scan.nextLine();
            answer = answer.toUpperCase();
            if (answer.equals("Y")) {
            } else {
                System.out.println("Thank you for using the slope calculator, goodbye!");
                break;
            }
        }
    }

    private void coordinateGetter() {
        int cord1Idx = cord1.length();
        int commaIndex1 = cord1.indexOf(",");
        int cord2Idx = cord2.length();
        int commaIndex2 = cord2.indexOf(",");

        x1 = cord1.substring(1, commaIndex1);
        y1 = cord1.substring(commaIndex1 + 2, cord1Idx - 1);
        x2 = cord2.substring(1, commaIndex2);
        y2 = cord2.substring(commaIndex2 + 2, cord2Idx - 1);
        x1Int = Integer.parseInt(x1);
        y1Int = Integer.parseInt(y1);
        x2Int = Integer.parseInt(x2);
        y2Int = Integer.parseInt(y2);
    }
}
