package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {

        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        boolean flag=true;

        while(flag) {
            System.out.println("1.CREATE Book 2.Update Book 3.RETRIEVE Book 4. Delete Book 5.Create lib 6.Get price in between 7.greater than query ");
            System.out.println("Enter ur choice");
            int ch = Integer.parseInt(sc.readLine());

            switch(ch)
            {
                case 1:

                    BookDao.create();
                    break;
                case 2:
                    BookDao.update();
                    break;

                case 3:
                    BookDao.retrieve();
                    break;
                case 4:
                    BookDao.delete();
                    break;
                case 5:
                    LibraryDao.createlib();
                case 6:
                    Query.getpriceinBetween();
                    break;
                case 7:
                    System.out.println("Enter price");
                    int price=Integer.parseInt(sc.readLine());
                    Query.getBooksByPriceGreaterThan(price);
                    break;

                default:
                    break;

            }


        }
    }
}
