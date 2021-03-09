package edu;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.*;
public class AlternateThreeListsTest {
    

    @Test
    public void testIntegerCase(){
        LinkedList<Integer> list1=new LinkedList<>(List.of(5,10,15));
        LinkedList<Integer> list2 = new LinkedList<>(List.of(20,25,35,45));        
        LinkedList<Integer> list3 = new LinkedList<>(List.of(1,2,3,4)); 

        AlternateThreeList<Integer> app=new AlternateThreeList<Integer>();
        List<Integer> ans=app.alternateThreeLists(list1, list2, list3);
        assertTrue(Arrays.deepEquals(new Integer[]{5,20,1,10,25,2,15,35,3,45,4}, ans.toArray()));
    }

    @Test
    public void testIntegerAnotherCase(){
        LinkedList<Integer> list1=new LinkedList<>(List.of(5,10,15));
        LinkedList<Integer> list2 = new LinkedList<>(List.of(20));        
        LinkedList<Integer> list3 = new LinkedList<>(List.of(1,2,3,4)); 

        AlternateThreeList<Integer> app=new AlternateThreeList<Integer>();
        List<Integer> ans=app.alternateThreeLists(list1, list2, list3);
        assertTrue(Arrays.deepEquals(new Integer[]{5,20,1,10,2,15,3,4}, ans.toArray()));
    }
}
