package agh.cs.lab2;

import java.util.LinkedList;

public class AbstractWorldMap implements IWorldMap{

    protected LinkedList<Animal> animals = new LinkedList<Animal>();


    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        if(isOccupied(animal.getPosition()))
            return false;
        animals.add(animal);
        return true;
    }

    @Override
    public void run(MoveDirection[] directions) {
        int k=0;
        for(MoveDirection direction: directions){
            animals.get(k).move(direction);
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
        for(Animal animal: animals){
            if(position.equals(animal.getPosition()))
                return animal;
        }
        return null;
    }

}
