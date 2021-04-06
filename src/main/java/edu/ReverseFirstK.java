package edu;
import java.util.*;
public class ReverseFirstK {

    public static void reverseFirstK(int k, Queue<Integer> q) {
        if (k <= 0) {
            System.out.println(q);
        } else {
            try {
                Stack<Integer> st = new Stack<>();
                int qSize = q.size();
                for (int i = 0; i < k; i++) {
                    st.push(q.remove());
                }
                while (!st.isEmpty()) {
                    q.add(st.pop());
                }
                for (int i = 0; i < (qSize - k); i++) {
                    q.add(q.remove());
                }
                System.out.println(q);
            }
            catch(Exception E){
                System.out.println("Queue must contain at least k elements.");
            }
        }
    }
}
