package com.tony.rider.clip;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.CpuPolygonSpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.tony.rider.asset.Asset;

/**
 * @Auther jian xian si qi
 * @Date 2023/12/21 14:25
 */
public class ClipTestDemo01 extends Group {
    private ClippingAttachment clippingAttachment;
    private SkeletonClipping clipper;
    private TexureRegionGroup group;
    public ClipTestDemo01() {}

    public void init(){
        clipper = new SkeletonClipping();
        group = new TexureRegionGroup(clipper);
        Texture texture = Asset.getAsset().getTexture("test001.png");
        TextureRegionUtils textureRegionUtils = new TextureRegionUtils(getX() / 2.0f, getY() / 2.0f,texture);

        group.addRegionUtils(textureRegionUtils);
//        utils1 = new TextureRegionUtils(getX()+10,getY()+10,Asset.getAsset().getTexture("xxxxxx.png"));
//        utils = new TextureRegionUtils(getX(),getY(),Asset.getAsset().getTexture("xxxxx.png"));
//        group.addRegionUtils(new TextureRegionUtils(getX()/2.0f,getY()/2.0f,Asset.getAsset().getTexture("test3.png")));
//        group.addRegionUtils(new TextureRegionUtils(getX()/2.0f,getY()/2.0f,Asset.getAsset().getTexture("test4.png")));

        clippingAttachment = new ClippingAttachment();
        clippingAttachment.setClipX(getX());
        clippingAttachment.setClipY(getY());
        float vertices[] ={
                0f,         304.22f,
                150f,         600,
                302.38f,    302.04f,
                300.8f,     0,
                0,          0f
        };
        clippingAttachment.setVerties(vertices);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        clipper.start(clippingAttachment);
//        utils.draw(batch,clipper);
//        utils1.draw(batch,clipper);
        group.draw((CpuPolygonSpriteBatch) batch,parentAlpha);
        clipper.clipEnd();
    }
}
