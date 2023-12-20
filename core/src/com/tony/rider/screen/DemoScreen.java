package com.tony.rider.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import com.tony.rider.DivideGroup;
import com.tony.rider.TipBg;
import com.tony.rider.TipBgPatch;
import com.tony.rider.actor.BlackGroup;
import com.tony.rider.actor.WaveImage;
import com.tony.rider.android.xise.XIseutils;
import com.tony.rider.asset.Asset;
import com.tony.rider.constant.Constant;
import com.tony.rider.group.ClipTest;
import com.tony.rider.group.SiJaGroup;
import com.tony.rider.group.SiJaGroup1;
import com.tony.rider.mdel.ModelGroupTest;
import com.tony.rider.screen.base.BaseScreen;

public class DemoScreen extends BaseScreen {
    private ShaderProgram program;
    Image showImg = null;
    Pixmap colorAtPixel;
    @Override
    public void show() {
        super.show();
        sijiao();
        Image image = new Image(Asset.getAsset().getTexture("white_bg.png"));
        addActor(image);
        image.setSize(50,50);
        image.setPosition(500,1000);
        stage.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                if (showImg == null) {
                    colorAtPixel = XIseutils.getColorAtPixel((int) x, (int) y);
//                System.out.println(colorAtPixel);
//                image.setColor(colorAtPixel);
//                actor.setSize();
                    TextureRegion region = new TextureRegion(new Texture(colorAtPixel));
                    region.flip(false,true);
                    showImg = new Image(region);
//                    addActor(showImg);
                }
            }

            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                super.touchDragged(event, x, y, pointer);
                if (colorAtPixel!=null){
                    int width = Gdx.graphics.getWidth();
                    System.out.println(width+"   "+Constant.GAMEWIDTH);
                    float v = width / Constant.GAMEWIDTH;
                    int pixel = colorAtPixel.getPixel((int)(x * v), (int)(y*v));
                    Color color = new Color();
                    Color.rgba8888ToColor(color, pixel);
                    image.setColor(color);
                }
            }
        });
//        {
//            Image image = new Image(Asset.getAsset().getTexture("maskcir.png"));
//            addActor(image);
//            image.setOrigin(Align.top);
//            image.setPosition(100,500);
//        }
//
//        {
//            Image image = new Image(Asset.getAsset().getTexture("maskcir.png"));
//            addActor(image);
//            image.setOrigin(Align.top);
//            image.setHeight(5000);
//            image.setPosition(500,500);
//
//        }






//        BlackGroup group = new BlackGroup("maskcir.png");
//        addActor(group);
//        addActor(new WaveImage(Asset.getAsset().getTexture("00002.png")));
//        exposure();
//        contract(); //2
//        gamma();//3
//        colorInvert();//4
//        pix();//5
//        hue();
//        bright();
//        grayScale();//8
//        sepia();
//        sharpen();//10
//        edge();
//        tholdEdge();//
//        threeXthree(); //1
//        emboss();
//        poster();
//        filterGroup();
//        saturation();//15
//        exposure();
//        highlightShadow();
//        monchrome();//18
//        opacity();  //19
//        rgb();
//        whiteBalance();
//        vignette();
//        lumin();
//        All();
//        blendDifference();
//        blendSourceOver();//21
//        blendburnblend();
//        blendColorDoge();
//        blendDarken();

//        blendDissolve();

//        blendexcusion();

//        hightLight();
//        highten();

//        add();//

//        divide();
//        divide1();

//        muli(); //31
//        overlay();

//        screen();
//        alpha();
//        color();
//        hue2();//36
//        saturation2();
//        blendluminosity();
//        blendLinearBurn();
//        blendsoftlight();

//        blendsubtract();
//        blendChromeKeyBlend();
//        blendNoneBlend();


//        amatorka();
//        crosshatch();
//        colorspace();
//        imageSketch();

    // 未作
//        gaussianblur();
//        boxblur();
//        dilation();
//        kuwahare();
//        rgbdilation();
//        imageSketch();
//        GPUImageToonFilter
//        imageSketch();
//        test01();
//        imageSketch();
//        qufan();
//        cir();
//        ccx();

