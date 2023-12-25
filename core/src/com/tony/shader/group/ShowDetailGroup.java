package com.tony.shader.group;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Align;
import com.kw.gdx.asset.Asset;
import com.kw.gdx.constant.Constant;
import com.kw.gdx.view.dialog.base.BaseDialog;

/**
 * @Auther jian xian si qi
 * @Date 2023/12/25 14:32
 */
public class ShowDetailGroup extends BaseDialog {

    public ShowDetailGroup(int index){
        Image bg = new Image(Asset.getAsset().getTexture("white_bg.png"));
        addActor(bg);
        bg.setSize(Constant.GAMEWIDTH,Constant.GAMEHIGHT);
        bg.setColor(Color.WHITE);
        bg.setPosition(360,640, Align.center);
        showDetailGroup(index);
    }

    private void showDetailGroup(int index) {
        Group group = null;

        if (group != null) {
            Image bg = new Image(Asset.getAsset().getTexture("white_bg.png"));
            addActor(bg);
            bg.setSize(group.getWidth(),group.getHeight());
            bg.setColor(Color.valueOf("#AAAAAA"));
            addActor(group);
            group.setPosition(getWidth() / 2.0f, getHeight() / 2.0f, Align.center);
            bg.setPosition(group.getX(Align.center),getY(Align.center), Align.center);
        }
    }

    @Override
    public void enterAnimation() {
        getColor().a = 0;
        addAction(Actions.fadeIn(0.3f));
    }

    @Override
    public void close() {
        addAction(Actions.sequence(
                Actions.fadeOut(0.3f),
                Actions.removeActor()
        ));
    }
}
