package siit.homework04;

import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        LibraryCatalog instance = new LibraryCatalog();
        /*
        the add method is adding the Novels bookToAdd
         */
        Novels bookToAdd= new Novels("Argentina", 432, "Travel");

        System.out.println("type the action that you need : add, delete or list ");

        String action;
        Scanner in=new Scanner(System.in);
        action = in.nextLine();
        //System.out.println(action);

        if(action.equals("add")){

            System.out.println(Arrays.toString(instance.addTitle(bookToAdd)));
        } else if (action.equals("delete")) {

            System.out.println(Arrays.toString(instance.deleteTitle()));
        }else if (action.equals("list")){

            System.out.println(Arrays.toString(instance.listTitles()));
        }else{
            System.out.println("the action typed is not recognized, please insert one of the following actions: add, delete or list");
        }


    }



}