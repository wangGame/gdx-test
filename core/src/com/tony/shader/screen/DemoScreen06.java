package com.tony.shader.screen;

import com.badlogic.gdx.graphics.Texture;
import com.tony.shader.actor.SpiteDemo01;
import com.tony.shader.actor.SpiteDemo02;
import com.tony.shader.actor.SpiteDemo03;
import com.tony.shader.asset.Asset;
import com.tony.shader.screen.base.BaseScreen;

public class DemoScreen06 extends BaseScreen {
    @Override
    public void show() {
        super.show();
        demo03();
    }


    public void demo03(){
        Texture texture = Asset.getAsset().getTexture("_cat-58830.png");
        SpiteDemo03 demo01 = new SpiteDemo03(texture);
        addActor(demo01);
    }


    public void demo02(){
        Texture texture = Asset.getAsset().getTexture("_cat-58830.png");
        SpiteDemo02 demo01 = new SpiteDemo02(texture);
        addActor(demo01);
    }

    public void demo01(){
        Texture texture = Asset.getAsset().getTexture("_cat-58830.png");
        SpiteDemo01 demo01 = new SpiteDemo01(texture);
        addActor(demo01);
    }
}
