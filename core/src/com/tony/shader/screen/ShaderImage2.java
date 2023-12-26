package com.tony.shader.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

public class ShaderImage2 extends Image {
    private ShaderProgram shadowProgram;
    private float time = 0;
    public ShaderImage2(SpriteDrawable spriteDrawable){
        super(spriteDrawable);
        shadowProgram = new ShaderProgram(
                Gdx.files.internal("shader2/levelXianshi.vert"),
                Gdx.files.internal("shader2/Demo14.frag"));
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        time+=delta;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if (shadowProgram!=null) {
            batch.setShader(shadowProgram);
            super.draw(batch, parentAlpha);
            batch.setShader(null);
        }else {
            super.draw(batch, parentAlpha);
        }
    }
}
