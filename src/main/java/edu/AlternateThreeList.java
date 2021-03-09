package edu;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AlternateThreeList<E>  extends LinkedList<E>{

    public LinkedList<E> alternateThreeLists (LinkedList<E>list1, LinkedList<E>list2, LinkedList<E>list3) {
        Iterator<E> iter1 = list1.iterator();
        Iterator<E> iter2 = list2.iterator();
        Iterator<E> iter3 = list3.iterator();

        LinkedList<E> newList = new LinkedList<>();

        while(iter1.hasNext() || iter2.hasNext() || iter3.hasNext()) {
            if (iter1.hasNext())
                newList.add(iter1.next());
            if (iter2.hasNext())
                newList.add(iter2.next());
            if (iter3.hasNext())
                newList.add(iter3.next());
        }
        return newList;
    }


}
