package edu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.*;

public class Main<E> {
    public static String replaceChar (String p, int k, char c) {
        try{
            return p.replace(p.charAt(k), c);
        } catch (Exception e){
            return "k is bigger than index of String";
        }
    }

  //\#3 DONE
  public void pairwiseSum(LinkedList<Integer> arr) {
    Iterator<Integer> iter = arr.iterator();
    int num, prev = 0, next;
    String list = "";
    if(arr.size() < 2) {
        System.out.println("List is too small.");
    } else {
        while(iter.hasNext()) {
            next = iter.next();
            if(prev == 0)
                prev = next;
            else{
                num = next + prev;
                prev = next;
                if(!iter.hasNext())
                    list = list + Integer.toString(num);
                else
                    list = list + Integer.toString(num)+ ", ";
            }
        }
    }
    System.out.println(list);
}
  //\#4 DONE

  public static void twoStringEquals(ArrayList<String> arr) {
    String temp;
    int count1 = 0;
    int count2 = 0;
    for (String i : arr) {
        count1++;
        for (String j : arr) {
            count2++;
            temp = i + j;
            if (arr.contains(temp)) {
                System.out.println("Yes, " + i + " at location " +
                        count1 + " and " + j + " at location " +
                        count2 + " together form " +
                        temp + " at location " + arr.indexOf(temp));
            }
            if(count2 == arr.size())
                count2=0;
        }
    }
}

  //\#6 DONE
  public static void differByK (int [] arr, int k) {
    for(int i = 0; i < arr.length; i++){
        for(int j = 0; j < arr.length; j++){
            if(arr[i] - arr[j] == k){
                System.out.println("(" + arr[i] + "," + arr[j] +")");
            }
        }
    }
}

  //\#7 DONE

  public static double averageConsonants(ArrayList<String> arr) {
    double count = 0.0;
    for(String temp: arr){
        for(int i = 0; i < temp.length(); i++){
            if(!(temp.charAt(i) == 'a')&& !(temp.charAt(i) == 'e')
                    && !(temp.charAt(i) == 'i')&& !(temp.charAt(i) == 'o')&& !(temp.charAt(i) == 'u')){
                count++;
            }
        }
    }
    return count/arr.size();
}


}
