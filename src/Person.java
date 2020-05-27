import processing.core.PApplet;

public abstract class Person {
    private Point position;
    private double radius;
    private int colour;
    float xVelocity;
    float yVelocity;
    public Person(){
            this.position = new Point(0,0);
            this.colour = 0;
            this.radius = 50;
    }

    public Point getPosition() {
        return position;
    }
    public void setPosition(Point position){
        this.position=position;
    }
    public void draw(PApplet p){
        p.fill(getColor());
        p.circle(
                this.getPosition().getX();
                this.getPosition().getX();
        (float) this.radius);
        move();
    }
    void move(){
        this.position.setX();
    }
}
