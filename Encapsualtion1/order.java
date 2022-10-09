import java.util.Scanner;
import WishTea.*;



public class order{
    public static void menu(){
        System.out.println(" ------------------------------Menu----------------------------- ");
        System.out.println("|  Tea Name  Small(S)  Medium(M)  Large(L)                      |");
        System.out.println("|  Green tea   $60       $70        $80     (+5$ for topping)   |");
        System.out.println("|  Black tea   $55       $65        $75     (+5$ for topping)   |");
        System.out.println("|  Lemon tea   $65       $80        $95     (+10$ for topping)  |");
        System.out.println(" ------------------------------Ice------------------------------ ");
        System.out.println(""" 
        |  (1)no ice                                                    |
        |  (2)a little                                                  |
        |  (3)regular                                                   |""");
        System.out.println(" ---------------------------------------------------------------");
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char inputAgain;
        int maxSize = 100;
        int index = 0;
        WishTea orders[] = new WishTea[maxSize];

        menu();
        do{
            System.out.print("Please enter the tea name: ");
            String inputName = sc.nextLine();

            System.out.print("Please enter the size: ");
            char inputSize = sc.nextLine().charAt(0);

            System.out.print("Please enter the ice level: ");
            int inputIceLevel = sc.nextInt();

            System.out.print("Please enter the topping: ");
            int inputTopping = sc.nextInt();

            System.out.print("Please enter the amount: ");
            int inputAmount = sc.nextInt();

            orders[index] = new WishTea(inputName, inputSize, inputIceLevel, inputTopping, inputAmount);
            index++;

            if(index == maxSize){
                System.out.println("The order is full, bye bye ;)");
                break;
            }

            System.out.print("Do you want to order again? (Y/N): ");
            inputAgain = sc.next().charAt(0);
            sc.nextLine();

        }while(inputAgain == 'Y' || inputAgain == 'y');
        
        System.out.println("\n\nOrder Description");
        System.out.println("=======================================================================");

        int total_amount = 0;
        double total_cost = 0;
        for(int i=0; i<index; i++){
            String res = orders[i].getDescription();

            System.out.printf("%2d. ", i+1);
            System.out.println(res);

            total_amount += orders[i].getAmount();
            total_cost += orders[i].calcCost();
        }

        System.out.println("-----------------------------------------------------------------------");
        System.out.printf("    Total Cost                     %2d        $%.0f\n", total_amount, total_cost);
        System.out.println("=======================================================================");
    }
}