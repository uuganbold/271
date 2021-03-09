package edu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GraduateStudentTest {
    

    @Test
    public void testInheritence(){
        assertTrue(Student.class.isAssignableFrom(GraduateStudent.class));
    }

    @Test
    public void testAccessors() throws Exception{
        GraduateStudent.class.getMethod("getMajor");
       GraduateStudent.class.getMethod("getDegreeName");
       GraduateStudent.class.getMethod("setDegreeName",String.class);
       
       GraduateStudent.class.getMethod("setMajor",String.class);
    }

    @Test
    public void testConstructor() throws Exception{
        Constructor<GraduateStudent> constructor=GraduateStudent.class.getConstructor(String.class, Integer.TYPE, String.class, String.class);
        GraduateStudent std=constructor.newInstance("UB",30,"CS","MS");
        assertEquals("MS",GraduateStudent.class.getMethod("getDegreeName").invoke(std));
        assertEquals("CS",GraduateStudent.class.getMethod("getMajor").invoke(std));
    }

    @Test
    @DisplayName("Equals of Student")
    public void testEqualsStudent() throws Exception{
        Constructor<Student> constructor=Student.class.getConstructor(String.class, Integer.TYPE);
        Student std=constructor.newInstance(new String("UB"),30);
        Student std1=constructor.newInstance(new String("UB"),30);
        assertTrue(std.equals(std1));
        Object std2=constructor.newInstance(new String("UB"),31);
        assertFalse(std.equals(std2));
    }

    @Test
    @DisplayName("Equals of GradStudent")
    public void testEqualsGradStudent() throws Exception{
        Constructor<GraduateStudent> constructor=GraduateStudent.class.getConstructor(String.class, Integer.TYPE, String.class, String.class);
        GraduateStudent std=constructor.newInstance(new String("UB"),30,new String("CS"),new String("MS"));
        GraduateStudent std1=constructor.newInstance(new String("UB"),30,new String("CS"),new String("MS"));
        assertTrue(std.equals(std1));
        Object std2=constructor.newInstance(new String("UB"),30,new String("CM"),new String("MS"));
        assertFalse(std.equals(std2));
    }

    @Test
    @DisplayName("Compareable of Student")
    public void testCompareable() throws Exception{
        assertTrue(Comparable.class.isAssignableFrom(Student.class));
        Constructor<Student> constructor=Student.class.getConstructor(String.class, Integer.TYPE);
        Student std1=constructor.newInstance(new String("UB"),30);
        Student std2=constructor.newInstance(new String("OB"),45);
        Method compareTo=Student.class.getMethod("compareTo", Student.class);
        assertTrue(((int)compareTo.invoke(std1,std2))>0);
        assertTrue(((int)compareTo.invoke(std2,std1))<0);
        Student std3=constructor.newInstance(new String("UB"),35);
        assertTrue(((int)compareTo.invoke(std1,std3))<0);
        assertTrue(((int)compareTo.invoke(std3,std1))>0);
        Student std4=constructor.newInstance(new String("UB"),30);
        assertTrue(((int)compareTo.invoke(std1,std4))==0);
    }
}
