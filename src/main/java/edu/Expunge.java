package edu;
import java.util.*;

public class Expunge {
    

    public static void expunge(Stack<Integer> st){
        Stack<Integer> temp = new Stack<>();
        //prints original stack if stack size is less than or equal to 1
        if(st.size() <=1){
            System.out.println(st);
        }else{
            temp.add(st.pop());
            while(!st.isEmpty()){
                int x = st.pop();
                if(x >= temp.peek()){
                    temp.add(x);
                }
            }
            while(!temp.isEmpty()){
                st.push(temp.pop());
            }
            System.out.println(st);
        }
    }
}
