import processing.core.PApplet;
import java.util.ArrayList;

public class Sketch extends PApplet {
   int numOfZombies=20;
   int numOfHumans=20;
   int humanCounter= 0;
   int zombieCounter=0;

     ParticleSystem particles;
     ArrayList<ParticleSystem> particleSystem= new ArrayList<ParticleSystem>();
     ArrayList<Human> humans = new ArrayList<Human>();
    ArrayList<Zombie> zombies = new ArrayList<Zombie>();

    public void settings(){
        size (800,800);
    }

    public void setup() {
        addHumans();
        addZombies();

    }

    public void draw(){
        background(255);
        humanCounter();
        zombieCounter();
        ArrayList<Human> tempHumans = new ArrayList<Human>();
        ArrayList<Zombie> tempZombies= new ArrayList<Zombie>();
        tempHumans.addAll(humans);
        tempZombies.addAll(zombies);
        for(Zombie z: tempZombies) {
            z.draw();
            z.walk();
        }
        for(Human h: tempHumans) {
            h.draw();
            h.walk();
        }

        for(Human h: tempHumans){
            for(Zombie z: tempZombies){
                if (h.collision(z)){
                    fight(h,z);
                }
            }
        }
        drawParticles();
    }

    public void makeZombie(Human h){
        zombies.add(new Zombie(h.getX(), h.getY(),this));
        for(Zombie z:zombies) {
            z.draw();
            z.walk();
        }
        humans.remove(h);
        System.out.println("zombie made");
    }

    public void live(Zombie z){
        particleSystem.add(new ParticleSystem((int)z.getX(), (int)z.getY(), this));
        zombies.remove(z);
        System.out.println("zombie killed");
    }

    public void fight(Human h, Zombie z){
        double r = random(10);
        if (r <= 7){
            makeZombie(h);
        }else live(z);
        humanCounter = humans.size();
        zombieCounter = zombies.size();

    }

    public void drawParticles(){
        for (ParticleSystem ps: particleSystem){
            ps.draw();
            ps.update();
        }
    }
    public void zombieCounter() {
        fill(0);
        textSize(25);
        text("Zombies left: " + zombieCounter, width/2-90, 25);
    }
    public void humanCounter() {
        fill(0);
        textSize(25);
        text("Humans left: " + humanCounter, width/2-90, height-20);
    }
    public void addZombies() {
        for(int i = 0; i < numOfZombies; ++i) {
            Zombie temp = new Zombie(random(15, width-50), random(25, 200), this);
            zombies.add(temp);
            zombieCounter ++;
            System.out.println("Added a Zombie");
        }
    }
    public void addHumans() {
        for(int i = 0; i < numOfHumans; ++i) {
            Human temp = new Human(random(15, width-50), random(height - 180, height -80), this);
            humans.add(temp);
            //humanCounter ++;
            System.out.println("Added a Human");
        }
    }
}
