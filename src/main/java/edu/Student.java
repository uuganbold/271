package edu;
import java.lang.*;

import java.lang.String;


//\#2 DONE
public class Student implements Comparable<Student>{
    protected String name;
    protected int age;
    public Student (String name, int age){
        this.name= name;
        this.age=age;
    }

    public void setAge(int age) {
        this.age=age;
    }

    public boolean equals(Student s1){
        if(name == s1.name && age == s1.age)
            return true;
        else
            return false;

    }


    public int compareTo(Student other) {
        if(name == other.name){
            if(age < other.age)
                return -5;
            else if(age > other.age)
                return 5;
            else
                return 0;
        } else
            return name.compareToIgnoreCase(other.name);
    }

}