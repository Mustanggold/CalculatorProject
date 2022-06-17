import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String operator = "+-*/";

        while (true) {
            one:
            {
                System.out.print("Please type the first number: ");
                int firstN = scan.nextInt();
                scan.nextLine();

                String operation;
                System.out.println("Choose an operation:\n" +
                        " > Type + for addition\n" +
                        " > Type - for subtraction\n" +
                        " > Type * for multiplication\n" +
                        " > Type / for division");
                while(true){
                    operation = scan.nextLine();
                    if (!operator.contains(operation)) {
                        System.out.print("Sorry, unrecognized operator. Try again: ");
                    }else{
                        break;
                    }
                }

                System.out.print("Please type the second number: ");
                int secondN = scan.nextInt();
                scan.nextLine();
                if (secondN == 0) {
                    System.out.println("Cannot divide by zero");
                    break one;
                }

                Calculator calculation = new Calculator(firstN, secondN);
                switch (operation) {
                    case "+":
                        System.out.printf("%d + %d = %d\n", firstN, secondN, (int) calculation.add());
                        break;
                    case "-":
                        System.out.printf("%d - %d = %d\n", firstN, secondN, (int) calculation.subtract());
                        break;
                    case "*":
                        System.out.printf("%d * %d = %d\n", firstN, secondN, (int) calculation.multiply());
                        break;
                    case "/":
                        System.out.printf("%d / %d = %.2f\n", firstN, secondN, calculation.divide());
                        break;
                }
            }

            System.out.println("Do you want to continue or quit?");
            String playAgain = scan.nextLine();
            if (!playAgain.equalsIgnoreCase("continue")) break;
        }
    }
}