package agh.cs.lab2;

import java.util.LinkedList;

public class World {
    public static void main(String[] args){
        /*Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

        MapDirection a=MapDirection.NORTH;
        System.out.println(a.toString());
        System.out.println(a.next().toString());
        */

        /*
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        */

        /* Animal animal = new Animal();
        System.out.println(animal);

        MoveDirection[] Dir= OptionsParser.parse(args);

        for(MoveDirection mv: Dir){
            animal.move(mv);
        }
        System.out.println(animal);*/

        try {
            LinkedList<Stone> stones = new LinkedList<Stone>();
            stones.add(new Stone(new Vector2d(-4, -4)));
            stones.add(new Stone(new Vector2d(7, 7)));
            stones.add(new Stone(new Vector2d(3, 6)));
            stones.add(new Stone(new Vector2d(2, 0)));
            MoveDirection[] directions = new OptionsParser().parse(args);

            IWorldMap map = new UnboundedMap(stones);
            //IWorldMap map = new RectangularMap(10, 5);
            map.place(new Animal(map));
            map.place(new Animal(map, new Vector2d(3, 4)));
            //map.place(new Animal(map, new Vector2d(3, 4)));
            map.run(directions);
            System.out.println(map);
        }
        catch (IllegalArgumentException ex){
            System.out.println(ex);
        }

//      LinkedList<Stone> stones = new LinkedList<Stone>();
//      IWorldMap map = new UnboundedMap(stones);
//      System.out.println(map);

    }
}
