package com.tony.rider.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class ImageZh extends Image {
    private ShaderProgram program;

    public ImageZh(TextureRegion texture){
        super(texture);
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/zh.glsl"));
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.setShader(program);
        super.draw(batch, parentAlpha);
        batch.setShader(null);
    }
}
