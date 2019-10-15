package agh.cs.lab2;

import javax.swing.*;
import javax.swing.text.Position;

public class Car {
    //private Position position = new Position(2, 2);
    private Vector2d position = new Vector2d(2, 2);
    private MapDirection direction = MapDirection.NORTH;

    /*public Car()
    {
        this.position = new Vector2d(2, 2);
        this.direction = MapDirection.NORTH;
    }*/

    @Override
    public String toString() {
        return "Pos:" + position.toString() + " Dir:" + direction.toString();
    }

    public void move(MoveDirection dir){
        Vector2d tmpdir=direction.toUnitVector();
        switch(dir){
            case FORWARD:{
                this.position = this.position.add(tmpdir);
                break;
            }
            case BACKWARD:{
                tmpdir.opposite();
                this.position = this.position.add(tmpdir);
                break;
            }
            case LEFT:{
                this.direction = this.direction.previous();
                break;
            }
            case RIGHT:{
                this.direction = this.direction.next();
                break;
            }

        }
        if(position.x > 4 || position.x < 0 || position.y > 4 || position.y < 0)
            this.position = this.position.subtract(tmpdir);
    }
}
