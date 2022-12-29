package com.tony.rider.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.tony.rider.asset.Asset;

public class GrayImage extends Image {
    private ShaderProgram program;
    public GrayImage(){
        super(Asset.getAsset().getTexture("pre.png"));
        program = new ShaderProgram(Gdx.files.internal("hui/txt.vert"),
                Gdx.files.internal("hui/grayscale.glsl"));
    }

    private float time = 0;

    @Override
    public void act(float delta) {
        super.act(delta);
        time += delta;
    }

    public void draw(Batch batch, float parentAlpha) {
        batch.setShader(program);
        int contrast = program.getUniformLocation("contrast");
        System.out.println(time*0.1f);
        program.setUniformf(contrast,time*0.1f);
        super.draw(batch, parentAlpha);
        batch.setShader(null);

    }
}
