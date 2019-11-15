package agh.cs.lab2;

import java.util.ArrayList;
import java.util.LinkedList;

class RectangularMap extends AbstractWorldMap {

    protected Vector2d lowerLeft;
    protected Vector2d upperRight;

    public RectangularMap(int width, int height) {
        lowerLeft = new Vector2d(0, 0);
        upperRight = new Vector2d(width, height);
    }


    public Vector2d getLowerLeft(){
        return lowerLeft;
    }

    public Vector2d getUpperRight(){
        return upperRight;
    }

    @Override
    public boolean canMoveTo(Vector2d pos){
        return super.canMoveTo(pos) && pos.precedes(upperRight) && pos.follows(lowerLeft);
    }

}
