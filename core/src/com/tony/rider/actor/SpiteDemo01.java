package com.tony.rider.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.scenes.scene2d.ui.Image;


public class SpiteDemo01 extends Image {
    private ShaderProgram program;

    public SpiteDemo01(Texture texture){
        super(texture);
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("unityshader/gray.vert"),
                    Gdx.files.internal("unityshader/gray.frag"));
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {

        batch.setShader(program);
        super.draw(batch, parentAlpha);
        batch.setShader(null);
    }
}
