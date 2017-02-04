package aggiesinvent.frachouse;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by JohnS on 2/4/2017.
 */

public abstract class GameObject {

    private Vector2 coord;
    private Vector2 vel;
    private static Texture image;

    public abstract void think();
    public abstract void draw();
}
