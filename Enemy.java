import lang.stride.*;
import java.util.*;
import greenfoot.*;

public class Enemy extends Actor {
    private int health = 3;
    public int moveX = 0;
    public int moveY = 0;
    
    public Enemy() {
        turn(Greenfoot.getRandomNumber(360));
    }

    public void act() {
        moveAround();
        hitByPlayer();
        checkCollision();
    }

    public void moveAround() {
        move(1);
        
        if (Greenfoot.getRandomNumber(100) < 3) {
            turn(Greenfoot.getRandomNumber(90) - 45);
        }
        
        if (isAtEdge()) {
            turn(180);
        }
    }

    public void attack() {
        Actor knight = getOneIntersectingObject(Knight.class);
        if (knight != null) {
            World world = getWorld();
            world.removeObject(knight);
        }
    }
    public void hitByPlayer() {
        Actor slash = getOneIntersectingObject(Slash.class);
        if (slash != null) {
            health--;
            getWorld().removeObject(slash);
        }
        if (health < 1) {
            getWorld().removeObject(this);
        }
    }
    public void checkCollision()
    {
        if (health > 1) {
            if (getX()< 50 )
            {
                turn(180);
            }
            if (getY()< 140 )
            {
                turn(180);
            }
            if (getX()>getWorld().getWidth()- 50 )
            {
                turn(180);
            }
            if (getY()>getWorld().getHeight() - 50 )
            {
                turn(180);
            }
        }
    }
}
