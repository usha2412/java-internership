import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("******** Efficient Calculator *********");
        while(true){
            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();
            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();
            System.out.print("Enter your desired operation ('+','-','*','/'): ");
            char operator = scanner.next().charAt(0);
            double result = 0;
            switch (operator){
                case '+':
                    result = add(num1, num2);
                    break;
                case '-':
                   result = subtract(num1, num2);
                    break;
                case '*':
                    result = multiply (num1, num2);
                    break;
                case '/':
                    result =divide (num1,num2);
                    break;
                default:
                    System.out.println("Invalid operator");
            }
            System.out.println("Result :" + result);
            System.out.println("Do you want to continue to use me? (yes / no): ");
            String choice = scanner.next();
            if(!choice.equalsIgnoreCase("yes")&& !choice.equalsIgnoreCase("y")){
                System.out.println("Thank you for using me :)");
                break;
            }

        }


    }

    public static double add(double num1, double num2){
        return num1 + num2;
    }
    public static double subtract(double num1, double num2){
        return num1 - num2;
    }

    public static double multiply(double num1, double num2){
        return num1 *num2;
    }

    public static double divide(double num1, double num2){
        if (num2==0){
          System.out.println("Error: Division is not possible by zero");
        }
        return num1 / num2;
    }
}