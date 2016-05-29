package jc.sas.points;


import org.testng.Assert;
import org.testng.annotations.Test;

public class PointsTest {


    @Test
    public void testPoint() {
        Point p1 = new Point(3, 10);
        Point p2 = new Point(4, 20);
        Assert.assertEquals(p1.distance(p2),10.04987562112089);

    }

}
