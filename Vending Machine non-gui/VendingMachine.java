import java.util.Scanner;


public class VendingMachine{
    private int[] deposit_bill = new int[4]; // 0:1 , 1:5 , 2:10 , 3:20 dollars
    private int[] deposit_coin = new int[3]; // 0:5 , 1:10 , 2:25 cents
    private double deposit_total = 0;

    private int[] orders = new int[8];
    private double order_total = 0;

    private double[] prices = {1.65, 3.50, 2.80, 1.50, 1.85, 1.00, 3.25, 3.40};
    
    private void deposit(){
        String BC;
        int dol;

        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.print("Enter B for bills, C for coins, others to quit: ");
            BC = sc.next();

            if(BC.equals("B")){
                while(true){
                    dol = sc.nextInt();
                    if(dol == 1){
                        this.deposit_bill[0]++;
                        this.deposit_total += 1;
                    }
                    else if(dol == 5){
                        this.deposit_bill[1]++;
                        this.deposit_total += 5;
                    }
                    else if(dol == 10){
                        this.deposit_bill[2]++;
                        this.deposit_total += 10;
                    }
                    else if(dol == 20){
                        this.deposit_bill[3]++;
                        this.deposit_total += 20;
                    }
                    else if(dol == 0){
                        break;
                    }
                }
            }
            else if(BC.equals("C")){
                while(true){
                    dol = sc.nextInt();
                    if(dol == 5){
                        this.deposit_coin[0]++;
                        this.deposit_total += 0.5;
                    }
                    else if(dol == 10){
                        this.deposit_coin[1]++;
                        this.deposit_total += 0.10;
                    }
                    else if(dol == 25){
                        this.deposit_coin[2]++;
                        this.deposit_total += 0.25;
                    }
                    else if(dol == 0){
                        break;
                    }
                }
            }
            else{
                break;
            }
        }

