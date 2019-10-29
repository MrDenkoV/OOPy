package agh.cs.lab2;

import java.util.LinkedList;

public class UnboundedMap implements IWorldMap {
    private int inf=Integer.MAX_VALUE;

    private LinkedList<Stone> stones;
    private LinkedList<Animal> animals = new LinkedList<Animal>();


    public UnboundedMap(LinkedList<Stone> stones){
        this.stones=stones;
    }

    public String toString(){
        int minx=inf, miny=inf, maxx=-inf, maxy=-inf;
        for(Stone stone: stones){
            minx=Math.min(stone.getPosition().x, minx);
            miny=Math.min(stone.getPosition().y, miny);
            maxx=Math.max(stone.getPosition().x, maxx);
            maxy=Math.max(stone.getPosition().y, maxy);
        }
        for(Animal animal: animals){
            minx=Math.min(animal.getPosition().x, minx);
            miny=Math.min(animal.getPosition().y, miny);
            maxx=Math.max(animal.getPosition().x, maxx);
            maxy=Math.max(animal.getPosition().y, maxy);
        }
        return new MapVisualizer(this).draw(new Vector2d(minx,miny), new Vector2d(maxx, maxy));
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal){
        if(isOccupied(animal.getPosition()))//||canMoveTo(animal.getPosition()))
            return false;
        animals.add(animal);
        return true;
    }

    @Override
    public void run(MoveDirection[] directions){
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
    public Object objectAt(Vector2d position){
        for(Animal animal: animals){
            if(position.equals(animal.getPosition()))
                return animal;
        }
        for(Stone stone: stones){
            if(position.equals(stone.getPosition()))
                return stone;
        }
        return null;
    }
}
