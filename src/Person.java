import processing.core.PApplet;

public abstract class Person {
    final static double PROB_RIGHT = 0.20;
    final static double PROB_LEFT = 0.20;
    final static double PROB_UP = 0.20;
    final static double PROB_DOWN = 0.25;

    private Point position;
    private double radius;
    private int colour;
    private int x;
    private int y;
    float xVelocity;
    float yVelocity;
    PApplet p;

    //public Person(PApplet p) {
//        this.p = p;
//        this.position = new Point(100, 100);
//        this.colour = 0;
//        this.radius = 50;
//    }

//    public Person() {
//        this.p = p;
//        this.position = new Point(p.random(100),100);
//        this.colour = 0;
//        this.radius = 50;
//
//    }

    public void draw(PApplet p) {
        p.fill(colour);
        p.circle(this.getPosition().getX(),
                this.getPosition().getX(), (float) this.radius);
        walk();
    }

    public Point getPosition() {
        return position;
    }
    public int getColour() {
        return colour;
    }

    public void setPosition(Point point) {
        this.position = position;
    }
    public void setColour(int Colour) {
        this.colour = colour;
    }

     abstract public void  walk();

//         void move(PApplet p) {
//        double r = p.random(1);
//        if (r <= PROB_RIGHT) {
//            this.x++;
//        } else if (r <= PROB_LEFT + PROB_RIGHT) {
//            this.x--;
//
//        } else if (r <= PROB_LEFT + PROB_RIGHT + PROB_UP) {
//            this.y--;
//        } else {
//            this.y++;
//
//        }
    }

