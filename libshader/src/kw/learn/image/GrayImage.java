package kw.learn.image;

import com.badlogic.gdx.graphics.g2d.Batch;

import kw.learn.base.BaseImage;

public class GrayImage extends BaseImage {
    public GrayImage(){
        vertShader = "realseshader/common.vert";
        frangShader = "realseshader/grayScale.glsl";
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
