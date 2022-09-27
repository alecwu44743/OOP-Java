import java.util.Scanner;

public class _0927_DrawFigures{
    static void printTenBlanks(){
        for (int i=0; i<10; i++){
            System.out.print(" ");
        }
    }

    static void drawIsoscelesTriangle(int num){
        System.out.println();
        for(int layer=0; layer<num; layer++){
            printTenBlanks();

            if(layer == 0){
                for(int i=num-1; i>0; i--){
                    System.out.print(" ");
                }
                System.out.print("*");
            }
            else if(layer == num-1){
                for(int i=0; i<num*2-1; i++){
                    System.out.print("*");
                }
            }
            else{
                for(int i=num-layer-1; i>0; i--){
                    System.out.print(" ");
                }
                System.out.print("*");
                for(int i=0; i<layer*2-1; i++){
                    System.out.print(" ");
                }
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void drawSquare(int num){
        System.out.println();
        for(int layer=0; layer<num; layer++){
            printTenBlanks();

            if(layer == 0 || layer == num-1){
                for(int i=0; i<num; i++){
                    System.out.print("*");
                }
            }
            else{
                System.out.print("*");
                for(int i=0; i<num-2; i++){
                    System.out.print(" ");
                }
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void drawRhombus(int num){
        System.out.println();

        for(int layer=0; layer<2*num-1; layer++){
            printTenBlanks();

            int space = (layer < num) ? (num-layer-1) : (layer-num+1);
            for(int i=0; i<space; i++){
                System.out.print(" ");
            }

            if(layer == 0 || layer == 2*num-2){
                System.out.print("*");
            }
            else{
                System.out.print("*");
                for(int i=0; i<(num*2-1)-space*2-2; i++){
                    System.out.print("@");
                }
                System.out.print("*");
            }
            System.out.println();
        }
    }


    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int num;

        System.out.print(" Enter the side of an isosceles triangle (between 3 and 29): ");
        num = sc.nextInt();
        drawIsoscelesTriangle(num);

        System.out.print(" Enter the side of a square (between 2 and 30): ");
        num = sc.nextInt();
        drawSquare(num);

        System.out.print(" Enter the side of a rhombus (between 3 and 29): ");
        num = sc.nextInt();
        drawRhombus(num);
    }
}