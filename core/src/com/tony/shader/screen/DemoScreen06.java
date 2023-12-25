package com.tony.shader.screen;

import com.badlogic.gdx.graphics.Texture;
import com.kw.gdx.BaseGame;
import com.kw.gdx.screen.BaseScreen;
import kw.learn.SpiteDemo01;
import kw.learn.SpiteDemo02;
import kw.learn.SpiteDemo03;
import com.tony.shader.asset.Asset;

public class DemoScreen06 extends BaseScreen {
    public DemoScreen06(BaseGame game) {
        super(game);
    }

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
        SpiteDemo01 demo01 = new SpiteDemo01();
        addActor(demo01);
    }
}
