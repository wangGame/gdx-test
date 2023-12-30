package com.tony.shader.group;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import com.kw.gdx.asset.Asset;
import com.kw.gdx.constant.Constant;
import com.kw.gdx.listener.OrdinaryButtonListener;

import kw.learn.image.GammaImage;
import kw.learn.manger.GroupManager;

/**
 * @Auther jian xian si qi
 * @Date 2023/12/25 14:32
 */
public class ItemGroup extends Group {
    private int index;
    private int type;
    public ItemGroup(String text,int i){
        this(text,i,0);
    }

    public ItemGroup(String text, int i,int type){
        this.type = type;
        setSize(Constant.GAMEWIDTH/2-100,(Constant.GAMEWIDTH/2-100)* (638.0f/758.0f));
        this.index = i;
        Actor bg = null;
        if (type == 0){
             bg = GroupManager.createGroup(i);
        }else if (type == 1){
            bg = GroupManager.createInterShader(i);
        }
        setOrigin(Align.center);
        addActor(bg);
        bg.setSize(getWidth(),getHeight());
        bg.setPosition(0,0);
        bg.setDebug(true);
        setDebug(true);

        Label label = new Label("",new Label.LabelStyle(){{
            font = Asset.getAsset().loadBitFont("font/inter-middle-28.fnt");
        }});
        label.setFontScale(2);
        addActor(label);
        label.setText(text);
        label.pack();
        label.setX(getWidth()/2.f,Align.center);
        label.setY(50, Align.center);
        addListener(new OrdinaryButtonListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                Constant.currentActiveScreen.showDialog(new ShowDetailGroup(index,type));
            }
        });
    }
}
