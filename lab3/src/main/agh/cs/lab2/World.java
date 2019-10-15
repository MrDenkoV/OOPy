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

        /*Car car = new Car();
        System.out.println(car);
        car.move(MoveDirection.RIGHT);
        car.move(MoveDirection.FORWARD);
        car.move(MoveDirection.FORWARD);
        car.move(MoveDirection.FORWARD);
        System.out.println(car);
        */
        Car car = new Car();
        System.out.println(car);
        MoveDirection[] Directions = OptionsParser.parse(args);
        for(MoveDirection Direction:Directions)
            car.move(Direction);
        System.out.println(car);
    }
}
