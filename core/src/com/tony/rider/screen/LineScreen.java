package com.tony.rider.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.Align;
import com.tony.rider.BgGroup;
import com.tony.rider.BgGroup2;
import com.tony.rider.BgGroup3;
import com.tony.rider.BgGroup4;
import com.tony.rider.BgGroup5;
import com.tony.rider.BseInterpolation;
import com.tony.rider.actor.ImageGroup;
import com.tony.rider.actor.ImageGroup2;
import com.tony.rider.actor.Wd11;
import com.tony.rider.asset.Asset;
import com.tony.rider.constant.Constant;
import com.tony.rider.screen.base.BaseScreen;
import com.tony.rider.wd.Wd1;

public class LineScreen extends BaseScreen {
    @Override
    public void show() {
        super.show();
//        bg0();
//        bg1(); ///中间向边上扩散
//        bg2();//  边上向中间
//        bg3();
//        bg4();
//        bg5();
//        bg6();

//        lineOne();
//        block08();
//        block09();


//        pre();
//        bg8();

//        Texture texture = Asset.getAsset().getTexture("_cat-58830.png");
////        ExpuseImage expuseImage = new ExpuseImage(texture);
////        addActor(expuseImage);
//        Solarize solarize = new Solarize(texture);
//        addActor(solarize);
//        hitposi();

//        hui1();
//        pre();



//        Image i
//                 = new Image(Asset.getAsset().getTexture("00013.png"));
//        addActor(i);
//        i.setDebug(true);
//        i.setScale(0.4f);
//        block08();
//        block09();
//        test();

        cirChange();
//        scroll();
    }

    private void scroll() {
        Group group = new Group(){
            {
                for (int i = 0; i < 10; i++) {
                    Image image = new Image(new Texture("00013.png"));
                    addActor(image);
                    image.setX(266 * i);
                }
                setWidth(256 * 100);
            }
        };
        group.setHeight(256);
        ScrollPane pane = new ScrollPane(group,new ScrollPane.ScrollPaneStyle());
        pane.setWidth(Constant.WIDTH);
        pane.setHeight(600);
        pane.setY(300);
        addActor(pane);
        group.setDebug(true);
        group.addAction(Actions.parallel(
                Actions.sizeTo(0,256,10),
                Actions.forever(Actions.run(()->{
                    pane.layout();
                    pane.updateVisualScroll();
                }))
                ));
    }
    float v;
    public void cirChange(){
        BseInterpolation bseInterpolation = new BseInterpolation(0.25f,0,1.0f,0.99f);
        Image imageBg = new Image(new Texture("img.png"));
        imageBg.setPosition(300,300);
        addActor(imageBg);
        imageBg.setScale(4);

        ShaderProgram program = new ShaderProgram(
                Gdx.files.internal("levelitem/cir.vert"),
                Gdx.files.internal("levelitem/cir.glsl"));

   Image image = new Image(new Texture("img1.png")){
            private float time = 0;
            @Override
            public void act(float delta) {
                super.act(delta);
                //        v += delta * 1.52f;
                v += delta * 0.12f;

                time = bseInterpolation.apply(v)*10.52f;
                System.out.println(time);
            }

            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                program.setUniformf("time",time*0.1f);
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        image.setPosition(300,300);
        addActor(image);
        image.setScale(4);
    }

    private void test() {
        ImageBlend blend = new ImageBlend();
        addActor(blend);
    }


    private void hui1() {
        Image image = new Image(Asset.getAsset().getTexture("white_bg.png"));
        addActor(image);
        image.setSize(1500,1500);
        image.setColor(Color.valueOf("#fffbe5"));
        GrayImage3 grayImage2 = new GrayImage3();
        addActor(grayImage2);
    }

    private void hui() {
        Image image = new Image(Asset.getAsset().getTexture("white_bg.png"));
        addActor(image);
        image.setSize(1500,1500);
        image.setColor(Color.valueOf("#fffbe5"));
        GrayImage2 grayImage2 = new GrayImage2();
        addActor(grayImage2);
        Image sha = new Image(Asset.getAsset().getTexture("mask.png"));
        addActor(sha);
    }

    private void hitposi() {
        Image image = new Image(Asset.getAsset().getTexture("_carpet-58882.png"));
        addActor(image);
        image.setPosition(200,200);
        image.setRotation(50);
        image.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                System.out.println("click ---- >>> ");
            }
        });
    }

    private void block09() {
        Image image = new Image(Asset.getAsset().getTexture("bg.png"));
        addActor(image);
        ImageGroup2 im = new ImageGroup2(400,400);
        addActor(im);

    }

    private void block08() {

        String str[] = {
                "2_chuan2",
        };
        addActor(new Table(){{
            int index = 0;
            for (String s : str) {
                index ++;
                Sprite sprite = Asset.getAsset().loadAtlas("levelAtlas.atlas", s);
                ImageGroup im = new ImageGroup(sprite);
                im.setOrigin(Align.center);

                add(im);
                if (index>3) {
                    index=0;
                    row();
                }
            }
            pack();
        }});

    }

    private void bg5() {
        Image image = new Image(Asset.getAsset().getTexture("bg.png"));
        addActor(image);
        Image sha = new Image(Asset.getAsset().getTexture("white_bg.png"));
        addActor(sha);
        sha.setSize(image.getWidth(),image.getHeight());
        sha.setColor(240.0F/255.0f, 217.0F/255.0f, 187.0F/255.0f,1.0f);
        sha.addAction(Actions.fadeOut(0.9f));
    }

    private void bg0() {
        Image image = new Image(Asset.getAsset().getTexture("bg.png"));
        addActor(image);
        Wd1 group = new Wd1(image.getWidth(),image.getHeight());
//        addActor(group);

        Wd11 wd11 = new Wd11(image.getWidth(),image.getHeight());
        addActor(wd11);
        wd11.setY(image.getY(Align.top)+190,Align.top);
        wd11.setX(image.getWidth()/2,Align.center);
    }

    private void bg6(){
        Image image = new Image(Asset.getAsset().getTexture("bg.png"));
        addActor(image);
        Image yuan = new Image(Asset.getAsset().getTexture("Soft.png"));
        addActor(yuan);
        yuan.setSize(image.getHeight(),image.getHeight());
        yuan.setPosition(image.getWidth()/2,image.getHeight()/2,Align.center);
        yuan.setY(150);
        yuan.setOrigin(Align.center);
        yuan.setColor(240.0F/255.0f, 217.0F/255.0f, 187.0F/255.0f,1.0f);
        yuan.setScale(1.5f);
        yuan.addAction(Actions.sequence(Actions.scaleTo(0.4f,0.4f,2.7f),
                Actions.fadeOut(0.5f)
        ));
        BgGroup2 noise = new BgGroup2(image.getWidth(),400);
        addActor(noise);
    }


    private void pre() {
        GrayImage grayImage = new GrayImage();
        addActor(grayImage);

    }

    private void bg7() {
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
