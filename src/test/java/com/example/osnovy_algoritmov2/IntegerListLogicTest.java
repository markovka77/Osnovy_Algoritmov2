package com.example.osnovy_algoritmov2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Value;

import static com.example.osnovy_algoritmov2.IntegerListLogic.nums;
import static org.junit.jupiter.api.Assertions.*;

class IntegerListLogicTest {

    Integer[] testing = {3,4,7,3,6,9,4,6,5,1,0,8,6};

    IntegerList integerList = new IntegerListLogic();


    @Test
     void testAdd() {
        Integer expected = integerList.add(12);
        Assertions.assertEquals(expected, 12);

    }

    @Test
    void set() {
        Integer expected = integerList.add(1, 88);
        Assertions.assertEquals(expected, 88);
    }



    @Test
    void testRemove() throws ElementNotFoundException {
       integerList.remove(2);
       assertNotEquals(nums[2],7);

    }

    @Test
    void indexOf() {
        for (int i = 0; i < testing.length; i++) {
            if(testing[i].equals(9)){
                int actual=i;
                assertEquals(5,actual);
            }
        }

    }

    @Test
    void lastIndexOf() {
        int actual;
        for (int i = testing.length - 1; i >= 0; i--) {
            if (testing[i].equals(10)) {
                actual = i;
            } else {
                actual = -1;
            }
            Assertions.assertEquals(-1, actual);
        }
    }

    @Test
    void get() {
        Integer actual;
        actual=testing[2];
        Assertions.assertEquals(7,actual);
    }

    @Test
    void testEquals() {
        Integer[] actTest =new Integer[]{6,3,7,9};
        if(testing.equals(actTest)){
            boolean actual= true;
            Assertions.assertEquals(true,actual);
        }
    }

    @Test
    void size() {
        int actualSize= testing.length;
        assertEquals(13,actualSize);

    }


}