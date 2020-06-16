import processing.core.PApplet;

public class Zombie extends Person {
    float x;
    float y;
    float size;
    PApplet p;

    public Zombie (float x,float y, PApplet sketch) {
        this.x =x;
        this.y = y;
        this.p = sketch;
        size= p.random(15,50);
    }

//    public Zombie (Sketch sketch) {
//        super();
//        super.setPosition(new Point(x, y));
//        setColour(200);
//    }

    public void draw(){
     p.fill(100);
     this.p.circle(this.x, this.y, size);
    }
    public float getX(){
        return x;
    }
    public void setX(){
        this.x= x;
    }
    public float getY(){
        return y;
    }
    public void setY(float v){
        this.y= y;
    }
    public float getRadius(){
        float radius= size/2;
        return radius;
    }
        public void walk(){
            double r = p.random(1);
            if (r <= PROB_RIGHT) {
                this.x++;
            } else if (r <= PROB_LEFT + PROB_RIGHT) {
                this.x--;

            } else if (r <= PROB_LEFT + PROB_RIGHT + PROB_UP) {
                this.y--;
            } else {
                this.y++;

            }
        }
    }

