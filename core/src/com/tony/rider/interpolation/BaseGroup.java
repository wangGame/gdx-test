package com.tony.rider.interpolation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.tony.rider.asset.Asset;

public class BaseGroup extends Image {
    protected ShaderProgram program;
    private float time = 0;

    public BaseGroup(){
        super(Asset.getAsset().getTexture("img.png"));
    }



    @Override
    public void act(float delta) {
        super.act(delta);
        time += delta;
    }

    public void draw(Batch batch, float parentAlpha) {
        batch.setShader(program);
        program.setUniformf("time",time);
        extendsMethod();
        super.draw(batch, parentAlpha);
        batch.setShader(null);
    }

    protected void extendsMethod() {

    }
}
