package edu;
import java.util.*;
public class IsSorted {
    public static boolean isSorted(Stack<Integer> st){
        Stack<Integer> st2 = new Stack<>();
        boolean isSorted = true;
        int current = st.pop();
        if(st.size() < 2){
            return true;
        }
        st2.push(current);
        while(!st.isEmpty()){
            int n = st.pop();
            if(n < current){
                isSorted = false;
            }
            current = n;
            st2.push(current);
        }
        while(!st2.isEmpty()){
            st.push(st2.pop());
        }
        return isSorted;
    }
}
