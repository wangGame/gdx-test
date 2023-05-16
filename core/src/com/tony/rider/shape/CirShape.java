package com.tony.rider.shape;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * @Auther jian xian si qi
 * @Date 2023/3/18 11:18
 */
public class CirShape extends Actor {
    private ShapeRenderer renderer ;

    public CirShape(){
        renderer = new ShapeRenderer();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        renderer.setColor(Color.BLACK);
        renderer.begin(ShapeRenderer.ShapeType.Line);
        renderer.circle(100,100,100);
        renderer.end();
    }

}
