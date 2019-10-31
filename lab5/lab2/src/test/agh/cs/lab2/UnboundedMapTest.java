package agh.cs.lab2;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

public class UnboundedMapTest {
    String[] args = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
    MoveDirection[] directions = new OptionsParser().parse(args);

    @Test
    public void testToString(){
        LinkedList<Stone> stones = new LinkedList<Stone>();
        stones.add(new Stone(new Vector2d(-4, -4)));
        stones.add(new Stone(new Vector2d(7, 7)));
        stones.add(new Stone(new Vector2d(3, 6)));
        stones.add(new Stone(new Vector2d(2, 0)));

        IWorldMap map2 = new UnboundedMap(stones);

        Assert.assertEquals(" y\\x -4-3-2-1 0 1 2 3 4 5 6 7\n" +
                        "  8: -------------------------\n" +
                        "  7: | | | | | | | | | | | |s|\n" +
                        "  6: | | | | | | | |s| | | | |\n" +
                        "  5: | | | | | | | | | | | | |\n" +
                        "  4: | | | | | | | | | | | | |\n" +
                        "  3: | | | | | | | | | | | | |\n" +
                        "  2: | | | | | | | | | | | | |\n" +
                        "  1: | | | | | | | | | | | | |\n" +
                        "  0: | | | | | | |s| | | | | |\n" +
                        " -1: | | | | | | | | | | | | |\n" +
                        " -2: | | | | | | | | | | | | |\n" +
                        " -3: | | | | | | | | | | | | |\n" +
                        " -4: |s| | | | | | | | | | | |\n" +
                        " -5: -------------------------\n",
                map2.toString());
    }

    @Test
    public void testRun(){//tests place, canMoveTo, run, isOccupied and objectAt
        LinkedList<Stone> stones = new LinkedList<Stone>();
        stones.add(new Stone(new Vector2d(-4, -4)));
        stones.add(new Stone(new Vector2d(7, 7)));
        stones.add(new Stone(new Vector2d(3, 6)));
        stones.add(new Stone(new Vector2d(2, 0)));

        IWorldMap map2 = new UnboundedMap(stones);

        map2.place(new Animal(map2));
        map2.place(new Animal(map2, new Vector2d(3 ,4)));
        map2.run(directions);

        Assert.assertEquals(" y\\x -4-3-2-1 0 1 2 3 4 5 6 7\n" +
                        "  8: -------------------------\n" +
                        "  7: | | | | | | | | | | | |s|\n" +
                        "  6: | | | | | | | |s| | | | |\n" +
                        "  5: | | | | | | | |^| | | | |\n" +
                        "  4: | | | | | | | | | | | | |\n" +
                        "  3: | | | | | | | | | | | | |\n" +
                        "  2: | | | | | | | | | | | | |\n" +
                        "  1: | | | | | | |v| | | | | |\n" +
                        "  0: | | | | | | |s| | | | | |\n" +
                        " -1: | | | | | | | | | | | | |\n" +
                        " -2: | | | | | | | | | | | | |\n" +
                        " -3: | | | | | | | | | | | | |\n" +
                        " -4: |s| | | | | | | | | | | |\n" +
                        " -5: -------------------------\n",
                map2.toString());

    }


    @Test
    public void testCanMoveTo(){
        LinkedList<Stone> stones = new LinkedList<Stone>();
        stones.add(new Stone(new Vector2d(-4, -4)));
        stones.add(new Stone(new Vector2d(7, 7)));
        stones.add(new Stone(new Vector2d(3, 6)));
        stones.add(new Stone(new Vector2d(2, 0)));

        IWorldMap map = new UnboundedMap(stones);
        map.place(new Animal(map, new Vector2d(6, 1)));

        Assert.assertTrue(map.canMoveTo(new Vector2d(0, 0)));
        Assert.assertTrue(map.canMoveTo(new Vector2d(7, 4)));
        Assert.assertTrue(map.canMoveTo(new Vector2d(2, 2)));
        Assert.assertFalse(map.canMoveTo(new Vector2d(-4, -4)));
        Assert.assertFalse(map.canMoveTo(new Vector2d(7, 7)));
        Assert.assertFalse(map.canMoveTo(new Vector2d(3, 6)));
        Assert.assertFalse(map.canMoveTo(new Vector2d(2, 0)));
    }

    @Test
    public void testIsOccupied(){
        LinkedList<Stone> stones = new LinkedList<Stone>();
        stones.add(new Stone(new Vector2d(-4, -4)));
        stones.add(new Stone(new Vector2d(7, 7)));
        stones.add(new Stone(new Vector2d(3, 6)));
        stones.add(new Stone(new Vector2d(2, 0)));

        IWorldMap map = new UnboundedMap(stones);
        map.place(new Animal(map, new Vector2d(6, 1)));

        Assert.assertFalse(map.isOccupied(new Vector2d(0, 0)));
        Assert.assertFalse(map.isOccupied(new Vector2d(7, 4)));
        Assert.assertFalse(map.isOccupied(new Vector2d(3, 3)));
        Assert.assertTrue(map.isOccupied(new Vector2d(6, 1)));
        Assert.assertTrue(map.isOccupied(new Vector2d(-4, -4)));
        Assert.assertTrue(map.isOccupied(new Vector2d(7, 7)));
        Assert.assertTrue(map.isOccupied(new Vector2d(3, 6)));
        Assert.assertTrue(map.isOccupied(new Vector2d(2, 0)));
    }

    @Test
    public void testObjectAt(){
        LinkedList<Stone> stones = new LinkedList<Stone>();
        stones.add(new Stone(new Vector2d(-4, -4)));
        stones.add(new Stone(new Vector2d(7, 7)));
        stones.add(new Stone(new Vector2d(3, 6)));
        stones.add(new Stone(new Vector2d(2, 0)));

        IWorldMap map = new UnboundedMap(stones);
        Animal zwierz = new Animal(map);
        Animal futrz = new Animal(map, new Vector2d(6 ,3));
        map.place(zwierz);
        map.place(futrz);

        Assert.assertNull(map.objectAt(new Vector2d(0,0)));
        Assert.assertNull(map.objectAt(new Vector2d(7,4)));
        Assert.assertEquals(map.objectAt(new Vector2d(6, 3)), futrz);
        Assert.assertEquals(map.objectAt(new Vector2d(2, 2)), zwierz);
        Assert.assertEquals(map.objectAt(new Vector2d(-4, -4)), stones.get(0));
        Assert.assertEquals(map.objectAt(new Vector2d(7, 7)), stones.get(1));
        Assert.assertEquals(map.objectAt(new Vector2d(3, 6)), stones.get(2));
        Assert.assertEquals(map.objectAt(new Vector2d(2, 0)), stones.get(3));

    }
}
