package agh.cs.lab2;

import java.util.LinkedList;
import java.util.Map;
import java.util.Vector;

public class UnboundedMap extends AbstractWorldMap{
    private int inf=Integer.MAX_VALUE;

    public UnboundedMap(LinkedList<Stone> stones){
        lowerLeft = new Vector2d(inf, inf);
        upperRight = new Vector2d(-inf, -inf);

        for(Stone stone: stones){
            elements.put(stone.getPosition(), stone);
            System.out.println(stone.getPosition());
            System.out.println(upperRight);
            upperRight = upperRight.upperRight(stone.getPosition());
            lowerLeft = lowerLeft.lowerLeft(stone.getPosition());
        }
    }
}
