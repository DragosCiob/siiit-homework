package siit.homework01;


//2. Display the smallest number from an array of number

public class SmallestNumber {
    public static void main(String[] args) {
        int[] anArray={8, 16, 47, 121, 5, 18, 65,99,34};
        int s = anArray[0];

        for (int i=0; i<anArray.length; i++){

            if(anArray[i] < s){

                s=anArray[i];
            }
        }

        System.out.println(s);

    }
}
