package agh.cs.lab2;

import java.util.LinkedList;
import java.util.Map;
import java.util.Vector;

public class UnboundedMap extends AbstractWorldMap{

    private MapBoundary boundary = new MapBoundary();


    public UnboundedMap(LinkedList<Stone> stones){

        for(Stone stone: stones){
            elements.put(stone.getPosition(), stone);
            System.out.println(stone.getPosition());
            boundary.add(stone);
        }
    }

    public boolean place(Animal animal){
        boundary.add(animal);
        super.place(animal);
        return true;
    }

    public Vector2d getLowerLeft(){
        return boundary.lowLeft();
    }

    public Vector2d getUpperRight(){
        return boundary.uppRight();
    }

}
