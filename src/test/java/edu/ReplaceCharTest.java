package edu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class ReplaceCharTest {
    
    private Main app;

    @BeforeEach
    public void setApp() {
        this.app = new Main();
    }

    @Test
    public void testReplaceFirstChars(){
        assertEquals("Settle", app.replaceChar("Kettle", 0, 'S'));
    }

    @Test
    public void testReplaceLastChar(){
        assertEquals("TimeL", app.replaceChar("Times", 4, 'L'));
    }

    @Test
    public void testReplaceChar(){
        assertEquals("Loyola", app.replaceChar("Lorola", 2, 'y'));
    }

    @Test
    public void testReplaceCharInbound(){
        assertThrows(Exception.class, ()->{app.replaceChar("Lorola", 10, 'y');});
    }
}
