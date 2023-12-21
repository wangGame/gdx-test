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
        group.addRegionUtils(new TextureRegionUtils(getX()+10,getY()+10,Asset.getAsset().getTexture("xxxxxx.png")));
//        utils1 = new TextureRegionUtils(getX()+10,getY()+10,Asset.getAsset().getTexture("xxxxxx.png"));
//        utils = new TextureRegionUtils(getX(),getY(),Asset.getAsset().getTexture("xxxxx.png"));

        clippingAttachment = new ClippingAttachment();
        clippingAttachment.setX(getX());
        clippingAttachment.setY(getY());
        float vertices[] = new float[10];
        vertices[0] = 0.32f;
        vertices[1] = 204.22f;
        vertices[2] = 202.38f;
        vertices[3] = 202.04f;

        vertices[4] = 300.8f;
        vertices[5] = 100;


        vertices[6] = 200.8f;
        vertices[7] = 0;
        vertices[8] = 0;
        vertices[9] = 0.05f;
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
