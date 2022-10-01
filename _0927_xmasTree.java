import java.util.Scanner;


public class _0927_xmasTree{
    static void printTenBlanks(){
        for (int i=0; i<10; i++){
            System.out.print(" ");
        }
    }

    static void printTopStar(int bottom){
        printTenBlanks();

        for(int i=0; i<(bottom-1)/2; i++){
            System.out.print(" ");
        }
        System.out.println("#");
    }

    static void printTrunk(int w, int h, int space){
        for(int i=0; i<h; i++){
            printTenBlanks();
            for(int j=0; j<space; j++){
                System.out.print(" ");
            }
            for(int j=0; j<w; j++){
                System.out.print("|");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of tiers (2 to 5): ");
        int number_of_tiers = sc.nextInt();

        System.out.print("Enter the side of the top triangle (3 to 6): ");
        int side_of_top_triangle = sc.nextInt();

        System.out.print("Enter the growth of two adjacent triangles (1 to 5): ");
        int growth_of_two_adjacent_triangles = sc.nextInt();

        System.out.print("Enter the width of the trunk (odd number, 3 to 9): ");
        int width_of_trunk = sc.nextInt();

        System.out.print("Enter the height of the trunk (4 to 10): ");
        int height_of_trunk = sc.nextInt();

        int bottom = (side_of_top_triangle + ((number_of_tiers - 1) * growth_of_two_adjacent_triangles)) * 2 - 1;
        // System.out.println("bottom: " + bottom);
        printTopStar(bottom);

        for(int tiers=0; tiers<number_of_tiers; tiers++){
            int side = side_of_top_triangle + growth_of_two_adjacent_triangles * tiers;
            // int bEdge = side * 2 - 1;

            for(int layer=1; layer<side; layer++){
                printTenBlanks();

                for(int i=0; i<(bottom-(2*layer+1))/2; i++){
                    System.out.print(" ");
                }

                System.out.print("#");
                for(int i=0; i<2*(layer-1)+1;i++){
                    System.out.printf("%s", (layer == side-1) ? "#" : "@"); 
                }
                System.out.println("#");
            }
        }

        printTrunk(width_of_trunk, height_of_trunk, (bottom-width_of_trunk)/2);
    }
}