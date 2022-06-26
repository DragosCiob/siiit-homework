package siit.homework04;

import java.util.Arrays;
import java.util.Scanner;

public class LibraryCatalog {

    private Books[] libraryCatalog;



    public  LibraryCatalog(){

        // currently the libraryCatalog has only 3 books

        libraryCatalog= new Books[3];
        libraryCatalog[0]= new Novels("War", 436, "History");
        libraryCatalog[1]= new Novels("Mars", 245, "Fantasy");
        libraryCatalog[2]= new ArtAlbums("Summer", 36, 2);


    }
    public  Books[] addTitle(Books bookToAdd) {
        System.out.println("before");

        System.out.println(Arrays.toString(libraryCatalog));

        Books[] updatedCatalog=new Books [libraryCatalog.length+1];

        for (int i=0; i<=libraryCatalog.length-1; i++) {

            updatedCatalog[i]=libraryCatalog[i];

            updatedCatalog[libraryCatalog.length]=bookToAdd;

        }
        System.out.println("after");

        return updatedCatalog;

    }



    public  Books[] deleteTitle() {


        System.out.println("before");

        System.out.println(Arrays.toString(libraryCatalog));

        Scanner in = new Scanner(System.in);
        System.out.println("type the name of the book that you want to delete");
        String nameToSearch=in.nextLine();

        Books[] updatedCatalog=new Books [libraryCatalog.length-1];

        for(int i = 0; i < libraryCatalog.length; i++){
            if(libraryCatalog[i].getName().equals(nameToSearch)){


                for(int index = 0; index < i; index++){
                    updatedCatalog[index] = libraryCatalog[index];
                }
                for(int j = i; j < libraryCatalog.length - 1; j++){
                    updatedCatalog[j] = libraryCatalog[j+1];
                }
                break;
            }
        }
        System.out.println("after");

        return updatedCatalog;
    }
    public  Books[] listTitles() {

        System.out.println("Currently this catalog has"+" "+ libraryCatalog.length+" "+ "items");
        return libraryCatalog;
    }


}

