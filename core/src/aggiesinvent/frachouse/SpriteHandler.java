package aggiesinvent.frachouse;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Queue;

import java.util.HashMap;

/**
 * Created by JohnS on 2/4/2017.
 */

public class SpriteHandler {
    private static SpriteBatch gamebatch = new SpriteBatch();
    private static HashMap<Integer, GameObject> objectlist = new HashMap<Integer, GameObject>();
    private static Queue<GameObject> removequeue = new Queue<GameObject>();

    public static void addObject(GameObject object) {
        objectlist.put(object.hashCode(), object);
    }

    public static void removeObject(GameObject object) {
        removequeue.addLast(object);
    }

    public static void thinkAll() {
        for(GameObject object : objectlist.values()) {
            object.think();
        }
        while(removequeue.size>0) {
            objectlist.remove(removequeue.get(0));
            removequeue.removeFirst();
        }
    }

    public static void drawAll() {
        gamebatch.begin();
        for(GameObject object : objectlist.values()) {
            object.draw();
        }
        gamebatch.end();
    }

    public static SpriteBatch getSpriteBatch() {
        return gamebatch;
    }
}
