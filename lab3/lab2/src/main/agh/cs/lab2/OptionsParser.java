package agh.cs.lab2;

import java.util.Arrays;

public class OptionsParser {
    public static MoveDirection[] parse(String[] args){
        MoveDirection[] res = new MoveDirection[args.length];
        int x=0;
        for(String arg:args){
            if(arg.equals("f") || arg.equals("forward"))
                res[x++]=MoveDirection.FORWARD;
            else if(arg.equals("b") || arg.equals("backward"))
                res[x++]=MoveDirection.BACKWARD;
            else if(arg.equals("r") || arg.equals("right"))
                res[x++]=MoveDirection.RIGHT;
            else if(arg.equals("l") || arg.equals("left"))
                res[x++]=MoveDirection.LEFT;
        }
        return Arrays.copyOfRange(res, 0, x);
    }
}