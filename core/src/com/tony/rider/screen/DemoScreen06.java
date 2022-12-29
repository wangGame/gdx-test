package com.tony.rider.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.tony.rider.ImageGroup;
import com.tony.rider.actor.SpiteDemo01;
import com.tony.rider.actor.SpiteDemo02;
import com.tony.rider.actor.SpiteDemo03;
import com.tony.rider.asset.Asset;
import com.tony.rider.screen.base.BaseScreen;

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
