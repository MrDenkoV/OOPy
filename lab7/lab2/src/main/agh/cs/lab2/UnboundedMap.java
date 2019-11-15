package agh.cs.lab2;

import java.util.LinkedList;
import java.util.Map;
import java.util.Vector;

public class UnboundedMap extends AbstractWorldMap{

    protected Vector2d lowerLeft;
    protected Vector2d upperRight;

    private int inf=Integer.MAX_VALUE;
    private MapBoundary boundary = new MapBoundary();


    public UnboundedMap(LinkedList<Stone> stones){
        lowerLeft = new Vector2d(inf, inf);
        upperRight = new Vector2d(-inf, -inf);

        for(Stone stone: stones){
            elements.put(stone.getPosition(), stone);
            System.out.println(stone.getPosition());
            System.out.println(upperRight);
            upperRight = upperRight.upperRight(stone.getPosition());
            lowerLeft = lowerLeft.lowerLeft(stone.getPosition());
            boundary.add(stone);
        }
    }


    public Vector2d getLowerLeft(){
        return boundary.lowLeft();
    }

    public Vector2d getUpperRight(){
        return boundary.uppRight();
    }

}
