package edu;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestReverseFirstK {
    
    ReverseFirstK object;

    @BeforeEach
    public void setup(){
        object=new ReverseFirstK();
    }

    public static void reverseFirstK(int k, Queue<Integer> q) {
        if (q == null || k > q.size()) {
            throw new IllegalArgumentException();
        } else if (k > 0) {
            Stack<Integer> s = new Stack<Integer>();   // first k elements -> S
            for (int i = 0; i < k; i++) {
                s.push(q.remove());
            }
    
            while (!s.isEmpty()) {                                 // s2q(s, q);
                q.add(s.pop());
            }
    
            for (int i = 0; i < q.size() - k; i++) {   // wrap around rest of elements so
                q.add(q.remove());                        // k reversed ones appear at front
            }
        }
    }


    Queue<Integer> of(int... arr){
        Queue<Integer> ans=new LinkedList<>();
        for(int i:arr){
            ans.offer(i);
        }
        return ans;
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
            Queue<Integer> arg=of(fixture);
            Queue<Integer> expected=of(fixture);
            ReverseFirstK.reverseFirstK(0,arg);
            reverseFirstK(0,expected);
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
            Queue<Integer> arg=of(fixture);
            Queue<Integer> expected=of(fixture);
            ReverseFirstK.reverseFirstK(1,arg);
            reverseFirstK(1,expected);
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
            Queue<Integer> arg=of(fixture);
            Queue<Integer> expected=of(fixture);

            Random r=new Random();
            int n=r.nextInt(fixture.length);
            ReverseFirstK.reverseFirstK(n,arg);
            reverseFirstK(n,expected);
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
            Queue<Integer> arg=of(fixture);
            Queue<Integer> expected=of(fixture);

            ReverseFirstK.reverseFirstK(fixture.length,arg);
            reverseFirstK(fixture.length,expected);
            assertEquals(expected.toString(), arg.toString());
        } 
    }
    

}
