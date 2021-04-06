package edu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

import org.junit.jupiter.api.Test;

public class TestIsSorted {
    public Stack<Integer> of(int... arr){
        Stack<Integer> stack=new Stack<>();
        for(int i:arr){
            stack.push(i);
        }
        return stack;
    }

    public static boolean isSorted(Stack<Integer> s) {
        if (s.size() < 2) {
            return true;
        }
    
        boolean sorted = true;
        int prev = s.pop();
        Stack<Integer> backup = new Stack<Integer>();
        backup.push(prev);
        while (!s.isEmpty()) {
            int curr = s.pop();
            backup.push(curr);
            if (prev > curr) {
                sorted = false;
            }
            prev = curr;
        }
    
        while (!backup.isEmpty()) {   // restore s
            s.push(backup.pop());
        }
    
        return sorted;
    }

    @Test
    public void testSorted(){
        int[][] fixtures={
            {4,20,15,15,8,5,7,12,3,10,5,1},
            {1,3,4,5,6,8},
            {1,2,-2,4,-5,8,-8,12,-15},
            {1,-2,-10,11},
            {0,-1,-4,-5,-10,-13},
            {-1,-2,-3,-5,6,8,12,17}
        };

        for(int[] fixture:fixtures){
            int[] sorted=Arrays.stream(fixture).boxed().sorted(Comparator.reverseOrder()).mapToInt(i->i).toArray();
            Stack<Integer> arg=of(sorted);
            assertTrue(IsSorted.isSorted(arg), Arrays.toString(sorted));
        } 
    }

    @Test
    public void test_regular(){
        int[][] fixtures={
            {4,20,15,15,8,5,7,12,3,10,5,1},
            {1,3,4,5,6,8},
            {1,2,-2,4,-5,8,-8,12,-15},
            {1,-2,-10,11},
            {0,-1,-4,-5,-10,-13},
            {-1,-2,-3,-5,6,8,12,17}
        };

        for(int[] fixture:fixtures){
            assertEquals(isSorted(of(fixture)),IsSorted.isSorted(of(fixture)),Arrays.toString(fixture));
        } 
    }

}
