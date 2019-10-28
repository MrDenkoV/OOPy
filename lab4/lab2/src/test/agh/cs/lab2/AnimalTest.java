package agh.cs.lab2;

import org.junit.Assert;
import org.junit.Test;

public class AnimalTest {
    @Test
    public void testAnimal(){
        IWorldMap map = new RectangularMap(7, 9);
        Assert.assertEquals(new Animal(map).getPosition(), new Vector2d(2,2));
        Assert.assertEquals(new Animal(map, new Vector2d(3, 8)).getPosition(), new Vector2d(3,8));
    }

    @Test
    public  void testToString(){
        IWorldMap map = new RectangularMap(3, 3);
        Animal zwierz = new Animal(map);
        Assert.assertEquals(zwierz.toString(), "N");
        zwierz.move(MoveDirection.LEFT);
        Assert.assertEquals(zwierz.toString(), "W");
        zwierz.move(MoveDirection.LEFT);
        Assert.assertEquals(zwierz.toString(), "S");
        zwierz.move(MoveDirection.LEFT);
        Assert.assertEquals(zwierz.toString(), "E");
    }
}
