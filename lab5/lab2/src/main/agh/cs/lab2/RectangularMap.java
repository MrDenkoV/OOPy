package agh.cs.lab2;

import java.util.ArrayList;
import java.util.LinkedList;

class RectangularMap implements IWorldMap {
    private int width;
    private int height;
    //Vector2d start
    private LinkedList<Animal> animals = new LinkedList<Animal>();

    public RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
    }

    public String toString(){
        return new MapVisualizer(this).draw(new Vector2d(0,0), new Vector2d(width, height));
    }

    @Override
    public boolean canMoveTo(Vector2d pos){
        return !this.isOccupied(pos) && pos.precedes(new Vector2d(this.width, this.height)) && pos.follows(new Vector2d(0, 0));
    }

    public boolean place(Animal animal){
        if(isOccupied(animal.getPosition()))//||canMoveTo(animal.getPosition()))
            return false;
        animals.add(animal);
        return true;
    }

    public void run(MoveDirection[] directions){
        int k=0;
        for(MoveDirection direction: directions){
            animals.get(k).move(direction);
            k=(k+1)%animals.size();

            System.out.println(this.toString());
        }
    }

    public boolean isOccupied(Vector2d position){
        for(Animal animal: this.animals){
            if(position.equals(animal.getPosition()))
                return true;
        }
        return false;
    }

    public Object objectAt(Vector2d position){
        for(Animal animal: animals){
            if(position.equals(animal.getPosition()))
                return animal;
        }
        return null;
    }

}
