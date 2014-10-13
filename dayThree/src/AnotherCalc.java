import java.util.Scanner;

public class AnotherCalc {
    private static final String MULTIPLY = "*";
    private static final String ADDITION = "+";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an expression: ");
        int  op1 = sc.nextInt();
        String operator = sc.next();
        int op2 = sc.nextInt();

        int output = 0;
        if (operator.equals(MULTIPLY)){
             output = op1 * op2;
        } else if (operator.equals(ADDITION)){
            output = op1 + op2;
        }

        System.out.println(output);


    }
}
