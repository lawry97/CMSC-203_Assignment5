package com.holidaybonus;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Executable;

import static org.junit.jupiter.api.Assertions.*;

class HolidayBonusStudentTest {

    private double[][] data1 = {{7,8,9}, {4,3,10}};
    private double [][] data2 = {{9,4,7,1},
                                 {6,8,6,10,11},
                                 {5,7,18},
                                 {7,9,12}};

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
        data1 = data2 = null;
    }

    @Test
    public void calculateHolidayBonusData1()
    {
        try {
                double[] bonus = HolidayBonus.calculateHolidayBonus(data1);
                assertEquals(11000, bonus[0], .001 );
                assertEquals(7000, bonus[1], .001);
        }catch (Exception e) { fail("Should not happen");}
    }

    @Test
    public void calculateHolidayBonusData2() {
        //try {

            double[] bonus = HolidayBonus.calculateHolidayBonus(data2);
            assertEquals(9000, bonus[0], .001);
            assertEquals(15000, bonus[1], .001);
            assertEquals(8000, bonus[2], .001);
            assertEquals(9000, bonus[3], .001);

        //} catch (Exception e) {
            //fail("Should not happen");
        //}
    }

        @Test
        public void calculateTotalHolidayBonus () {

            assertEquals(41000, HolidayBonus.calculateTotalHolidayBonus(data2));
            assertEquals(18000, HolidayBonus.calculateTotalHolidayBonus(data1));

        }
}
