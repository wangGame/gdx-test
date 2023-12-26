package com.tony.shader.group;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Align;
import com.kw.gdx.asset.Asset;
import com.kw.gdx.constant.Constant;
import com.kw.gdx.view.dialog.base.BaseDialog;

import kw.learn.blend.ImageBlend;
import kw.learn.image.EdegeImage;
import kw.learn.image.EdgeImage2;
import kw.learn.image.ExpuseImage;
import kw.learn.image.DissolveImage;
import kw.learn.image.GrayImage;
import kw.learn.image.LuminImage;
import kw.learn.image.NoiseImage;
import kw.learn.image.SolarizeImage;
import kw.learn.base.BaseGroup;
import kw.learn.constant.ShaderType;

/**
 * @Auther jian xian si qi
 * @Date 2023/12/25 14:32
 */
public class ShowDetailGroup extends BaseDialog {

    public ShowDetailGroup(int index){
        setDebug(true);
        Image bg = new Image(Asset.getAsset().getTexture("white_bg.png"));
        dialogGroup.addActor(bg);
        bg.setSize(Constant.GAMEWIDTH,Constant.GAMEHIGHT);
        bg.setColor(Color.WHITE);
        bg.setPosition(getWidth()/2.0f,getHeight()/2.0f, Align.center);
        showDetailGroup(index);
    }

    private void showDetailGroup(int index) {
        Actor group = createGroup(index);
        if (group != null) {
            if (group instanceof BaseGroup){
                ((BaseGroup)(group)).initShader();
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

    private Actor createGroup(int index) {
        Actor actor = null;
        switch (index){
            case ShaderType.LUMIN:
                actor = new LuminImage();
                break;
            case ShaderType.EDG:
                actor = new EdegeImage();
                break;
            case ShaderType.EXPOSURE:
                actor = new ExpuseImage();
                break;
            case ShaderType.DISSOLVE:
                actor = new DissolveImage();
                break;
            case ShaderType.NOISEONE:
                actor = new NoiseImage();
                break;
            case ShaderType.SOLARIZE:
                actor = new SolarizeImage();
                break;
            case ShaderType.EDG2:
                actor = new EdgeImage2();
                break;
            case ShaderType.GRAY:
                actor = new GrayImage();
                break;
            case ShaderType.BLEND:
                actor = new ImageBlend();
                break;
        }
        return actor;
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
