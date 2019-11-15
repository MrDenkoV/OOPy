package agh.cs.lab2;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.logging.Level;

public class AnimalIntegrationTest {

    @Test
    public void testPosition(){
        RectangularMap map = new RectangularMap(5, 6);
        Animal zwierz = new Animal(map);
        map.place(zwierz);

        String[] args = {"f", "forward", "r", "b", "right", "backward", "f", "f", "f", "l", "f", "left", "b"};
        MoveDirection[] dir = new OptionsParser().parse(args);
        Assert.assertEquals(zwierz.getPosition(), new Vector2d(2, 2));

        map.run(dir);

        Assert.assertEquals(zwierz.getPosition(), new Vector2d(2, 1));
        Assert.assertNotEquals(zwierz.getPosition(), new Vector2d(1, 2));
    }

    @Test
    public void testLimits(){
        RectangularMap map = new RectangularMap(4, 4);
        Animal zwierz = new Animal(map);
        map.place(zwierz);

        String[] args ={"f", "f", "f", "f", "f", "f", "r"};

        MoveDirection[] dir = new OptionsParser().parse(args);

        map.run(dir);

        Assert.assertEquals(zwierz.getPosition(), new Vector2d(2, 4));

        map.run(dir);

        Assert.assertEquals(zwierz.getPosition(), new Vector2d(4, 4));

        map.run(dir);

        Assert.assertEquals(zwierz.getPosition(), new Vector2d(4, 0));

        map.run(dir);

        Assert.assertEquals(zwierz.getPosition(), new Vector2d(0, 0));
    }

    @Test
    public void testParser(){
        String[] args ={"f", "forward", "l", "left", "right", "r", "b", "backward"};//, "nic"};
        MoveDirection[] dir = {MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.LEFT, MoveDirection.RIGHT, MoveDirection.RIGHT, MoveDirection.BACKWARD, MoveDirection.BACKWARD};
        MoveDirection[] par = new OptionsParser().parse(args);
        Assert.assertArrayEquals(par, dir);
    }
}
