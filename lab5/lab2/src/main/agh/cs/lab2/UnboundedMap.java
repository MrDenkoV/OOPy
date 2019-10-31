package agh.cs.lab2;

import java.util.LinkedList;

public class UnboundedMap extends AbstractWorldMap{
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
    public Object objectAt(Vector2d position){
        Object object=super.objectAt(position);
        if(object!=null) return object;
        for(Stone stone: stones){
            if(position.equals(stone.getPosition()))
                return stone;
        }
        return null;
    }
}
