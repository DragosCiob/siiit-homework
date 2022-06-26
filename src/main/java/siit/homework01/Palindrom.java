package siit.homework01;

// 4. Check if a number is palindrom( e.g palindrom 1221, 34143)

import java.util.Scanner;

public class Palindrom {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a number");
        int number = keyboard.nextInt();
        int  original = number;
        int rev = 0;

        if( number < 0){
            System.out.println("enter a number greater than 1");
        }

        while (number != 0 ){
            rev=rev*10+number%10;
            number=number/10;
        }

        if (original == rev ){
            System.out.println(original + "is a palindrome number");
        }
        else {
            System.out.println(original + "is not a palindrome number");
        }

    }
}