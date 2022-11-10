package com.tony.rider.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.tony.rider.asset.Asset;

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
            int timeLocation = shadowProgram.getUniformLocation("time");
            shadowProgram.setUniformf(timeLocation,time*0.8F);
            super.draw(batch, parentAlpha);
            batch.setShader(null);
        }else {
            super.draw(batch, parentAlpha);
        }
    }
}
