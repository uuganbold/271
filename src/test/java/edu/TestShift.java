package edu;

import java.util.Arrays;
import java.util.Queue;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestShift {


    public Stack<Integer> of(int... arr){
        Stack<Integer> stack=new Stack<>();
        for(int i:arr){
            stack.push(i);
        }
        return stack;
    }

    public void shift(Stack<Integer> s, int n) {
        Queue<Integer> q = new LinkedList<Integer>();
        int otherSize = s.size() - n;
        for (int i = 0; i < otherSize; i++) {
            q.add(s.pop());
        }
        while (!q.isEmpty()) {
            s.push(q.remove());
        }
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
        while (!q.isEmpty()) {
            s.push(q.remove());
        }
    }

    @Test
    public void test_noshift(){
        int[][] fixtures={
            {},
            {1,3,4,5,6,8},
            {1,2,-2,4,-5,8,-8,12,-15},
            {1,-2,-10,11},
            {0,-1,-4,-5,-10,-13},
            {-1,-2,-3,-5,6,8,12,17}
        };
        for(int[] fixture:fixtures){
            Stack<Integer> arg=of(fixture);
            Stack<Integer> expected=of(fixture);
            Shift.shift(arg,0);
            shift(expected,0);
            assertEquals(expected.toString(), arg.toString());
        }  
    }

    @Test
    public void test_one(){
        int[][] fixtures={
            {1,3,4,5,6,8},
            {1,2,-2,4,-5,8,-8,12,-15},
            {1,-2,-10,11},
            {0,-1,-4,-5,-10,-13},
            {-1,-2,-3,-5,6,8,12,17}
        };
        for(int[] fixture:fixtures){
            Stack<Integer> arg=of(fixture);
            Stack<Integer> expected=of(fixture);
            Shift.shift(arg,1);
            shift(expected,1);
            assertEquals(expected.toString(), arg.toString());
        }  
    }

    @Test
    public void test_some(){
        int[][] fixtures={
            {1,3,4,5,6,8},
            {1,2,-2,4,-5,8,-8,12,-15},
            {1,-2,-10,11},
            {0,-1,-4,-5,-10,-13},
            {-1,-2,-3,-5,6,8,12,17}
        };
        for(int[] fixture:fixtures){
            Stack<Integer> arg=of(fixture);
            Stack<Integer> expected=of(fixture);

            Random r=new Random();
            int n=r.nextInt(fixture.length);
            Shift.shift(arg,n);
            shift(expected,n);
            assertEquals(expected.toString(), arg.toString());
        } 
    }

    @Test
    public void test_all(){
        int[][] fixtures={
            {1,3,4,5,6,8},
            {1,2,-2,4,-5,8,-8,12,-15},
            {1,-2,-10,11},
            {0,-1,-4,-5,-10,-13},
            {-1,-2,-3,-5,6,8,12,17}
        };
        for(int[] fixture:fixtures){
            Stack<Integer> arg=of(fixture);
            Stack<Integer> expected=of(fixture);

            Shift.shift(arg,fixture.length);
            shift(expected,fixture.length);
            assertEquals(expected.toString(), arg.toString());
        } 
    }
}
