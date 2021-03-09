package edu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TwoStringsEqualsTest {
    
    Main app;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp(){
        app=new Main();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    private String checkResult(ArrayList<String> arr){
        try{
           Method method= Main.class.getMethod("twoStringEquals", ArrayList.class);
           if(method.getReturnType().equals(Void.TYPE)){
                method.invoke(app, arr);
                String r= outputStreamCaptor.toString().trim();
                outputStreamCaptor.reset();
                return r;
           }else if(method.getReturnType().equals(String.class)){
               return (String)method.invoke(app, arr);
           
           }else{
               throw new Exception("error,error");
           }
        }catch(NoSuchMethodException nsme){
            return "Uuganbold!. You should check your code"+nsme.getMessage();
        }catch(Exception ite){
            return "Something wrong. Check it"+ite.getMessage();
        }
         
    }

    @Test
    public void testRegularCase(){
        String r=checkResult(
            new ArrayList<String>(List.of("cat", "dog", "dot", "ca", "t", "do","t","g"))
        ).replaceAll("['\"]", "");
        String[] rr=r.split("\\n");
        String[] ee=new String[]{"Yes, ca at location 3 and t at location 4 together form cat at location 0",
        "Yes, do at location 5 and g at location 7 together form dog at location 1",
        "Yes, do at location 5 and t at location 4 together form dot at location 2"};
        boolean found=false;

        for(String r1:rr){
            for(String e1:ee){
                if(r1.startsWith(e1)){
                    found=true;
                    break;
                }
            }
        }
        assertTrue(found,r);
    }

    @Test
    public void testNoStringCase(){
        String r=checkResult(
            new ArrayList<String>(List.of("cat", "dog", "dot"))
        );
        assertTrue(
                r.toLowerCase().contains("no"),
                r
        );
    }


}
