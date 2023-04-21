/*
Class: CMSC203 CRN 30376
Program: Assignment 5 Implementation
Instructor: Grinberg, Grigoriy
Summary of Description:

Minnie and Mickey are getting ready to send out Holiday bonuses
to their hard-working employees in Retail District #5.
The bonuses are calculated based on how much each retail store sold
in each category. The retail store with the highest amount sold
in a category will receive $5,000. The retail store
with the lowest amount sold in a category will receive $1,000.
All other retail stores in district #5 will receive $2,000.
If a retail store didn’t sale anything in a category, or
they have a negative sales amount, they are not eligible for a bonus in that category.
If only one retail store sold items in a category,
they are eligible to receive only the bonus of $5000 for that category.

Due Date: <04/17/2023>
Integrity Pledge: I pledge that I have completed the programming assignment independently.
I have not copied the code from a student or any source.
Student: Full Name : Lawrence Aryeh


*/
package com.holidaybonus;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility {


    public TwoDimRaggedArrayUtility(){

    }

    public static double getAverage(double[][] data){

        double total = 0; //an accumulator variable
        int count = 0;  // store number of elements

        for(int row = 0; row<data.length; row++)
        {
            for(int col = 0; col<data[row].length; col++)
            {
                total += data[row][col];// add to total
                count++; //add one to count
            }
        }

        return total/count; //return average -> total divided by number of elements

    }

    public static double getColumnTotal(double[][] data, int col)
    {

        double totalCol = 0; //an accumulator variable

        for(int row = 0; row < data.length; row++)
        {
            if((data[row].length-1) >= col)// if the col index is not out bound for the current row
                totalCol += data[row][col]; // add the column to totalCol
        }

        return totalCol; // return total in Column
    }

    public static double getHigestInArray(double[][]data)
    {
        double max = -9999999; //ultra negative number

        for(int row = 0; row < data.length; row++)
        {
            for(int col = 0; col < data[row].length; col++) // if the current element is  greater than max
            {
                double value = data[row][col];

                if(value > max) max = value; //if current index is greater than,  assign it to max
            }
        }

        return max;
    }

    public static double getHighestInColumn(double [][]data, int col)
    {
        double colMax = -999999999; // ultra negative number

        for(int row = 0; row < data.length; row++)
        {
            if((data[row].length-1) >= col) {  // if the value col is not out of bound for current row
                double value = data[row][col];

                if (value > colMax) colMax = value; // if the current one is greater than,  assign value to colMax
            }

        }

        return colMax;
    }

    public static int getHighestInColumnIndex(double [][]data, int col)
    {
        double colMax = -999999999;
        int index = 0; // store index

        for(int row = 0; row < data.length; row++)
        {
            if((data[row].length-1) >=col) // if the value of col is not out of bound for current row
            {
                double value = data[row][col];

                if (value > colMax) {
                    colMax = value; // if the current one is greater than,  assign value to colMax
                    index = row; // get the index of row
                }
            }
        }

        return index;
    }

    public static double getHighestInRow(double[][] data, int row )
    {
        double rowMax = -999999999;

        for(int col = 0; col < data[row].length; col++)
        {
            if((data[row].length-1) >= col) // if the value of col is not out of bound for current row
            {
                double value = data[row][col];

                if (value > rowMax) rowMax = value; // if the current one is greater than, assign value to rowMax
            }
        }

        return rowMax;
    }

    public static int getHigestInRowIndex(double[][]data, int row)
    {
        double rowMax = -999999999;
        int index = 0; // store index value

        for(int col = 0; col < data[row].length; col++)
        {
            double value = data[row][col];

            if(value > rowMax) {
                rowMax = value; // if the current one is greater than assign value to rowMax
                index = col; // get the index of column
            }
        }

        return index;
    }

    public static double getLowestInArray(double[][] data)
    {
        double min = 999999999;

        for(int row = 0; row < data.length; row++)
        {
            for(int col = 0; col < data[row].length; col++)
            {
                double value = data[row][col];

                if(value < min) min = value; //if current index is less than, assign it to min
            }
        }

        return min;
    }

    public static double getLowestInColumn(double[][]data, int col)
    {
        double colMin = 999999999;

        for(int row = 0; row < data.length; row++)
        {


            if((data[row].length-1) >= col) // if the value of col is not out of bound for current row
            {
                double value = data[row][col];

                if (value < colMin)
                    colMin = value; // if the current one is less than, assign value to colMax

            }

        }

        System.out.println(colMin);

        return colMin;
    }

    public static int getLowestInColumnIndex(double[][]data, int col)
    {
        double colMin = 999999999;
        int index = 0;
        for(int row = 0; row < data.length; row++)
        {
            if((data[row].length-1) >= col) {

                double value = data[row][col];

                if (value < colMin) {
                    colMin = value; // if the current one is less than, assign value to colMax
                    index = row; // get the index of row
                }
            }

        }

        return index;
    }

    public static double getLowestInRow(double[][]data, int row)
    {
        double rowMin = 999999999;

        for(int col = 0; col < data[row].length; col++)
        {
            double value = data[row][col];

            if(value < rowMin) rowMin = value; // if the current one is less than, assign value to rowMax

        }

        return rowMin;
    }

    public static int getLowestInRowIndex(double[][]data, int row)
    {
        double rowMin = 999999999;
        int index = 0;

        for(int col = 0; col < data[row].length; col++)
        {
            double value = data[row][col];

            if(value < rowMin) {
                rowMin = value; // if the current one is less then, assign value to rowMax
                index = col; // get the index of column
            }
        }

        return index;
    }

    public static double getRowTotal(double[][]data, int row)
    {
        double totalRow = 0;

        for(int col = 0; col < data[row].length; col++)
        {
            totalRow += data[row][col]; // add the columns of specified row to totalRow
        }

        return totalRow;
    }

    public static double getTotal(double[][]data)
    {
        double total = 0; // store total value

        for(int row = 0; row<data.length; row++)
        {
            for(int col = 0; col<data[row].length; col++)
                total += data[row][col];// add to total
        }

        return total;
    }

    public static double[][] readFile(File file)

    {
        //Create arraylist before converting to 2d array
        ArrayList<double[]> readFromFile = new ArrayList<>();

        try {


                Scanner scanner = new Scanner(file);

                while (scanner.hasNextLine())
                {
                    String[] rowString = scanner.nextLine().split(" ");
                    double[] row = new double[rowString.length];

                    for (int rows = 0; rows < rowString.length; rows++)// transverse the rowString array and change to double array for rows
                    {
                    row[rows] = Double.parseDouble(rowString[rows]);
                    }

                    readFromFile.add(row); // add to the arrayList
                }

            scanner.close();// close scanner to prevent memory leak

        }catch(IOException e) {System.out.println("Cannot read from or find the file");}; // throws exception and print file cannot be found or read

        double[][] districtArray = new double[readFromFile.size()][]; // initialize array with number of rows derived from readFromFile size

        for (int row = 0; row < readFromFile.size(); row++) // iterating through the readFromList
            districtArray[row] = readFromFile.get(row);

        for(int row=0; row < districtArray.length; row++)
        {
            for(int col = 0; col < districtArray[row].length; col++)
            {
                System.out.print(districtArray[row][col] + " ");
            }
            System.out.println();
        }

        return districtArray;

    }


    public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException
    {


                    PrintWriter output = new PrintWriter(outputFile);

                    for (int row = 0; row < data.length; row++) {

                        for (int col = 0; col < data[row].length; col++) {
                            output.print(data[row][col] + " ");
                        }

                        if(row < (data.length-1))
                            output.print("\n"); // go to new line for every row
                    }

                    output.close();






    }
}

