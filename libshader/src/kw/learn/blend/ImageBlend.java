package kw.learn.blend;

import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;

import kw.learn.base.BaseGroup;

public class ImageBlend extends BaseGroup {
    public ImageBlend(){
        setScale(4);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        int blendSrcFunc = batch.getBlendSrcFunc();
        int blendDstFunc = batch.getBlendDstFunc();
        batch.setBlendFunction(GL20.GL_SRC_ALPHA,GL20.GL_ONE);
        super.draw(batch, parentAlpha);
        batch.setBlendFunction(blendSrcFunc,blendDstFunc);
    }
}
