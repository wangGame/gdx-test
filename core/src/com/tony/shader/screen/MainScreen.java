package com.tony.shader.screen;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.kw.gdx.BaseGame;
import com.kw.gdx.constant.Constant;
import com.kw.gdx.screen.BaseScreen;
import com.kw.gdx.asset.Asset;

import kw.learn.bean.ItemBean;
import kw.learn.manger.GroupManager;
import kw.learn.model.ModelIv;
import com.tony.shader.group.ItemGroup;

import kw.learn.constant.ShaderType;

public class MainScreen extends BaseScreen {

    public MainScreen(BaseGame game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();
        Image bg = new Image(Asset.getAsset().getTexture("white_bg.png"));
        bg.setSize(Constant.GAMEWIDTH,Constant.GAMEHIGHT);
        addActor(bg);
        bg.setColor(Color.valueOf("#b9920c"));
        bg.setPosition(Constant.GAMEWIDTH/2.0f,Constant.GAMEHIGHT/2.0f,Align.center);
        ScrollPane pane = new ScrollPane(new Table(){{
            int index= 0;
            for (ItemBean itemBean : GroupManager.itemBeans) {
                index ++;
                add(new ItemGroup(itemBean.getName(),itemBean.getIndex())).pad(20);
                if (index % 2 == 0) {
                    row();
                }
            }
            pack();
            align(Align.top);
        }}){
            @Override
            public void setRectangle(float startX, float startY) {
                super.setRectangle(startX, startY);
            }
        };
        addActor(pane);
        pane.setSize(Constant.GAMEWIDTH, Constant.GAMEHIGHT);

//        Texture texture = Asset.getAsset().getTexture("test.png");
//
//        ModelIv dissolveImage2 = new ModelIv();
//        addActor(dissolveImage2);

    }
}