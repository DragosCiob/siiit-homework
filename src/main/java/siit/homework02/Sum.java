package siit.homework02;

// 1. Calculate the sum of the first 100 numbers higher than 0

public class Sum {

    public static void main(String[] args) {


        int a = 0;
        int b = a + 100;

        int sum = 0;

        for (int i = a; i <= b; i++)
            sum = sum + i;

        System.out.println ("The sum is " + sum);

    }

}
