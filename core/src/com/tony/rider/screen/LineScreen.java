package com.tony.rider.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.Align;
import com.tony.rider.BgGroup;
import com.tony.rider.BgGroup2;
import com.tony.rider.BgGroup3;
import com.tony.rider.BgGroup4;
import com.tony.rider.BgGroup5;
import com.tony.rider.asset.Asset;
import com.tony.rider.screen.base.BaseScreen;

public class LineScreen extends BaseScreen {
    @Override
    public void show() {
        super.show();
//        lineOne();
//        bg1(); ///中间向边上扩散
        bg2();//  边上向中间
//        bg3();
//        bg4();
//        bg5();
//        pre();
    }

    private void pre() {
        GrayImage grayImage = new GrayImage();
        addActor(grayImage);
    }

    private void bg5() {
        Image image = new Image(Asset.getAsset().getTexture("bg.png"));
        addActor(image);
        BgGroup5 group = new BgGroup5(image.getWidth(),image.getHeight());
        addActor(group);
//        Image image11 = new Image(Asset.getAsset().getTexture("noise.png"));
//        image11.setSize(image.getWidth(),image.getWidth());
//        image11.setColor(240.0F/255, 217.0F/255, 187.0F/255,1);
//        addActor(image11);
//        image11.setOrigin(Align.center);
//        image11.addAction(Actions.parallel(
//                Actions.scaleTo(0,0,11.0f),
//                Actions.fadeOut(11.0f)));
    }

    private void bg4() {
        Image image = new Image(Asset.getAsset().getTexture("bg.png"));
        addActor(image);
        BgGroup4 bgGroup4 = new BgGroup4(new SpriteDrawable(
                new Sprite(Asset.getAsset().getTexture("noise.png"))));
        bgGroup4.setSize(image.getWidth(),image.getHeight());
        addActor(bgGroup4);

    }

    public void bg1(){
        Image image = new Image(Asset.getAsset().getTexture("bg.png"));
        addActor(image);
        BgGroup group = new BgGroup(image.getWidth(),image.getHeight());
        addActor(group);
    }

    public void bg2(){
        Image image = new Image(Asset.getAsset().getTexture("bg.png"));
        addActor(image);
        BgGroup2 group = new BgGroup2(image.getWidth(),image.getHeight());
        addActor(group);
    }


    public void bg3(){
        Image image = new Image(Asset.getAsset().getTexture("bg.png"));
        addActor(image);
        BgGroup3 group = new BgGroup3(image.getWidth(),image.getHeight());
        addActor(group);
        BgGroup2 group1 = new BgGroup2(image.getWidth(),image.getHeight());
        addActor(group1);
        group1.setSpeed(0.33f);
    }

    private void lineOne() {

        LineOutOne image2 = new LineOutOne(
                Asset.getAsset().findAtlas()
                );
        image2.setPosition(100,100);
        image2.setDebug(true);
        addActor(image2);
        image2.addAction(Actions.delay(2,Actions.run(()->{
            image2.setAnimation();
        })));
    }
}
