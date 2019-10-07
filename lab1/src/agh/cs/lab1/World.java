package agh.cs.lab1;

import java.util.Arrays;

public class World {
    public static void main(String[] args){
        System.out.println("Start");
        run(change(args));
        System.out.println("End");
    }

    private static void run(Direction[] args){
        /*System.out.println("Forward we go");
        int x=0;
        for(String argument : args){
            x++;
            System.out.print(argument);
            if(x!=args.length) System.out.print(", ");
        }
        System.out.print("\n");*/
        for(Direction argument:args){
            switch (argument){
                case FORWARD:
                    System.out.println("Forward");
                    break;
                case RIGHT:
                    System.out.println("Right");
                    break;
                case BACKWARD:
                    System.out.println("Backward");
                    break;
                case LEFT:
                    System.out.println("Left");
                    break;
            }
        }
    }

    private static Direction[] change(String[] args){
        Direction[] tmp=new Direction[args.length];
        int x=0;
        for(String argument:args){
            switch (argument){
                case "f":
                    tmp[x++]=Direction.FORWARD;
                    break;
                case "r":
                    tmp[x++]=Direction.RIGHT;
                    break;
                case "b":
                    tmp[x++]=Direction.BACKWARD;
                    break;
                case "l":
                    tmp[x++]=Direction.LEFT;
                    break;
            }
        }
        return Arrays.copyOfRange(tmp, 0, x);
    }

}
