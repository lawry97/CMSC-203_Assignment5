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

public class HolidayBonus {

    private static int highestBonus = 5000;
    private static  int lowestBonus = 1000;
    private static int bonus = 2000;

    public HolidayBonus()
    {

    }

    static double[] calculateHolidayBonus(double[][] data)
    {
        double [] bonus_for_each = new double[data.length];




        for(int row = 0; row < data.length; row++)
        {

            for(int col = 0; col < data[row].length; col++)
            {
                if(data[row][col]<= 0 )
                    continue;

                if(data[row][col] == TwoDimRaggedArrayUtility.getHighestInColumn(data, col)){
                    bonus_for_each[row] += highestBonus;
                }
                else if(data[row][col] == TwoDimRaggedArrayUtility.getLowestInColumn(data, col)) {
                    bonus_for_each[row] += lowestBonus;
                }
                else
                    bonus_for_each[row] += bonus;

            }
        }

        return bonus_for_each;
    }

    static double calculateTotalHolidayBonus(double[][] data)
    {
        double[] bonuses = calculateHolidayBonus(data);

        System.out.println(bonuses.length);
        double total = 0;

        for(int i= 0; i < bonuses.length; i++)
        {
            total +=bonuses[i];
            //System.out.print(bonuses[i]+ " ");
        }

        //System.out.println(total);
        return total;
    }
}