        System.out.println("Total deposit: " + this.deposit_total);
    }


    private void refund(){
        System.out.println("Refund: " + this.deposit_total);

        for(int i=0; i<4; i++){
            if(this.deposit_bill[i] != 0){
                if(i == 0){
                    System.out.println("1 dollar bills: " + this.deposit_bill[i]);
                }
                else if(i == 1){
                    System.out.println("5 dollar bills: " + this.deposit_bill[i]);
                }
                else if(i == 2){
                    System.out.println("10 dollar bills: " + this.deposit_bill[i]);
                }
                else if(i == 3){
                    System.out.println("20 dollar bills: " + this.deposit_bill[i]);
                }
            }
        }

        for(int i=0; i<3; i++){
            if(this.deposit_coin[i] != 0){
                if(i == 0){
                    System.out.println("5 cents coins: " + this.deposit_coin[i]);
                }
                else if(i == 1){
                    System.out.println("10 cents coins: " + this.deposit_coin[i]);
                }
                else if(i == 2){
                    System.out.println("25 cents coins: " + this.deposit_coin[i]);
                }
            }
        }
    }

    private void printMenu(){
        // A: Coca Cola, unit price US $1.65
        // B: Minute Maid Orange Juice, unit price US $3.50
        // C: Evian Mineral Water, unit price US $2.80
        // D: M&M's Chocolate, unit price US $1.50
        // E: Hershey's Chocolate Bar, unit price US $1.85 F: Oreo Cookies, unit price US $1.00
        // G: Doritos Tortilla Chips, unit price US $3.25
        // H: Pringles Potato Chips, unit price US $3.40

        System.out.println("A: Coca Cola, unit price US $1.65");
        System.out.println("B: Minute Maid Orange Juice, unit price US $3.50");
        System.out.println("C: Evian Mineral Water, unit price US $2.80");
        System.out.println("D: M&M's Chocolate, unit price US $1.50");
        System.out.println("E: Hershey's Chocolate Bar, unit price US $1.85");
        System.out.println("F: Oreo Cookies, unit price US $1.00");
        System.out.println("G: Doritos Tortilla Chips, unit price US $3.25");
        System.out.println("H: Pringles Potato Chips, unit price US $3.40");
    }


    private void selectProduct(){
        String product;
        Scanner sc = new Scanner(System.in);

        this.printMenu();
        
        while(true){
            System.out.print("Enter one product code, Q to quit: ");
            product = sc.next();
            
            if('A' <= product.charAt(0) && product.charAt(0) <= 'H' && product.length() == 1){
                this.orders[product.charAt(0) - 'A']++;
                this.order_total += this.prices[product.charAt(0) - 'A'];
            }
            else if(product.equals("Q")){
                break;
            }
        }

        System.out.printf("Total order: %.2f\n", this.order_total);
        for(int i=0; i<8; i++){
            if(this.orders[i] != 0){
                System.out.println((char)(i + 'A') + ": " + this.orders[i]);
            }
        }
    }


    private void cancelProduct(){
        String product;
        Scanner sc = new Scanner(System.in);

        this.printMenu();

        // while(true){
            System.out.print("Enter one product code: ");
            product = sc.next();
            
            if('A' <= product.charAt(0) && product.charAt(0) <= 'H' && product.length() == 1){
                if(this.orders[product.charAt(0) - 'A'] != 0){
                    this.orders[product.charAt(0) - 'A']--;
                    this.order_total -= this.prices[product.charAt(0) - 'A'];
                }
            }
            // else if(product.equals("Q")){
            //     break;
            // }
        // }

        System.out.printf("Total order: %.2f\n", this.order_total);
        for(int i=0; i<8; i++){
            if(this.orders[i] != 0){
                System.out.println((char)(i + 'A') + ": " + this.orders[i]);
            }
        }
    }


    private void change(){
        this.deposit_total -= this.order_total;

        if(this.deposit_total == 0){
            System.out.println("No change, thank you!");
            return;
        }

        int[] change_bill = new int[4];
        int[] change_coin = new int[3];

        // bill
        change_bill[3] = (int)(this.deposit_total / 20);
        this.deposit_total -= change_bill[3] * 20;

        change_bill[2] = (int)(this.deposit_total / 10);
        this.deposit_total -= change_bill[2] * 10;

        change_bill[1] = (int)(this.deposit_total / 5);
        this.deposit_total -= change_bill[1] * 5;

        change_bill[0] = (int)(this.deposit_total / 1);
        this.deposit_total -= change_bill[0] * 1;

        // coin
        change_coin[2] = (int)(this.deposit_total / 0.25);
        this.deposit_total -= change_coin[2] * 0.25;

        change_coin[1] = (int)(this.deposit_total / 0.10);
        this.deposit_total -= change_coin[1] * 0.10;

        change_coin[0] = (int)(this.deposit_total / 0.05);
        this.deposit_total -= change_coin[0] * 0.05;


        System.out.println("Change: ");

        System.out.println("Bills: ");
        if(change_bill[3] != 0) System.out.println("20: " + change_bill[3]);
        if(change_bill[2] != 0) System.out.println("10: " + change_bill[2]);
        if(change_bill[1] != 0) System.out.println("5: " + change_bill[1]);
        if(change_bill[0] != 0) System.out.println("1: " + change_bill[0]);

        System.out.println("Coins: ");
        if(change_coin[2] != 0) System.out.println("0.25: " + change_coin[2]);
        if(change_coin[1] != 0) System.out.println("0.10: " + change_coin[1]);
        if(change_coin[0] != 0) System.out.println("0.05: " + change_coin[0]);
    }

    private void printCustomerOrder(){
        System.out.println("Customer Order: ");
        for(int i=0; i<8; i++){
            if(this.orders[i] != 0){
                System.out.println((char)(i + 'A') + ": " + this.orders[i]);
            }
        }
    }


    private int purchaseOrder(){
        if(this.order_total > this.deposit_total){
            System.out.println("Not enough money.");
            System.out.println("Please deposit more money.");
            this.deposit();

            return 0;
        }
        else{
            this.change();
            System.out.println("Thank you for your purchase.\n");
            
            this.printCustomerOrder();
            this.initOrder();

            return 1;
        }
    }


    private void initOrder(){
        for(int i=0; i<8; i++){
            this.orders[i] = 0;
        }

        for(int i=0; i<4; i++){
            this.deposit_bill[i] = 0;
        }

        for(int i=0; i<3; i++){
            this.deposit_coin[i] = 0;
        }

        this.order_total = 0;
        this.deposit_total = 0;
    }


    public void run(){
        System.out.println("\n\nWelcome to the vending machine!");

        String op;
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println();
            System.out.println("a. Deposit money");
            System.out.println("b. Select product");
            System.out.println("c. Cancel product");
            System.out.println("d. Purchase order");
            System.out.println("e. Abort transaction");
            System.out.printf("Deposit: %.2f\n", this.deposit_total);
            System.out.printf("Order: %.2f\n", this.order_total);
            System.out.print("Please select an option: ");
            op = sc.next();

            System.out.println();

            if(op.equals("a")){
                System.out.println("Please deposit your money.");
                this.deposit();
            }
            else if(op.equals("b")){
                System.out.println("Please select your product.");
                this.selectProduct();
            }
            else if(op.equals("c")){
                System.out.println("Please cancel your product.");
                this.cancelProduct();
            }
            else if(op.equals("d")){
                System.out.println("Purchasing order...");
                if(this.purchaseOrder() == 1){
                    break;
                }
            }
            else if(op.equals("e")){
                System.out.println("Abort transaction.");
                this.refund();
                break;
            }
        }

        this.initOrder();

        System.out.println("\n\nThank you for using the vending machine!");
    }
}