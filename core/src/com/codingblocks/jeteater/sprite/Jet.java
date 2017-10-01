package com.codingblocks.jeteater.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by sridhar123 on 30/9/17.
 */

//sprite is a class in itself so we extend it and do inheritance
public class Jet extends Sprite{

    public Jet(){
        //this texture is passd onto the sprite super class
        //image->texture->sprite
        super(new Texture( "jet.png"));
    }

    public void setGoal(int x, int y) {
        Vector2 source= new Vector2(getX(),getY());
        Vector2 dest = new Vector2(x,y);
        Vector2 path = dest.sub(source);

        int pathX = (int)(getX() + path.x/50);
        int pathY = (int)(getY() + path.y/50);

        setPosition(pathX,pathY);
        setRotation(path.angle());
    }
}
