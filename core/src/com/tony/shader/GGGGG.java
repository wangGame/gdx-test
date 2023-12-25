package com.tony.shader;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.tony.shader.actor.EdegeImage;
import com.tony.shader.actor.ExpuseImage;
import com.tony.shader.asset.Asset;
import com.tony.shader.constant.Constant;

public class GGGGG extends Group {
    private FrameBuffer buffer;
    public GGGGG(){
        Image ixx = new Image(Asset.getAsset().getTexture("baise.png"));
        addActor(ixx);
        ixx.setColor(1,1,1,1);
        ixx.setX(600);
        ixx.setSize(256,256);
        EdegeImage image1 = new EdegeImage(new Texture("Sprite/00012.png"));
        addActor(image1);
        image1.setX(600);
        ExpuseImage expuseImage1 = new ExpuseImage(new Texture("Sprite/00012.png"));
        addActor(expuseImage1);
        expuseImage1.setX(600);

        buffer = new FrameBuffer(Pixmap.Format.RGBA8888, (int) Constant.GAMEWIDTH,(int)Constant.GAMEHIGHT,false);

    }


    public Texture getBuffer() {
        return buffer.getColorBufferTexture();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.flush();
        buffer.begin();
        super.draw(batch, parentAlpha);
        batch.flush();
        buffer.end();
    }
}
