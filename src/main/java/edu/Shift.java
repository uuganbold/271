package edu;
import java.util.*;

public class Shift {
    
    public static void shift(Stack<Integer> st, int n){
        Queue<Integer> q = new LinkedList<>();
        int size = st.size();
        //moves everything from st to q
        for(int i = 0; i < (size); i++){
            q.add(st.pop());
        }
        //moves the first size-n numbers from q to st
        for(int i = 0; i < (size - n); i++){
            st.push(q.remove());
        }
        //moves all numbers from st back to q
        while(!st.isEmpty()){
            q.add(st.pop());
        }
        //takes the first n numbers from q and makes them the last n numbers in q
        for(int i = 0; i < n; i++){
            q.add(q.remove());
        }
        int qSize = q.size();
        //moves all values from q to st in the correct order
        for(int i = 0; i < qSize; i++){
            st.push(q.remove());
        }
        System.out.println(st);
    }
}
