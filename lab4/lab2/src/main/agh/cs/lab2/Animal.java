package agh.cs.lab2;

public class Animal {
    private MapDirection direction = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);

    private IWorldMap map;

    public Animal(IWorldMap map){
        this.map=map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map = map;
        this.position=initialPosition;
    }

    @Override
    public String toString() {
        //return "Pos:" + this.position/*.toString()*/ + " Dir:" + this.direction;
        switch (this.direction){
            case NORTH:
                return "N";
            case SOUTH:
                return "S";
            case EAST:
                return "E";
            default:
                return "W";
        }
    }

    public Vector2d getPosition(){
        return this.position;
    }

    public void move(MoveDirection dir){
        Vector2d tmp = this.direction.toUnitVector();
        switch (dir){
            case BACKWARD:
                tmp = tmp.opposite();
            case FORWARD:
                if(this.map.canMoveTo(this.position.add(tmp)))
                    this.position = this.position.add(tmp);
                return;
            case LEFT:
                this.direction = direction.previous();
                return;
            case RIGHT:
                this.direction = direction.next();
        }
        //if(!(this.position.follows(new Vector2d(0,0)) && this.position.precedes(new Vector2d(4,4))))
        //if(!this.map.canMoveTo(this.position))
        //    this.position = this.position.subtract(tmp);
    }

}
