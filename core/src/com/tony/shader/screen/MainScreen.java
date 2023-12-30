package com.tony.shader.screen;

import com.badlogic.gdx.graphics.Color;
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

import com.tony.shader.group.ItemGroup;

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
//        ScrollPane pane = new ScrollPane(new Table(){{
//            int index= 0;
//            int length = GroupManager.imageShaderItems.length;
//            for (int i = 0; i < length; i++) {
//                ItemBean itemBean = GroupManager.imageShaderItems[length-1-i];
//                index ++;
//                add(new ItemGroup(itemBean.getName(),itemBean.getIndex())).pad(20);
//                if (index % 2 == 0) {
//                    row();
//                }
//            }
//            pack();
//            align(Align.top);
//        }}){
//            @Override
//            public void setRectangle(float startX, float startY) {
//                super.setRectangle(startX, startY);
//            }
//        };
//        addActor(pane);
//        pane.setSize(Constant.GAMEWIDTH, Constant.GAMEHIGHT);
//        ExpGroup expGroup = new ExpGroup();
//        addActor(expGroup);

//        ShaderGroup group = new ShaderGroup();
//        group.setPosition(Constant.GAMEWIDTH/2.0f,Constant.GAMEHIGHT/2.0f,Align.center);
//        stage.addActor(group);

//        LinearGroup group = new LinearGroup();
//        stage.addActor(group);


        ScrollPane pane = new ScrollPane(new Table(){{
            int index= 0;
            int length = GroupManager.InterpolationShaderItems.length;
            for (int i = 0; i < length; i++) {
                ItemBean itemBean = GroupManager.InterpolationShaderItems[length-1-i];
                index ++;
                add(new ItemGroup(itemBean.getName(),itemBean.getIndex(),1)).pad(20);
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


//        Pow2InInverseGroup1 group = new Pow2InInverseGroup1();
//        addActor(group);
//        group.setPosition(100,100);
    }
}
