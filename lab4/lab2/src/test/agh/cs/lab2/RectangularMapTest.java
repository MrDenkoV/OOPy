package agh.cs.lab2;

import org.junit.Assert;
import org.junit.Test;

public class RectangularMapTest {
    String[] args = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
    MoveDirection[] directions = new OptionsParser().parse(args);
    IWorldMap map1 = new RectangularMap(10, 5);
    IWorldMap map2 = new RectangularMap(10, 5);

    // rmmbr \r\n WINDOWS

    @Test
    public void testToString(){
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

        map2.place(new Animal(map2));
        map2.place(new Animal(map2, new Vector2d(3 ,4)));
        map2.run(directions);

        Assert.assertEquals(" y\\x  0 1 2 3 4 5 6 7 8 910\n" +
                        "  6: -----------------------\n" +
                        "  5: | | | |N| | | | | | | |\n" +
                        "  4: | | | | | | | | | | | |\n" +
                        "  3: | | | | | | | | | | | |\n" +
                        "  2: | | | | | | | | | | | |\n" +
                        "  1: | | | | | | | | | | | |\n" +
                        "  0: | | |S| | | | | | | | |\n" +
                        " -1: -----------------------\n",
                map2.toString());

    }


}
