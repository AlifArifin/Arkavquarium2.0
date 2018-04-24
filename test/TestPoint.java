import org.junit.*;
import org.junit.Assert.*;

class TestPoint {
    @Test
    public void distanceToTest(){
        Point p1 = new(0, 0);
        Point p2 = new(3, 4);
        assertEquals(5, p1.distanceTo(p2), 0);
    }
}
