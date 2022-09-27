import java.util.Scanner;

public class _0927_GuessNumber{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int guess, answer, times=0;
        answer = (int)(Math.random()*1000) + 1;
        do{
            times++;
            System.out.print(">>> Enter an interger between 1 and 1000: ");
            guess = sc.nextInt();

            if (guess > answer)
                System.out.println("Your guess " + guess + " is too large. Try again\n");
            else if (guess < answer)
                System.out.println("Your guess " + guess + " is too small. Try again\n");

        } while (guess != answer);


        System.out.println("Congratulations! Your guess " + guess + " is correct!\n");
        if (times == 1){
            System.out.println("You guess " + times + " time.");
        }
        else{
            System.out.println("You guess " + times + " times.");
        }
        // System.out.println("You guess " + times + " times.");
    }
}