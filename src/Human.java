import processing.core.PApplet;

public class Human extends Person {
    float x;
    float y;
    float size;
    PApplet p;

    public Human(float x,float y, PApplet sketch) {
        this.x =x;
        this.y = y;
        this.p = sketch;
        size = p.random(15,50);
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
    public void setY(){
        this.y= y;
    }
//    public Human(Sketch sketch) {
//        super();
//        super.setPosition(new Point(x,y));
//        setColour(25);
//
//    }
    public void draw(){
        p.fill(25);
        this.p.circle(this.x, this.y, size );
    }

    public boolean collision(Zombie z) {
        float distance = this.p.dist(z.getX(),z.getY(),this.x, this.y);
        float radiusSum= getRadius() + z.getRadius();
        if( distance <= radiusSum){
           System.out.println("collision");
            return true;
        }else
            return false;
    }

   public float getRadius(){
        float radius= size/2;
        return radius;
    }

    public void walk () {
        double r = p.random(1);
        if (r <= PROB_RIGHT) {
            this.x++;
        } else if (r <= PROB_LEFT + PROB_RIGHT) {
            this.x--;

        } else if (r <= PROB_LEFT + PROB_RIGHT + PROB_UP) {
            this.y++;
        } else {
            this.y--;

        }
    }
}
