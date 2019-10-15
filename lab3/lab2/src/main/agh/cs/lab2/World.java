package agh.cs.lab2;

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
        Animal animal = new Animal();
        System.out.println(animal);

        MoveDirection[] Dir= OptionsParser.parse(args);

        for(MoveDirection mv: Dir){
            animal.move(mv);
        }
        System.out.println(animal);
    }
}
