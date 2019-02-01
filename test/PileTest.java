import org.junit.Test;

import static org.junit.Assert.*;

public class PileTest {

    @Test
    public void push() {
        Stack<Integer> testPile = new Pile<>();
        testPile.push(2 );
        testPile.push(2 );
        assertEquals(2, testPile.size());
    }

    @Test
    public void pop() {
        Stack<Integer> testPile = new Pile<>();
        testPile.push(2 );
        testPile.pop();
        assertEquals(0, testPile.size());
    }

    @Test
    public void size() {
    }
}