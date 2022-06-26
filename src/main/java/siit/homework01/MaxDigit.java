package siit.homework01;


//3. Display the max digit from a number.

import java.util.Scanner;

public class MaxDigit {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a number");
        int number=keyboard.nextInt();
        int max=number % 10 ;

        while (number > 0 ){
            if(number % 10 > max) {
                max = number % 10;
            }
            number=number / 10;
        }

        System.out.println(max);
    }
}

