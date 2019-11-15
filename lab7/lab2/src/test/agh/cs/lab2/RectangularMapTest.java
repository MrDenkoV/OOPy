package agh.cs.lab2;

import org.junit.Assert;
import org.junit.Test;

public class RectangularMapTest {
    String[] args = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
    MoveDirection[] directions = new OptionsParser().parse(args);

    // rmmbr \r\n WINDOWS

    @Test
    public void testToString(){
        IWorldMap map1 = new RectangularMap(10, 5);
        Assert.assertEquals(" y\\x  0 1 2 3 4 5 6 7 8 910\n" +
                        "  6: -----------------------\n" +
                        "  5: | | | | | | | | | | | |\n" +
                        "  4: | | | | | | | | | | | |\n" +
                        "  3: | | | | | | | | | | | |\n" +
                        "  2: | | | | | | | | | | | |\n" +
                        "  1: | | | | | | | | | | | |\n" +
                        "  0: | | | | | | | | | | | |\n" +
                        " -1: -----------------------\n",
                map1.toString() );

    }

    @Test
    public void testRun(){//tests place, canMoveTo, run, isOccupied and objectAt
        IWorldMap map2 = new RectangularMap(10, 5);

        map2.place(new Animal(map2));
        map2.place(new Animal(map2, new Vector2d(3 ,4)));
        map2.run(directions);

        Assert.assertEquals(" y\\x  0 1 2 3 4 5 6 7 8 910\n" +
                        "  6: -----------------------\n" +
                        "  5: | | | |^| | | | | | | |\n" +
                        "  4: | | | | | | | | | | | |\n" +
                        "  3: | | | | | | | | | | | |\n" +
                        "  2: | | | | | | | | | | | |\n" +
                        "  1: | | | | | | | | | | | |\n" +
                        "  0: | | |v| | | | | | | | |\n" +
                        " -1: -----------------------\n",
                map2.toString());

    }

    @Test
    public void testCanMoveTo(){
        IWorldMap map = new RectangularMap(7, 4);
        map.place(new Animal(map, new Vector2d(6, 1)));

        Assert.assertTrue(map.canMoveTo(new Vector2d(0, 0)));
        Assert.assertTrue(map.canMoveTo(new Vector2d(7, 4)));
        Assert.assertTrue(map.canMoveTo(new Vector2d(2, 2)));
        Assert.assertFalse(map.canMoveTo(new Vector2d(8, 3)));
        Assert.assertFalse(map.canMoveTo(new Vector2d(7, 5)));
        Assert.assertFalse(map.canMoveTo(new Vector2d(-1, 0)));
        Assert.assertFalse(map.canMoveTo(new Vector2d(0, -1)));
        Assert.assertFalse(map.canMoveTo(new Vector2d(6, 1)));
    }

    @Test
    public void testIsOccupied(){
        IWorldMap map = new RectangularMap(7, 4);
        map.place(new Animal(map, new Vector2d(6, 1)));

        Assert.assertFalse(map.isOccupied(new Vector2d(0, 0)));
        Assert.assertFalse(map.isOccupied(new Vector2d(7, 4)));
        Assert.assertFalse(map.isOccupied(new Vector2d(3, 3)));
        Assert.assertTrue(map.isOccupied(new Vector2d(6, 1)));
    }

    @Test
    public void testObjectAt(){
        IWorldMap map = new RectangularMap(7, 4);
        Animal zwierz = new Animal(map);
        Animal futrz = new Animal(map, new Vector2d(6 ,3));
        map.place(zwierz);
        map.place(futrz);

        Assert.assertNull(map.objectAt(new Vector2d(0,0)));
        Assert.assertNull(map.objectAt(new Vector2d(7,4)));
        Assert.assertEquals(map.objectAt(new Vector2d(6, 3)), futrz);
        Assert.assertEquals(map.objectAt(new Vector2d(2, 2)), zwierz);

    }

}
