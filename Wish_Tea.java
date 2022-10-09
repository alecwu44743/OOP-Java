import java.util.Scanner;

public class Wish_Tea {
    public static void main(String[] args){
        Tea teas[];
        teas = new Tea[10];
        
        char exit;
        int ccase = 0;

        int totalamount = 0;
        double totalcash = 0;
        Menu();
        do {
            Scanner scan = new Scanner(System.in);
    
            System.out.println("[+] Please input your order [+]");
            System.out.print("Name of tea:");
            String name = scan.nextLine();
            System.out.print("Size of the tea (S|M|L):");
            char size = scan.next().charAt(0);
            System.out.print("Ice level:");
            int icelvl = scan.nextInt();
            System.out.print("Topping |1|Yes |0|No:");
            int topping = scan.nextInt();
            System.out.print("The amount of tea:");
            int amount = scan.nextInt();
            teas[ccase] = new Tea(name, size, icelvl, topping, amount);
            
            ccase++;
            
            if(ccase == 10){
                System.out.println("Maximum Orders!!");
                break;
            }
            System.out.print("Continue to order? (y/n):");
            exit = scan.next().charAt(0);
        } while(exit != 'n');

        System.out.print("\n\n");
        System.out.println("Order Description");
        System.out.println("=======================================================================");
        
        int cnt = 1;
        for(int i=0;i<ccase;i++){
            String str = teas[i].getDescription();
            System.out.printf("%2d. ",cnt++);
            System.out.println(str);

            totalcash += teas[i].calcCost();
            totalamount += teas[i].amount;
        }
        System.out.println("-----------------------------------------------------------------------");
        System.out.printf("    Total Cost                                      %2d        $%.0f\n",totalamount,totalcash);
        System.out.println("=======================================================================");
    }
    public static void Menu(){
        System.out.println(" ------------------------------Menu----------------------------- ");
        System.out.println("|  Tea Name  Small(S)  Medium(M)  Large(L)                      |");
        System.out.println("|  Green tea   $60       $70        $80     (+5$ for topping)   |");
        System.out.println("|  Black tea   $55       $65        $75     (+5$ for topping)   |");
        System.out.println("|  Lemon tea   $65       $80        $95     (+10$ for topping)  |");
        System.out.println(" ------------------------------Ice------------------------------ ");
        System.out.println(""" 
        |  \033[5;30;47m(1)\033[0;37;40mno ice                                                    |
        |  \033[5;30;47m(2)\033[0;37;40ma little                                                  |
        |  \033[5;30;47m(3)\033[0;37;40mregular                                                   |""");
        System.out.println(" ---------------------------------------------------------------");
    }
    
}
class Tea{
    private String name;
    private char size;
    private int icelvl;
    private int topping;
    int amount;
    double cash;
    public Tea(String name,char size,int icelvl,int topping,int amount){
        this.name = name;
        this.size = size;
        this.icelvl = icelvl;
        this.topping = topping;
        this.amount = amount;
        switch (name) {
            case "Green tea":
                switch (size) {
                    case 'S':
                        cash = 60;
                        break;
                    case 'M':
                        cash = 70;
                        break;
                    case 'L':
                        cash = 80;
                        break;
                }
                cash += 5*topping;
                cash *= amount;
                break;
        
            case "Black tea":
                switch (size) {
                    case 'S':
                        cash = 55;
                        break;
                    case 'M':
                        cash = 65;
                        break;
                    case 'L':
                        cash = 75;
                        break;
                }
                cash += 5*topping;
                cash *= amount;
                break;
            case "Lemon tea":
                switch (size) {
                    case 'S':
                        cash = 65;
                        break;
                    case 'M':
                        cash = 80;
                        break;
                    case 'L':
                        cash = 95;
                        break;
                }
                cash += 10*topping;
                cash *= amount;
                break;
        }
    }
    public String getsize(char size){
        String str = " ";
        switch (size) {
            case 'S':
                str = "Small";
                return str;
            case 'M':
                str = "Medium";
                return str;
            case 'L':
                str = "Large ";
                return str;
        }
        return str;
    }
    public String gettopping(int topping){
        switch(topping){
            case 1:
                return "Topping   ";
            case 0:
                return "No Topping";
        }
        
        return " ";
    }
    public double calcCost(){
        return cash*1.05;
    }
    public String getDescription() {
        String sizString = getsize(size);
        String toppString = gettopping(topping);
        String str = name +"      "+ sizString +"      "+ toppString +"            "+ amount +"        $"+ Math.round(calcCost());
        return str;
    }
}