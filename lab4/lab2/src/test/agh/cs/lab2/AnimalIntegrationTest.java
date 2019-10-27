package agh.cs.lab2;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.logging.Level;

public class AnimalIntegrationTest {

    /*public void run(Animal animal, MoveDirection[] directions){
        for(MoveDirection direction: directions){
            animal.move(direction);
        }
    }

    @Test
    public void testOrientation(){
        Animal animal = new Animal();
        Assert.assertEquals(animal.toString(), "Pos:(2,2) Dir:Północ");
        animal.move(MoveDirection.RIGHT);
        Assert.assertEquals(animal.toString(), "Pos:(2,2) Dir:Wschód");
        animal.move(MoveDirection.RIGHT);
        Assert.assertEquals(animal.toString(), "Pos:(2,2) Dir:Południe");
        animal.move(MoveDirection.RIGHT);
        Assert.assertEquals(animal.toString(), "Pos:(2,2) Dir:Zachód");
        animal.move(MoveDirection.RIGHT);
        Assert.assertEquals(animal.toString(), "Pos:(2,2) Dir:Północ");
        animal.move(MoveDirection.LEFT);
        Assert.assertEquals(animal.toString(), "Pos:(2,2) Dir:Zachód");
        animal.move(MoveDirection.LEFT);
        Assert.assertEquals(animal.toString(), "Pos:(2,2) Dir:Południe");
        animal.move(MoveDirection.LEFT);
        Assert.assertEquals(animal.toString(), "Pos:(2,2) Dir:Wschód");
        animal.move(MoveDirection.LEFT);
        Assert.assertEquals(animal.toString(), "Pos:(2,2) Dir:Północ");
        Assert.assertNotEquals(animal.toString(), "Pos:(2,2) Dir:Południe");
    }

    @Test
    public void testLimits(){
        Animal animal = new Animal();
        for(int i=0; i<10; i++){
            animal.move(MoveDirection.FORWARD);
        }
        Assert.assertEquals(animal.toString(), "Pos:(2,4) Dir:Północ");
        for(int i=0; i<10; i++){
            animal.move(MoveDirection.BACKWARD);
        }
        Assert.assertEquals(animal.toString(), "Pos:(2,0) Dir:Północ");
        animal.move(MoveDirection.RIGHT);
        for(int i=0; i<10; i++){
            animal.move(MoveDirection.FORWARD);
        }
        Assert.assertEquals(animal.toString(), "Pos:(4,0) Dir:Wschód");
        for(int i=0; i<10; i++){
            animal.move(MoveDirection.BACKWARD);
        }
        Assert.assertEquals(animal.toString(), "Pos:(0,0) Dir:Wschód");
        Assert.assertNotEquals(animal.toString(), "Pos:(-5,0) Dir:Zachód");
    }

    @Test
    public void testPositions(){
        Animal animal = new Animal();
        MoveDirection[] Directions={MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.BACKWARD};
        run(animal, Directions);
        Assert.assertEquals(animal.toString(), "Pos:(3,4) Dir:Zachód");
    }

    @Test
    public void testInterpretation(){
        Animal animal = new Animal();
        String[] args ={"f", "forward", "nic", "l", "b"};
        MoveDirection[] dir = OptionsParser.parse(args);
        run(animal, dir);
        Assert.assertEquals(animal.toString(), "Pos:(3,4) Dir:Zachód");
    }*/
}
