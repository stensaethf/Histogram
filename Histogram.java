/**
 * Histogram.java
 * A Java program that takes in values from a file and dispays them by count
 * in a histogram.
 * Created by Frederik Roenn Stensaeth and Javier Moran.
 * 05.11.14
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/** Class that takes in values from a file,
 * and dispays them by count in a histogram. */
public class Histogram {
    private List<Double> list;
    private double range;
    private double lowest;
    private double highest;

    /** Creates an histogram with the given minimum, 
     * maximum and number of bins. */
    public Histogram(double min, double max, int num_bins) {
        list = new MysteryListImplementation<Double>();
        range = (max - min) / num_bins;
        //Creates the number of bins necesarry for the histogram.
        //Adds two additional bins in order to count numbers that are out
        //of range.
        for(int i = 0; i < num_bins + 2; i++) {
            list.add((double)0);
        }
        lowest = min;
        highest = max;
    }

    /** This method counts how many numbers between each range occur. */
    public void addValue(double val) {
        //Adds one to the count of integers that exceed the maximum boundary.
        if (val > highest) {
            list.replace(list.length() - 1,
                         list.at(list.length() - 1) + (double)1);
        }
        //Counts the number of values inferior to the minum boundary. 
        else if(val <= lowest) {
            list.replace(0, (list.at(0)) + (double)1);
        //Determines in which bin (range) each number falls. 
        //Keeps track of the amount of items that fall in each bin. 
        } else {
            double check = lowest;
            int count = 0;
            while(val > check) {
                check += range;
                count++;
            }
            list.replace(count, list.at(count) + (double)1);
        }
    }

    /** Prints the result of the Histogram. */
    public void print() {
        //Creates a string of "*" of the same length as
        //the number of items that were counted in the first bin.
        String str = "";
        for(int i = 0; i < list.at(0); i++) {
            str += "*";
        }
        //Formats and prints the first bin, so that it has a specific length.
        if (list.at(0) > 0) {
            System.out.printf("<= %-16.2f | %s\n", lowest, str);
        }

        double beg = lowest;
        double end = lowest + range;
        //Creates a string of "*" of the same length as
        //the number of items that were counted in each bin.
        for(int i = 1; i < list.length() - 1; i++){
            str = ""; 
            for(int j = 0; j < list.at(i); j++) {
                str += "*";
            }
            //Formats and prints the first bin, 
            //so that it is justified with the rest of the file.
            System.out.printf("%-6.2f - %-10.2f | %s\n", beg, end, str);
            beg = end;
            end += range;  
        }
        //Creates a string of "*" of the same length as
        //the number of items that were counted in the last bin.
        //The last bin is the bin for numbers that exceed the maximum value.
        str = ""; 
        for(int i = 0; i < list.at(list.length() - 1); i++) {
            str += "*";
        }
        if (list.at(list.length() - 1) > 0) {
        System.out.printf("> %-17.2f | %s\n", highest, str);
        }
    }
    /** Main function that creates a Histogram 
     * by taking command line arguments, and reading a file. */
    public static void main(String[] args) {
        //Checks for the correct number of arguments.
        if(args.length != 4) {
            System.out.println("Usage java Histogram Min Max Bin FilePath");
            System.exit(1);
        }
        //Parses the arguments into the needed format.
        Double arg0 = Double.parseDouble(args[0]);
        Double arg1 = Double.parseDouble(args[1]);
        Integer arg2 = Integer.parseInt(args[2]);
        //Calls Histogram with the given arguments.
        Histogram histogram_test = new Histogram(arg0, arg1, arg2);
        //Uses scanner, to read values of a file and add them to Histogram.
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(args[3]));
        } catch(FileNotFoundException e) {
            System.err.println(e);
            System.exit(1);
        }
        while(scanner.hasNext()) {
            histogram_test.addValue(Double.parseDouble(scanner.next()));
        }
        histogram_test.print();
    }
}