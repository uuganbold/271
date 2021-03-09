package edu;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DifferByKTest {
 
    Main<Integer> app;
       
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp(){
        app=new Main<>();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    private String normalizeResult(){
       String result= outputStreamCaptor.toString().trim().replaceAll("[^\\d\\,\\(\\)]", "").replace(")(", "),(");
       outputStreamCaptor.reset();
       return Arrays.stream(result.split("\\),\\(")).map(s->{return s.replaceAll("[\\)\\(]","");}).map(s->{
           String[] ss=s.split(",");
           int[] r=new int[]{Integer.parseInt(ss[0]),Integer.parseInt(ss[1])};
           if(r[0]>r[1]){ int temp=r[0]; r[0]=r[1]; r[1]=temp;}
           return r;
       }).sorted((a,b)->{
           if(a[0]==b[0]) return a[1]-b[1];
           return a[0]-b[0];
       }).map(a->{
           return String.format("(%d,%d)", a[0],a[1]);
       }).collect(Collectors.joining(","));
    }

    @Test
    public void testRegularCase(){
        int[] arr={1,4,9,12, 6, 15, 5, 13,17};
        app.differByK(arr, 3);
        assertEquals("(1,4),(6,9),(9,12),(12,15)", normalizeResult() );
    }

    @Test
    public void testRegularTCase(){
        int[] arr={1,4,9,12, 6, 15, 5, 13,17};
        app.differByK(arr, 4);
        assertEquals("(1,5),(5,9),(9,13),(13,17)", normalizeResult());
    }
}
