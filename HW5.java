/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author ralph
 */
public class HW5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        List<String> theData = new List<String>();
        theData.AddItem("One").AddItem("Two").AddItem("Three").AddItem("Four").AddItem("Five");
        theData.BubbleSort();
        for (String dt : theData) {
            System.out.println(dt);

        }

        List<Integer> intLIst = new List<>();
        intLIst.AddItem(9).AddItem(8).AddItem(7).AddItem(6).AddItem(5);
        System.out.println("---------------------------");
        intLIst.BubbleSort();
        for (Integer vt : intLIst) {
            System.out.println(vt);

        }

    }
/**
 * Added items to List<Integer> from File
 * @param list  List<Interger>  list of integers 
 * @param FullFileName  Full path and file name to fill from
 * @return number of items added to list
 */
    public static int FillListFromFile(List<Integer> list, String FullFileName) {
        int retval = 0;
        File InputFile = new File(FullFileName);
        try {
            FileReader inputFileReader = new FileReader(InputFile);
            BufferedReader InputReader = new BufferedReader(inputFileReader);

            String line;
            while ((line = InputReader.readLine()) != null) {
                if (line.trim().length() > 0) {
                    try {
                        int parsed = Integer.parseInt(line);
                        list.AddItem(parsed);
                        retval++;
                    } catch (NumberFormatException nfe) {
                        System.err.print("Invalid Item - ");
                        System.err.println(line);
                    }
                }
            }
            inputFileReader.close();
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
        return retval;
    }

}
