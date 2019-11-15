package agh.cs.lab2;

import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver{

    SortedSet<Vector2d> axix = new TreeSet<Vector2d>(new Vector2dCompareX());
    SortedSet<Vector2d> axiy = new TreeSet<Vector2d>(new Vector2dCompareY());

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        axix.remove(oldPosition);
        axiy.remove(oldPosition);

        axix.add(newPosition);
        axiy.add(newPosition);
    }

    public void add(IMapElement el){
        axix.add(el.getPosition());
        axiy.add(el.getPosition());
    }

    public Vector2d lowLeft(){
        if(axix.size()==0 || axiy.size()==0)
            return new Vector2d(0,0);
        return  new Vector2d(axix.last().x, axiy.last().y);
    }


    public Vector2d uppRight(){
        if(axix.size()==0 || axiy.size()==0)
            return new Vector2d(0,0);
        return new Vector2d(axix.first().x, axiy.first().y);
    }


}
