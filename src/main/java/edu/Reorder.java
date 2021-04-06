package edu;
import java.util.*;
public class Reorder {

    public static void reorder(Queue<Integer> q){

        //11
        Stack<Integer> st = new Stack<>();
        //stores inital size of q before any changes occur
        int qSize = q.size();
        int count = 0;
        //for each element in q if element is negative move it to auxilary storage, if it is nonnegatgive reposition it to the end of the q and increment count
        for(int i = 0; i < qSize; i++){
            if(q.element() < 0){
                st.push(q.remove());
            }else{
                q.add(q.remove());
                count++;
            }
        }
        //while auxilary storage is not empty move element to q
        while(!st.empty()){
            q.add(st.pop());
        }
        //for each nonnegative element counted, reposition placement in q
        for(int i = 0; i < count; i++){
            q.add(q.remove());
        }
        System.out.println(q);
    }
}
