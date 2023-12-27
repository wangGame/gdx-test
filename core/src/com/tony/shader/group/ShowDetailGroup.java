package com.tony.shader.group;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.kw.gdx.asset.Asset;
import com.kw.gdx.constant.Constant;
import com.kw.gdx.view.dialog.base.BaseDialog;

import kw.learn.base.BaseImage;
import kw.learn.manger.GroupManager;

/**
 * @Auther jian xian si qi
 * @Date 2023/12/25 14:32
 */
public class ShowDetailGroup extends BaseDialog {

    public ShowDetailGroup(int index){
        Image bg = new Image(Asset.getAsset().getTexture("white_bg.png"));
        dialogGroup.addActor(bg);
        bg.setSize(Constant.GAMEWIDTH,Constant.GAMEHIGHT);
        bg.setColor(Color.WHITE);
        bg.getColor().a = 0;
        bg.setPosition(getWidth()/2.0f,getHeight()/2.0f, Align.center);
        showDetailGroup(index);
        bg.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                closeDialog();
            }
        });
    }

    private void showDetailGroup(int index) {
        Actor group = GroupManager.createGroup(index);
        if (group != null) {
            if (group instanceof BaseImage){
                ((BaseImage)(group)).initShader();
            }
            Image bg = new Image(Asset.getAsset().getTexture("white_bg.png"));
            addActor(bg);
            bg.setSize(group.getWidth(),group.getHeight());
            bg.setColor(Color.valueOf("#AAAAAA"));
            addActor(group);
            group.setPosition(getWidth() / 2.0f, getHeight() / 2.0f, Align.center);
            bg.setPosition(group.getX(Align.center),getY(Align.center), Align.center);
        }
    }
}
