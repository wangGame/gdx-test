package com.tony.rider;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.tony.rider.asset.Asset;

public class TipBg extends Actor {
    TipBgPatch patch;

    public TipBg(){
        Sprite sprite = new Sprite(Asset.getAsset().getTexture("chestReward_back.png"));
        patch = new TipBgPatch(new TextureRegion(sprite),13,8,8,19,23,55);
        setSize(100,120);
        setPosition(100,100);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.setColor(Color.WHITE);
        if(patch!=null){
            patch.draw(batch,x,y,60,width,height);
        }
    }
}
