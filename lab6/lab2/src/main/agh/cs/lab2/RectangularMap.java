package agh.cs.lab2;

import java.util.ArrayList;
import java.util.LinkedList;

class RectangularMap extends AbstractWorldMap {

    public RectangularMap(int width, int height){
        lowerLeft = new Vector2d(0, 0);
        upperRight = new Vector2d(width, height);
    }

    @Override
    public boolean canMoveTo(Vector2d pos){
        return super.canMoveTo(pos) && pos.precedes(upperRight) && pos.follows(lowerLeft);
    }

}
