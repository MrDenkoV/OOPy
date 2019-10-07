package agh.cs.lab2;

import java.util.Vector;

public enum MapDirection {
    NORTH,
    SOUTH,
    WEST,
    EAST;

    public String toString() {
        switch(this) {
            case NORTH: return "Północ";
            case SOUTH: return "Południe";
            case EAST: return "Wschód";
            default: return "Zachód";
        }
    }

    public MapDirection next(){
        switch(this) {
            case NORTH: return EAST;
            case EAST: return SOUTH;
            case SOUTH: return WEST;
            default: return NORTH;
        }
    }

    public MapDirection previous(){
        switch(this){
            case NORTH: return WEST;
            case WEST: return SOUTH;
            case SOUTH: return EAST;
            default: return NORTH;
        }
    }
    public Vector2d toUnitVector() {
        switch(this){
            case NORTH: return new Vector2d(0, 1);
            case EAST: return new Vector2d(1, 0);
            case SOUTH: return new Vector2d(0, -1);
            default: return new Vector2d(-1, 0);
        }
    }

}
