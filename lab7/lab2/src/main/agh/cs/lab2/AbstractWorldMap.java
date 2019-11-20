package agh.cs.lab2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{

//    protected Vector2d lowerLeft;
//    protected Vector2d upperRight;

    protected LinkedList<Animal> animals = new LinkedList<Animal>();
    protected Map<Vector2d, IMapElement> elements = new HashMap<>();


    abstract Vector2d getLowerLeft();
    abstract Vector2d getUpperRight();

    @Override
    public String toString(){
        Vector2d lowerLeft = getLowerLeft();
        Vector2d upperRight = getUpperRight();
        if(!lowerLeft.precedes(upperRight))
            return new MapVisualizer(this).draw(new Vector2d(0,0), new Vector2d(1,1));
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
        animal.addObserver(this);
        animals.add(animal);
        elements.put(animal.getPosition(), animal);
        return true;
    }

    @Override
    public void run(MoveDirection[] directions) {
        int k=0;
        for(MoveDirection direction: directions){
            Animal ob = animals.get(k);
            ob.move(direction);
            k=(k+1)%animals.size();

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

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {

        System.out.println(oldPosition);
        System.out.println(newPosition);
        IMapElement ob = elements.get(oldPosition);
        elements.remove(oldPosition);
        elements.put(newPosition, ob);
    }

}
