package com.tony.shader.screen;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.tony.shader.asset.Asset;

public class GrayImage3 extends Image {
    private ShaderProgram program;
    public GrayImage3(){
        super(Asset.getAsset().getTexture("img.png"));
        program = new ShaderProgram(Gdx.files.internal("test/txt.vert"),
                Gdx.files.internal("test/grayscale1.glsl"));
    }

    private float time = 0;

    @Override
    public void act(float delta) {
        super.act(delta);
        time += delta;
    }

    public void draw(Batch batch, float parentAlpha) {
        batch.setShader(program);
        int contrast = program.getUniformLocation("saturation");
        System.out.println(time*0.1f);
        program.setUniformf(contrast,time*0.1f);
        super.draw(batch, parentAlpha);
        batch.setShader(null);

    }
}
