package com.tony.rider.clip;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.tony.rider.asset.Asset;

/**
 * @Auther jian xian si qi
 * @Date 2023/12/22 10:15
 */
public class ClipDemo extends ClipGroup {
    public ClipDemo(){
        clippingAttachment = new ClippingAttachment();
        float vertices[] ={
                100,400,
                200,300,
                300,400,
                400,200,
                200,0,
                0,200

                //                0f,         304.22f,
//                150f,         600,
//                302.38f,    302.04f,
//                602.38f,    102.04f,
//                300.8f,     0,
//                30,          40f
        };
        clippingAttachment.setVerties(vertices);
        Texture texture = Asset.getAsset().getTexture("test001.png");
        TextureRegionActor textureRegionActor = new TextureRegionActor(getX() / 2.0f, getY() / 2.0f,texture);
        addActor(textureRegionActor);
    }
}
