/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

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
        if (args.length <= 0) {
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
        } else if (args[0].equals("-f")) {
            String fname = args[1];
            List<Integer> IntList = new List<>();
            int numitems = FillListFromFile(IntList, args[1]);
            TextHeader("Unsorted list");
            for (Integer vt : IntList) {
                System.out.println(vt);

            }
            IntList.BubbleSort();
            TextHeader("Sorted list");
            for (Integer vt : IntList) {
                System.out.println(vt);

            }
            // save to a file
            if (args.length > 2) {
                SaveListToFile(IntList, args[2]);
            }

        }
    }

    /**
     * *
     * outputs a list to a file
     *
     * @param list takes any type of list
     * @param FullFileName the outputfile name
     */
    public static void SaveListToFile(List list, String FullFileName) {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(FullFileName), "utf-8"))) {
            for (Object srted : list) {
                writer.write(srted.toString());
                writer.write("\n");
            }

        } catch (IOException IOexp) {
            System.err.println("Error outputting File");
            System.err.println(IOexp);
        }

    }

    /**
     * Added items to List<Integer> from File
     *
     * @param list List<Interger> list of integers
     * @param FullFileName Full path and file name to fill from
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

    /**
     * *
     * tester function for easy printing of text to console
     *
     * @param header
     */
    public static void TextHeader(String header) {
        System.out.println();
        System.out.println(header);
        div();

    }

    /**
     * helper function for making div in console
     */
    public static void div() {
        System.out.println("----------------------------------");
    }

}
