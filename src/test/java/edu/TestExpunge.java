package edu;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestExpunge {
    

    public static void expunge(Stack<Integer> s) {
        if (!s.isEmpty()) {
            // copy sorted contents into temp stack s2
            Stack<Integer> s2 = new Stack<Integer>();
            int prev;
            while (!s.isEmpty()) {
                prev = s.pop();
                while (!s.isEmpty() && s.peek() < prev) {
                    s.pop();
                }
                s2.push(prev);
            }
    
            // transfer s2 back into s
            while (!s2.isEmpty()) {
                s.push(s2.pop());
            }
        }
    }

    public Stack<Integer> of(int... arr){
        Stack<Integer> stack=new Stack<>();
        for(int i:arr){
            stack.push(i);
        }
        return stack;
    }

    @Test
    public void test_empty(){
        Stack<Integer> empty=new Stack<>();
        Expunge.expunge(empty);
        assertTrue(empty.isEmpty());
    }

    @Test
    public void test_regular(){
        int[][] fixtures={
            {4,20,15,15,8,5,7,12,3,10,5,1},
            {1,3,4,5,6,8},
            {1,2,-2,4,-5,8,-8,12,-15},
            {1,-2,-10,11},
            {0,-1,-4,-5,-10,-13},
            {-1,-2,-3,-5,6,8,12,17},
            {}
        };

        for(int[] fixture:fixtures){
            Stack<Integer> arg=of(fixture);
            Stack<Integer> expected=of(fixture);

            Expunge.expunge(arg);
            expunge(expected);
            assertEquals(expected.toString(), arg.toString());
        } 
    }


}
