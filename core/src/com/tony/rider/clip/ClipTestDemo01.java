package com.tony.rider.clip;

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
        TextureRegionUtils textureRegionUtils = new TextureRegionUtils(getX() / 2.0f, getY() / 2.0f, Asset.getAsset().getTexture("test001.png"));
        textureRegionUtils.setSize(400,400);
        group.addRegionUtils(textureRegionUtils);
//        utils1 = new TextureRegionUtils(getX()+10,getY()+10,Asset.getAsset().getTexture("xxxxxx.png"));
//        utils = new TextureRegionUtils(getX(),getY(),Asset.getAsset().getTexture("xxxxx.png"));
//        group.addRegionUtils(new TextureRegionUtils(getX()/2.0f,getY()/2.0f,Asset.getAsset().getTexture("test3.png")));
//        group.addRegionUtils(new TextureRegionUtils(getX()/2.0f,getY()/2.0f,Asset.getAsset().getTexture("test4.png")));

        clippingAttachment = new ClippingAttachment();
        clippingAttachment.setX(getX());
        clippingAttachment.setY(getY());
        float vertices[] = new float[8];
        vertices[0] = 0f;
        vertices[1] = 304.22f;
        vertices[2] = 302.38f;
        vertices[3] = 302.04f;
        vertices[4] = 300.8f;
        vertices[5] = 0;
        vertices[6] = 0;
        vertices[7] = 0f;
        clippingAttachment.setVerties(vertices);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        clipper.start(clippingAttachment);
//        utils.draw(batch,clipper);
//        utils1.draw(batch,clipper);
        group.draw((CpuPolygonSpriteBatch) batch);
        clipper.clipEnd();
    }
}
