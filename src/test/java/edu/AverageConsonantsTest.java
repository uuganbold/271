package edu;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AverageConsonantsTest {
    

    private Main app;

    @BeforeEach
    public void setUp(){
        app=new Main();
    }


    @Test
    public void testRegularCase(){
        ArrayList<String> arr=new ArrayList<>(List.of("ewsd","wrujo","wwer"));
                                                      // 3, 3,3
        assertEquals("3.00", String.format("%.2f", app.averageConsonants(arr)));
                                                      
    }

    @Test
    public void testRegular1Case(){
        ArrayList<String> arr=new ArrayList<>(List.of("ed","wrujo","wwer"));
                                                      // 1, 3,3
        assertEquals("2.33", String.format("%.2f", app.averageConsonants(arr)));
                                                      
    }
}
