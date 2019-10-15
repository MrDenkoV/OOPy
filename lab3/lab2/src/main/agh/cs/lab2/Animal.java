package agh.cs.lab2;

public class Animal {
    private MapDirection direction = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);

    @Override
    public String toString() {
        return "Pos:" + this.position/*.toString()*/ + " Dir:" + this.direction;
    }

    public void move(MoveDirection dir){
        Vector2d tmp = direction.toUnitVector();
        switch (dir){
            case BACKWARD:
                tmp = tmp.opposite();
            case FORWARD:
                this.position = this.position.add(tmp);
                break;
            case LEFT:
                this.direction = direction.previous();
                break;
            case RIGHT:
                this.direction = direction.next();
                break;
        }
        if(this.position.x<0 || this.position.x>4 || this.position.y<0 || this.position.y>4)
            this.position = this.position.subtract(tmp);
    }

}