//        cir111();
//        pix();

//        ModelGroupTest test = new ModelGroupTest();
//        stage.addActor(test);
//        ClipTest test = new ClipTest();
//        addActor(test);
//        test.addAction(
//                Actions.sequence(
//                        Actions.moveToAligned(300,300, Align.center,4.3f),
//                        Actions.moveToAligned(100,300, Align.center,4.3f),
//                        Actions.moveToAligned(300,100, Align.center,4.3f),
//                        Actions.moveToAligned(800,800, Align.center,4.3f)));


//
//        SiJaGroup1 siJaGroup = new SiJaGroup1();
//        addActor(siJaGroup);
//        siJaGroup.setScale(0.8f);

//        TipBg tipBg = new TipBg();
//        stage.addActor(tipBg);



    }

    public void sijiao(){
        SiJaGroup1 siJaGroup = new SiJaGroup1();
        addActor(siJaGroup);
        siJaGroup.setScale(0.8f);
    }

    private void cir111() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("colormap/line.vert"),
                    Gdx.files.internal("colormap/line.frag"));
        }

        Table table = new Table(){{
            FileHandle internal = Gdx.files.internal("ss");

            for (FileHandle fileHandle : internal.list()) {
                Image image = new Image(Asset.getAsset().getTexture("ss/"+fileHandle.name())){
                    @Override
                    public void draw(Batch batch, float parentAlpha) {
                        batch.setShader(program);
                        super.draw(batch, parentAlpha);
                        batch.setShader(null);
                    }
                };
                image.setX(11);
                image.setSize(2100,2100);
                image.setX(100);
                add(image).pad(10);

            }
            pack();
        }};

        ScrollPane pane = new ScrollPane(table);
        addActor(pane);
        pane.setSize(Constant.GAMEWIDTH,Constant.GAMEHIGHT);
    }


    private void ccx() {
        Image image1 = new Image(Asset.getAsset().getTexture("maskcir.png"));
        addActor(image1);
        Image image = new Image(Asset.getAsset().getTexture("democir.jpg")){
            private float time = 20;
            @Override
            public void act(float delta) {
                super.act(delta);

            }

            @Override
            public void draw(Batch batch, float parentAlpha) {
                int blendSrcFunc = batch.getBlendSrcFunc();
                int blendDstFunc = batch.getBlendDstFunc();
                batch.setBlendFunction(GL20.GL_ONE,GL20.GL_ZERO);
                super.draw(batch, parentAlpha);
                batch.setBlendFunction(blendSrcFunc,blendDstFunc);
            }
        };
        image.setX(11);
        image.setSize(1100,1100);
        addActor(image);
    }

    private void cir() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/cir.glsl"));
        }

        Texture texture = new Texture("maskcir.png");
        Texture kkk = new Texture("daily_img_border.png");
        Image image = new Image(Asset.getAsset().getTexture("democir.jpg")){
            private float time = 20;
            @Override
            public void act(float delta) {
                super.act(delta);

            }

            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                int u_texture1 = program.getUniformLocation("u_texture1");
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE1);
                texture.bind();
                program.setUniformi(u_texture1,1);
                int u_texture2 = program.getUniformLocation("u_texture2");
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE2);
                kkk.bind();
                program.setUniformi(u_texture2,2);
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);

                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        image.setX(11);
        image.setSize(1100,1100);
        addActor(image);
    }

    private void All() {

    }

    private void qufan() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/dip.glsl"));
        }


        Image image = new Image(Asset.getAsset().getTexture("test3.png")){
            private float time = 20;
            @Override
            public void act(float delta) {
                super.act(delta);
                time -= delta;
            }

            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                if (time == 0){
                    time = 0;
                }
                program.setUniformf("contrast",time);
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        image.setScale(10);
        addActor(image);

    }

    private void test01() {
        if (program == null){
            program = new ShaderProgram(
                    Gdx.files.internal("test/grayScale.glsl"),
                    Gdx.files.internal("test/txt.vert"));
        }


        Image image = new Image(Asset.getAsset().getTexture("_floor-58868.png")){
            private float time;
            @Override
            public void act(float delta) {
                super.act(delta);
                time += delta;
            }

            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        addActor(image);

    }

    public void test1(){

    }

    private void imageSketch() {

        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/sketch.glsl"));
        }

        Image image = new Image(Asset.getAsset().getTexture("reee.png")){
            float time01 = 0;
            @Override
            public void act(float delta) {
                super.act(delta);
                time01 += delta;
            }

            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                super.draw(batch, parentAlpha);
                program.setUniformf("time",time01);
                batch.setShader(null);
            }
        };
        addActor(image);
    }

    private void colorspace() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/colorSpace.glsl"));
        }

        Image image = new Image(Asset.getAsset().getTexture("_floor-58868.png")){

            @Override
            public void act(float delta) {
                super.act(delta);

            }

            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        addActor(image);
    }

    private void crosshatch() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/crosshatch.glsl"));
        }

        Image image = new Image(Asset.getAsset().getTexture("_floor-58868.png")){
            private float time;
            @Override
            public void act(float delta) {
                super.act(delta);
                time += delta;
            }

            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        addActor(image);

    }

    private void gaussianblur() {
    }

    private void amatorka() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/amatorka.glsl"));
        }
        Texture texture = Asset.getAsset().getTexture("lookup_amatorka.png");
        Image image = new Image(Asset.getAsset().getTexture("test.png")){
            float time = 0;
            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                int u_texture1 = program.getUniformLocation("u_texture1");
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE1);
                texture.bind();
                int intensity = program.getUniformLocation("intensity");
                program.setUniformf(intensity,time*0.1F);
                program.setUniformi(u_texture1,1);
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);
                super.draw(batch, parentAlpha);
                batch.setShader(null);
                time += Gdx.graphics.getDeltaTime();
            }
        };
        addActor(image);
    }


    private void blendNoneBlend() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/blendNone.glsl"));
        }
        Texture texture = Asset.getAsset().getTexture("sprite.png");
        Image image = new Image(Asset.getAsset().getTexture("test.png")){
            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                int u_texture1 = program.getUniformLocation("u_texture1");
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE1);
                texture.bind();
                program.setUniformi(u_texture1,1);
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        addActor(image);
    }


    private void blendChromeKeyBlend() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/blendchroma.glsl"));
        }
        Texture texture = Asset.getAsset().getTexture("sprite.png");
        Image image = new Image(Asset.getAsset().getTexture("test.png")){
            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                int u_texture1 = program.getUniformLocation("u_texture1");
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE1);
                texture.bind();
                program.setUniformi(u_texture1,1);
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        addActor(image);
    }

    private void blendsubtract() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/blendsubtract.glsl"));
        }
        Texture texture = Asset.getAsset().getTexture("sprite.png");
        Image image = new Image(Asset.getAsset().getTexture("test.png")){
            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                int u_texture1 = program.getUniformLocation("u_texture1");
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE1);
                texture.bind();
                program.setUniformi(u_texture1,1);
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        addActor(image);
    }


    private void blendsoftlight(){
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/blendsoftlight.glsl"));
        }
        Texture texture = Asset.getAsset().getTexture("no_bg.png");
        Image image = new Image(Asset.getAsset().getTexture("test.png")){
            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                int u_texture1 = program.getUniformLocation("u_texture1");
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE1);
                texture.bind();
                program.setUniformi(u_texture1,1);
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        addActor(image);
    }

    private void blendLinearBurn(){
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/blendlinearburn.glsl"));
        }
        Texture texture = Asset.getAsset().getTexture("no_bg.png");
        Image image = new Image(Asset.getAsset().getTexture("test.png")){
            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                int u_texture1 = program.getUniformLocation("u_texture1");
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE1);
                texture.bind();
                program.setUniformi(u_texture1,1);
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        addActor(image);
    }

    private void blendluminosity() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/blendluminosity.glsl"));
        }
        Texture texture = Asset.getAsset().getTexture("sprite.png");
        Image image = new Image(Asset.getAsset().getTexture("test.png")){
            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                int u_texture1 = program.getUniformLocation("u_texture1");
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE1);
                texture.bind();
                program.setUniformi(u_texture1,1);
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        addActor(image);
    }


    private void saturation2() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/blendsturation.glsl"));
        }
        Texture texture = Asset.getAsset().getTexture("sprite.png");
        Image image = new Image(Asset.getAsset().getTexture("test.png")){
            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                int u_texture1 = program.getUniformLocation("u_texture1");
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE1);
                texture.bind();
                program.setUniformi(u_texture1,1);
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        addActor(image);
    }

    private void vignette() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/vignette.glsl"));
        }

        Image image = new Image(Asset.getAsset().getTexture("_floor-58868.png")){
            private float time;
            @Override
            public void act(float delta) {
                super.act(delta);
                time += delta;
            }

            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        addActor(image);
    }


    private void rgb() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/rgb.frag"));
        }

        Image image = new Image(Asset.getAsset().getTexture("_floor-58868.png")){
            private float time;
            @Override
            public void act(float delta) {
                super.act(delta);
                time += delta;
            }

            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                int r = program.getUniformLocation("r");
                int g = program.getUniformLocation("g");
                int b = program.getUniformLocation("b");
                float xx = 0.1F;
                program.setUniformf(r,time * xx);
                program.setUniformf(g,time * xx);
                program.setUniformf(b,time * xx);
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        addActor(image);
    }

    private void emboss() {
        //对 3x3改变了一下 摸具   改变了一下 intensity
    }

    private void lumin() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/lumin.glsl"));
        }

        Image image = new Image(Asset.getAsset().getTexture("test3.png")){
            private float time;
            @Override
            public void act(float delta) {
                super.act(delta);

            }

            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                int time1 = program.getUniformLocation("threshold");
                program.setUniformf(time1,0.5F);
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        image.setScale(4);
        image.addAction(Actions.fadeIn(1.4f));
        addActor(image);
    }


    private void hue2() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/blendhue.glsl"));
        }
        Texture texture = Asset.getAsset().getTexture("no_bg.png");
        Image image = new Image(Asset.getAsset().getTexture("test.png")){
            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                int u_texture1 = program.getUniformLocation("u_texture1");
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE1);
                texture.bind();
                program.setUniformi(u_texture1,1);
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        addActor(image);
    }



    private void color() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/blendcolor.glsl"));
        }
        Texture texture = Asset.getAsset().getTexture("no_bg.png");
        Image image = new Image(Asset.getAsset().getTexture("test.png")){
            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                int u_texture1 = program.getUniformLocation("u_texture1");
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE1);
                texture.bind();
                program.setUniformi(u_texture1,1);
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        addActor(image);
    }


    private void alpha() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/blendalpha.glsl"));
        }
        Texture texture = Asset.getAsset().getTexture("no_bg.png");
        Image image = new Image(Asset.getAsset().getTexture("test.png")){
            float time = 0;
            @Override
            public void draw(Batch batch, float parentAlpha) {
                time += Gdx.graphics.getDeltaTime();
                batch.setShader(program);
                int u_texture1 = program.getUniformLocation("u_texture1");
                int mixturePercent = program.getUniformLocation("mixturePercent");
                program.setUniformf(mixturePercent,time);
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE1);
                texture.bind();
                program.setUniformi(u_texture1,1);
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        addActor(image);
    }


    private void screen() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/blendscreen.glsl"));
        }
        Texture texture = Asset.getAsset().getTexture("no_bg.png");
        Image image = new Image(Asset.getAsset().getTexture("test.png")){
            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                int u_texture1 = program.getUniformLocation("u_texture1");
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE1);
                texture.bind();
                program.setUniformi(u_texture1,1);
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        addActor(image);
    }


    private void overlay() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/blendOverlay.glsl"));
        }
        Texture texture = Asset.getAsset().getTexture("no_bg.png");
        Image image = new Image(Asset.getAsset().getTexture("test.png")){
            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                int u_texture1 = program.getUniformLocation("u_texture1");
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE1);
                texture.bind();
                program.setUniformi(u_texture1,1);
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        addActor(image);
    }


    private void muli() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/blendmuli.glsl"));
        }
        Texture texture = Asset.getAsset().getTexture("no_bg.png");
        Image image = new Image(Asset.getAsset().getTexture("test.png")){
            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                int u_texture1 = program.getUniformLocation("u_texture1");
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE1);
                texture.bind();
                program.setUniformi(u_texture1,1);
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        addActor(image);
    }
    private void divide1() {
//        FileHandle sprite1 = Gdx.files.internal("sprite1");
//        addActor(new Table(){{
//            int index = 0;
//            for (int i = 0; i < 10; i++) {
//                index ++;
//                FileHandle fileHandle = sprite1.list()[i];
//                DivideGroup group = new DivideGroup(fileHandle);
//                add(group);
//                if (index>5){
//                    row();
//                    index = 0;
//                }
//            }
//            pack();
//        }});
//        Asset/Demo01/whale1-22754.png
          DivideGroup group = new DivideGroup(Gdx.files.internal("ziti1.png"));
          addActor(group);
          group.setScale(4);

    }
    private void divide() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/blendDivide.glsl"));
        }
        Texture texture = Asset.getAsset().getTexture("no_bg.png");
        Image image = new Image(Asset.getAsset().getTexture("xxxxxx.png")){
            float time = 0;
            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                int u_texture1 = program.getUniformLocation("u_texture1");
                int time1 = program.getUniformLocation("time");
                program.setUniformf(time1,time);
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE1);
                texture.bind();
                program.setUniformi(u_texture1,1);
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);
                super.draw(batch, parentAlpha);
                batch.setShader(null);
                time += Gdx.graphics.getDeltaTime();
            }
        };
        addActor(image);

    }


    private void add() {

        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/blendAdd.glsl"));
        }
        Texture texture = Asset.getAsset().getTexture("no_bg.png");
        Image image = new Image(Asset.getAsset().getTexture("test.png")){
            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                int u_texture1 = program.getUniformLocation("u_texture1");
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE1);
                texture.bind();
                program.setUniformi(u_texture1,1);
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        addActor(image);


    }

    private void highten() {

        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/blendlighten.glsl"));
        }
        Texture texture = Asset.getAsset().getTexture("no_bg.png");
        Image image = new Image(Asset.getAsset().getTexture("test.png")){
            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                int u_texture1 = program.getUniformLocation("u_texture1");
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE1);
                texture.bind();
                program.setUniformi(u_texture1,1);
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        addActor(image);


    }

    public void hightLight(){

        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/blendhightlight.glsl"));
        }
        Texture texture = Asset.getAsset().getTexture("no_bg.png");
        Image image = new Image(Asset.getAsset().getTexture("test.png")){
            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                int u_texture1 = program.getUniformLocation("u_texture1");
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE1);
                texture.bind();
                program.setUniformi(u_texture1,1);
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        addActor(image);

    }

    private void blendexcusion() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/blendexcusion.glsl"));
        }
        Texture texture = Asset.getAsset().getTexture("no_bg.png");
        Image image = new Image(Asset.getAsset().getTexture("test.png")){
            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                int u_texture1 = program.getUniformLocation("u_texture1");
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE1);
                texture.bind();
                program.setUniformi(u_texture1,1);
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        addActor(image);
    }



    private void blendDissolve() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/blendDissolve.glsl"));
        }
        Texture texture = Asset.getAsset().getTexture("no_bg.png");
        Image image = new Image(Asset.getAsset().getTexture("test.png")){
            private float time = 0;
            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                int x = program.getUniformLocation("time");
                program.setUniformf(x,time*0.1f);
                int u_texture1 = program.getUniformLocation("u_texture1");
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE1);
                texture.bind();
                program.setUniformi(u_texture1,1);
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);
                super.draw(batch, parentAlpha);
                this.time += Gdx.graphics.getDeltaTime();
                batch.setShader(null);
            }
        };
        addActor(image);
    }


    private void blendDarken() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/blendblenddarken.glsl"));
        }
        Texture texture = Asset.getAsset().getTexture("no_bg.png");
        Image image = new Image(Asset.getAsset().getTexture("test.png")){
            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                int u_texture1 = program.getUniformLocation("u_texture1");
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE1);
                texture.bind();
                program.setUniformi(u_texture1,1);
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        addActor(image);
    }


    private void blendColorDoge() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/blendColorDodge.glsl"));
        }
        Texture texture = Asset.getAsset().getTexture("no_bg.png");
        Image image = new Image(Asset.getAsset().getTexture("test.png")){
            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                int u_texture1 = program.getUniformLocation("u_texture1");
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE1);
                texture.bind();
                program.setUniformi(u_texture1,1);
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        addActor(image);
    }


    private void blendburnblend() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/blendcolorburnblend.glsl"));
        }
        Texture texture = Asset.getAsset().getTexture("no_bg.png");
        Image image = new Image(Asset.getAsset().getTexture("test.png")){
            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                int u_texture1 = program.getUniformLocation("u_texture1");
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE1);
                texture.bind();
                program.setUniformi(u_texture1,1);
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        addActor(image);
    }


    private void blendSourceOver() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/blendsourceover.glsl"));
        }
        Texture texture = Asset.getAsset().getTexture("test.png");
        Image image = new Image(Asset.getAsset().getTexture("no_bg.png")){
            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                int u_texture1 = program.getUniformLocation("u_texture1");
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE1);
                texture.bind();
                program.setUniformi(u_texture1,1);
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        addActor(image);
    }

    private void blendDifference() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/blenddifference.glsl"));
        }
        Texture texture = Asset.getAsset().getTexture("no_bg.png");
        Image image = new Image(Asset.getAsset().getTexture("test.png")){
            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                int u_texture1 = program.getUniformLocation("u_texture1");
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE1);
                texture.bind();
                program.setUniformi(u_texture1,1);
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        addActor(image);
    }

    public void whiteBalance(){
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/whitebalance.glsl"));
        }
        Image image = new Image(Asset.getAsset().getTexture("test.png")){
            float time = 0;
            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                int temperature = program.getUniformLocation("temperature");
                int tint = program.getUniformLocation("tint");
                program.setUniformf(temperature,5000);
                program.setUniformf(tint,time*0.5F);
                super.draw(batch, parentAlpha);
                time += Gdx.graphics.getDeltaTime();
                batch.setShader(null);
            }
        };
        addActor(image);
    }

    private void opacity() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/opactity.glsl"));
        }

        Image image = new Image(Asset.getAsset().getTexture("test.png")){
            float time = 0;
            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                int shadows = program.getUniformLocation("opacity");
                program.setUniformf(shadows,time);
                super.draw(batch, parentAlpha);
                time += Gdx.graphics.getDeltaTime();
                batch.setShader(null);
            }
        };
        addActor(image);
    }

    private void monchrome() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/monochrome.glsl"));
        }

        Image image = new Image(Asset.getAsset().getTexture("test.png")){
            float time = 0;
            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                int shadows = program.getUniformLocation("intensity");
                program.setUniformf(shadows,time);
                super.draw(batch, parentAlpha);
                time += Gdx.graphics.getDeltaTime();
                batch.setShader(null);
            }
        };
        addActor(image);
    }


    private void highlightShadow() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/highlightShadow.glsl"));
        }

        Image image = new Image(Asset.getAsset().getTexture("test.png")){
            float time = 0;
            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                int shadows = program.getUniformLocation("highlights");
                program.setUniformf(shadows,time);
                super.draw(batch, parentAlpha);
                time += Gdx.graphics.getDeltaTime();
                batch.setShader(null);
            }
        };
        addActor(image);
    }



    private void exposure() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/exposure.glsl"));
        }

        Image image = new Image(Asset.getAsset().getTexture("test0120.png")){

            @Override
            public void act(float delta) {
                super.act(delta);
            }

            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                program.setUniformf("exposure",1.0f);
                program.setUniformf("offset",-0.03f);
//                program.setUniformf("gamma",3.0f);

                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        addActor(image);
        Image image1 = new Image(Asset.getAsset().getTexture("test0120.png"));
        addActor(image1);
        image1.setPosition(400,0);
        Image image2 = new Image(Asset.getAsset().getTexture("test1221.png"));
        addActor(image2);
        image2.setPosition(400,400);
    }

    private void saturation() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/saturation.glsl"));
        }
        Image image = new Image(Asset.getAsset().getTexture("test.png")){
            private float time;
            @Override
            public void act(float delta) {
                super.act(delta);
                time += delta;
            }

            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                int time1 = program.getUniformLocation("saturation");
                program.setUniformf(time1,time*0.1F);
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        addActor(image);
    }

    private void filterGroup() {
        //比较简单 ，就不演示了
    }

    private void poster() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/poster.glsl"));
        }

        Image image = new Image(Asset.getAsset().getTexture("test.png")){
            private float time;
            @Override
            public void act(float delta) {
                super.act(delta);
                time += delta;
            }

            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                int time1 = program.getUniformLocation("colorLevels");
                program.setUniformf(time1,time*0.1F);
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        addActor(image);

    }


    private void tholdEdge() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/threohold.glsl"));
        }

        Image image = new Image(Asset.getAsset().getTexture("round64_38.png")){
            private float time;
            @Override
            public void act(float delta) {
                super.act(delta);
                time += delta;
            }

            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                int time1 = program.getUniformLocation("threshold");
                program.setUniformf(time1,0.5f);
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        addActor(image);
    }


    private void edge() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/edge.glsl"));
        }

        Image image = new Image(Asset.getAsset().getTexture("round64_38.png")){

            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        addActor(image);
    }

    private void sharpen() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/sharpen.frag"));
        }

        Image image = new Image(Asset.getAsset().getTexture("test.png")){
            private float time;
            @Override
            public void act(float delta) {
                super.act(delta);
                time += delta;
            }

            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                int time1 = program.getUniformLocation("time");
                program.setUniformf(time1,time);
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        addActor(image);
    }

    private void sepia() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/sepia.glsl"));
        }

        Image image = new Image(Asset.getAsset().getTexture("test.png")){
            private float time;
            @Override
            public void act(float delta) {
                super.act(delta);
                time += delta;
            }

            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                int time1 = program.getUniformLocation("intensity");
                program.setUniformf(time1,time);
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        addActor(image);

    }

    private void grayScale() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/grayscale.glsl"));
        }

        Image image = new Image(Asset.getAsset().getTexture("test.png")){
            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        addActor(image);

    }

    private void bright() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/brightness.glsl"));
        }

        Image image = new Image(Asset.getAsset().getTexture("_cat-58830.png")){
            private float time;
            @Override
            public void act(float delta) {
                super.act(delta);
                time += delta * 0.3f;
            }

            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                int time1 = program.getUniformLocation("contrast");
                program.setUniformf(time1,time);
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        addActor(image);
    }

    private void hue() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/hue.glsl"));
        }

        Image image = new Image(Asset.getAsset().getTexture("test.png")){
            private float time;
            @Override
            public void act(float delta) {
                super.act(delta);
                time += delta;
            }

            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                int time1 = program.getUniformLocation("time");
                program.setUniformf(time1,time);
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        addActor(image);
    }


    private void pix() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/pix.glsl"));
        }

        Image image = new Image(Asset.getAsset().getTexture("test.png")){
            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        addActor(image);
    }


    private void colorInvert() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/converinvert.glsl"));
        }

        Image image = new Image(Asset.getAsset().getTexture("test.png")){
            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        addActor(image);
    }

    private void gamma() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/gamma.glsl"));
        }
        Image image = new Image(Asset.getAsset().getTexture("11111.png")){
            float time = 0;
            @Override
            public void act(float delta) {
                super.act(delta);
                time += delta;
            }

            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                int contrast = program.getUniformLocation("gamma");
                program.setUniformf(contrast,time*0.6F);
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        addActor(image);
    }

    private void contract() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/contrast.frag"));
        }
        Image image = new Image(Asset.getAsset().getTexture("11111.png")){
            float time = 0;
            @Override
            public void act(float delta) {
                super.act(delta);
                time += delta;
            }

            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                int contrast = program.getUniformLocation("contrast");
                program.setUniformf(contrast,time);
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        addActor(image);
    }

    private void threeXthree() {
        Image image = new Image(Asset.getAsset().getTexture("test.png")){
            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        addActor(image);
    }
}
