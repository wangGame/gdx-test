package com.tony.shader.screen;

import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.tony.shader.asset.Asset;

class ImageBlend extends Group {

    public ImageBlend(){
        Image image = new Image(Asset.getAsset().getTexture("00002.png"));
        addActor(image);
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
