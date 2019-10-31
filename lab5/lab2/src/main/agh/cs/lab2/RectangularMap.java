package agh.cs.lab2;

import java.util.ArrayList;
import java.util.LinkedList;

class RectangularMap extends AbstractWorldMap {
    private int width;
    private int height;

    public RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
    }

    public String toString(){
        return new MapVisualizer(this).draw(new Vector2d(0,0), new Vector2d(width, height));
    }

    @Override
    public boolean canMoveTo(Vector2d pos){
        return super.canMoveTo(pos) && pos.precedes(new Vector2d(this.width, this.height)) && pos.follows(new Vector2d(0, 0));
    }

}
