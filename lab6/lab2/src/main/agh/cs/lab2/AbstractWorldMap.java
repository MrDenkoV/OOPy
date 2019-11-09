package agh.cs.lab2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap{

    protected Vector2d lowerLeft;
    protected Vector2d upperRight;

    protected LinkedList<Animal> animals = new LinkedList<Animal>();
    protected Map<Vector2d, IMapElement> elements = new HashMap<>();

    @Override
    public String toString(){
        return new MapVisualizer(this).draw(lowerLeft, upperRight);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        if(isOccupied(animal.getPosition()))
            throw new IllegalArgumentException(animal.getPosition() + " is occupied");
        animals.add(animal);
        elements.put(animal.getPosition(), animal);
        return true;
    }

    @Override
    public void run(MoveDirection[] directions) {
        int k=0;
        for(MoveDirection direction: directions){
            Animal ob = animals.get(k);
            elements.remove(ob.getPosition());
            //animals.get(k).move(direction);
            ob.move(direction);
            elements.put(ob.getPosition(), ob);
            k=(k+1)%animals.size();
            lowerLeft = lowerLeft.lowerLeft(ob.getPosition());
            upperRight = upperRight.upperRight(ob.getPosition());

            System.out.println(this.toString());
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position)!=null;
    }

    @Override
    public Object objectAt(Vector2d position) {
        return elements.get(position);
    }

}
