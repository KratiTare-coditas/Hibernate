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
        boolean flag=true;
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        while(flag)
        {
            System.out.println("1.Insert Zoo 2.Insert Animal in particular zoo 3.Delete zoo 4.Delete Animal 5.Update animal 6.Update zoo 7.findbyage 8.  9");

            System.out.println("Enter ur choice");
            int ch=Integer.parseInt(sc.readLine());
            switch(ch)
            {
                case 1:
                    ZooDao.createZoo();
                    break;
                case 2:
                    AnimalDao.createanimal();
                    break;
                case 3:
                    ZooDao.deletezoo();
                    break;
                case 4:
                    AnimalDao.delete();
                    break;

                case 5:
                    AnimalDao.updateAnimal();
                    break;
                case 6:
                    ZooDao.updatezoo();
                    break;

                case 7:

                    AnimalDao.findbyage();

                    break;

                case 8:

                    AnimalDao.findbyname();

                    break;
                case 9:
                    AnimalDao.findbycategory();

                default:
                    System.out.println("Invalid input");
                    break;
            }

        }
    }
}
