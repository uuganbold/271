package edu;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestReorder {
    


    @Test
    public void test_regular(){
        Integer[][] fixtures={
            {},
            {1,3,4,5,6,8},
            {1,2,-2,4,-5,8,-8,12,-15},
            {1,-2,-10,11},
            {0,-1,-4,-5,-10,-13},
            {-1,-2,-3,-5,6,8,12,17}
        };

        for(Integer[] fixture:fixtures){
            Queue<Integer> arg=new LinkedList<Integer>(Arrays.asList(fixture));
            Reorder.reorder(arg);
            assertEquals(Arrays.stream(fixture).sorted().collect(Collectors.toList()).toString(), arg.toString());
        }

        
    }
}
