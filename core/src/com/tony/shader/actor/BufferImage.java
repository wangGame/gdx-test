package com.tony.shader.actor;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.tony.shader.constant.Constant;

import kw.learn.EdegeImage;
import kw.learn.ExpuseImage;

public class BufferImage extends Group {
    public FrameBuffer buffer;
    public BufferImage(){
//        EdegeImage image = new EdegeImage(new Texture("Sprite/00012.png"));
//        image.setColor(1,1,1,1F);
//        ExpuseImage image1 = new ExpuseImage(new Texture("Sprite/00012.png"));
//        addActor(image1);
//        image1.setColor(1,1,1,1F);
//        addActor(image);
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
