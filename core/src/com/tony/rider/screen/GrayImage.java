package com.tony.rider.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.tony.rider.asset.Asset;

public class GrayImage extends Image {
    private ShaderProgram program;
    public GrayImage(){
        super(Asset.getAsset().getTexture("1234.png"));
        program = new ShaderProgram(Gdx.files.internal("hui/txt.vert"),
                Gdx.files.internal("hui/grayscale.glsl"));
    }

    public void draw(Batch batch, float parentAlpha) {
        batch.setShader(program);
        super.draw(batch, parentAlpha);
        batch.setShader(null);
    }
}
