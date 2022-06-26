package siit.homework02;


// 5. Display all the prime numbers lower than a given number

import java.util.Scanner;

public class PrimeNumbers {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a number");
        int number = keyboard.nextInt();

        if( number <= 1){
            System.out.println("enter a number greater than 1");
        }
        else {
            System.out.println("following are prime numbers");
            for(int i = 2; i <= number; i++){
                boolean isPrimeNumber = true;
                for(int j = 2; j <= i/2; j++){
                    if (i % j == 0){
                        isPrimeNumber = false;
                        break;
                    }
                }

                if(isPrimeNumber){
                    System.out.println(i +" ");
                }

            }
        }

    }
}
