package com.holidaybonus;


import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class TwoDimRaggedArrayUtilityStudentTest {

    //data sets
    private double[][] data1 = {{7,8,9}, {4,3,9}};
    private double [][] data2 = {{9,4,7,1}, {5,8,7,10,11}, {5,7,18}, {5,9,12}};
    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
        data1 = null;
        data2 = null;
    }

    @Test
    public void getAverage() {

        assertEquals(6.67, TwoDimRaggedArrayUtility.getAverage(data1), .01);
        assertEquals(7.86, TwoDimRaggedArrayUtility.getAverage(data2), .01);

    }

    @Test
    public void getColumnTotal() {

        assertEquals(11.0, TwoDimRaggedArrayUtility.getColumnTotal(data1,0),.001);
        assertEquals(28.0, TwoDimRaggedArrayUtility.getColumnTotal(data2, 1), .001);
    }

    @Test
    public void getHigestInArray() {
        assertEquals(9.0, TwoDimRaggedArrayUtility.getHigestInArray(data1), .001);
        assertEquals(18.0,TwoDimRaggedArrayUtility.getHigestInArray(data2), .001);
    }

    @Test
    public void getHighestInColumn() {
        assertEquals(8.0, TwoDimRaggedArrayUtility.getHighestInColumn(data1,1),.001);
        assertEquals(18.0, TwoDimRaggedArrayUtility.getHighestInColumn(data2, 2), .001);
    }

    @Test
    public void getHighestInColumnIndex() {
        assertEquals(0, TwoDimRaggedArrayUtility.getHighestInColumnIndex(data1,1), .001);
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(data2, 2), .001);
    }

    @Test
    public void getHighestInRow() {
        assertEquals(9.0, TwoDimRaggedArrayUtility.getHighestInRow(data1,0), .001);
        assertEquals(11.0, TwoDimRaggedArrayUtility.getHighestInRow(data2,1), .001);
    }

    @Test
    public void getHigestInRowIndex() {
        assertEquals(2, TwoDimRaggedArrayUtility.getHigestInRowIndex(data1, 0), .001);
        assertEquals(4, TwoDimRaggedArrayUtility.getHigestInRowIndex(data2, 1), .001);
    }

    @Test
    public void getLowestInArray() {

        assertEquals(3.0, TwoDimRaggedArrayUtility.getLowestInArray(data1), .001);
        assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInArray(data2), .001);
    }


    @Test
    public void getLowestInColumn() {

        assertEquals(4.0, TwoDimRaggedArrayUtility.getLowestInColumn(data1, 0), .001);
        assertEquals(1, TwoDimRaggedArrayUtility.getLowestInColumn(data2, 3), .001);
    }

    @Test
    public void getLowestInColumnIndex() {

        assertEquals(1, TwoDimRaggedArrayUtility.getLowestInColumnIndex(data1,0), .001);
        //assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(data2, 3), .001);

    }

    @Test
    public void getLowestInRow() {

        assertEquals(7.0, TwoDimRaggedArrayUtility.getLowestInRow(data1,0), .001);
        assertEquals(5, TwoDimRaggedArrayUtility.getLowestInRow(data2,1), .001);

    }

    @Test
    public void getLowestInRowIndex() {

        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(data1, 0), .001);
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(data2, 1), .001);

    }

    @Test
    public void getRowTotal() {

        assertEquals(16.0, TwoDimRaggedArrayUtility.getRowTotal(data1, 1), .001);
        assertEquals(30.0, TwoDimRaggedArrayUtility.getRowTotal(data2, 2), .001);
    }

    @Test
    public void getTotal() {

        assertEquals(40.0, TwoDimRaggedArrayUtility.getTotal(data1), .001);
        assertEquals(118.0, TwoDimRaggedArrayUtility.getTotal(data2), .001);
    }
    //{{7,8,9}, {4,3,9}};
    //{{9,4,7,1}, {5,8,7,10,11}, {5,7,18}, {5,9,12}};
    @Test
    public void readFile() throws IOException {

        //for dataset1
        File file1 = new File("data1.txt");

        TwoDimRaggedArrayUtility.writeToFile(data1, file1);

        double[][] dataArrayTest1 = {{7, 8, 9}, {4, 3, 9}};
        double[][] dataArray1 = TwoDimRaggedArrayUtility.readFile(file1);

        assertThat(dataArrayTest1).isDeepEqualTo(dataArray1);


        //for dataset2
        File file2 = new File("data2.txt");

        TwoDimRaggedArrayUtility.writeToFile(data2, file2);

        double[][] dataArrayTest2 = {{9,4,7,1}, {5,8,7,10,11}, {5,7,18}, {5,9,12}};
        double[][] dataArray2 = TwoDimRaggedArrayUtility.readFile(file2);

        assertThat(dataArrayTest2).isDeepEqualTo(dataArray2);

     }

    @Test
    public void writeToFile()  throws IOException {

        //for dataset1
        File file1 = new File("data1.txt");

        TwoDimRaggedArrayUtility.writeToFile(data1, file1);

        String fileContent1 = Files.readString(file1.toPath());

        System.out.print(fileContent1);

        String checkString1 = "7.0 8.0 9.0 " +
                "\n" + "4.0 3.0 9.0 ";

        assertEquals(checkString1, fileContent1);

        //for dataset2
        File file2 = new File("data2.txt");

        TwoDimRaggedArrayUtility.writeToFile(data2, file2);

        String fileContent2 = Files.readString(file2.toPath());

        System.out.print(fileContent2);

        String checkString2 = "9.0 4.0 7.0 1.0 " +
                "\n" + "5.0 8.0 7.0 10.0 11.0 " +
                "\n" + "5.0 7.0 18.0 " +
                "\n"  + "5.0 9.0 12.0 ";

        assertEquals(checkString2, fileContent2);

    }



    //{{7,8,9}, {4,3,9}};
    //{{9,4,7,1}, {5,8,7,10,11}, {5,7,18}, {5,9,12}};
}