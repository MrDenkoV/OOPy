package agh.cs.lab2;

public class Animal implements IMapElement {
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
                return "^";
            case SOUTH:
                return "v";
            case EAST:
                return ">";
            default:
                return "<";
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
                Vector2d tmp2=this.position.add(tmp);
                if(this.map.canMoveTo(tmp2))
                    this.position = tmp2;
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
