package edu;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

import javax.sound.midi.MetaEventListener;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PairwiseSumTest {
    
    private Main app;
    
    private ByteArrayOutputStream outputStreamCaptor;
    
    @BeforeEach
    public void setUp() {
        app = new Main();
        outputStreamCaptor=new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }


    String getResult(LinkedList<Integer> input) {
        try{
            Method m=app.getClass().getMethod("pairwiseSum",LinkedList.class);
            if(!m.getReturnType().equals(Void.TYPE)){
                return m.invoke(app, input).toString().replaceAll("[^\\d,]", "");
            }else{
                m.invoke(app, input);
                String r= outputStreamCaptor.toString().trim().replaceAll("[^\\d,]", "");
                outputStreamCaptor.reset();
                return r;
            }
        }catch(Exception e){
            return e.getMessage();
        }
    }

    @Test
    public void testSmallLists(){
        try{
            LinkedList<Integer> input=new LinkedList<>();
            String r=getResult(input);
            assertEquals("",r,"Result:"+r);
        }catch(IllegalArgumentException e){
            
        }

    }

    @Test
    public void testRegularCase(){
        LinkedList<Integer> input=new LinkedList<>(List.of(5,3,2,9,3,15,22));
        String r=getResult(input);
        assertEquals("8,5,11,12,18,37",r,"Result:"+r);
    }


    @Test
    public void testRegularCase1(){
        LinkedList<Integer> input=new LinkedList<>(List.of(5,3,3,15,22));
        String r=getResult(input);
        assertEquals("8,6,18,37",r,"Result:"+r);
    }

}
