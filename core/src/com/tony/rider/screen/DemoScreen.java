package com.tony.rider.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.tony.rider.asset.Asset;
import com.tony.rider.screen.base.BaseScreen;

public class DemoScreen extends BaseScreen {
    private ShaderProgram program;
    @Override
    public void show() {
        super.show();
//        threeXthree(); //1
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
//        poster();
//        filterGroup();
//        saturation();//15
//        exposure();
//        highlightShadow();
//        monchrome();//18

//        opacity();  //19

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
//        muli(); //31
//        overlay();

//        screen();
//        alpha();
//        color();
//        hue2();//36
        lumin();
    }

    private void lumin() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/lumin.glsl"));
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
                int time1 = program.getUniformLocation("threshold");
                program.setUniformf(time1,time*0.3F);
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
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

    private void divide() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/blendDivide.glsl"));
        }
        Texture texture = Asset.getAsset().getTexture("no_bg.png");
        Image image = new Image(Asset.getAsset().getTexture("test.png")){
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
                program.setUniformf(x,time);
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

    public void whiteBalance(){}

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
        Image image = new Image(Asset.getAsset().getTexture("1234.png")){
            private float time;
            @Override
            public void act(float delta) {
                super.act(delta);
                time += delta;
            }

            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                int time1 = program.getUniformLocation("exposure");
                program.setUniformf(time1,time*0.1F);
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        addActor(image);
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
                int time1 = program.getUniformLocation("threshold");
                program.setUniformf(time1,time*0.01F);
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
                program.setUniformf(time1,0);
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
        Image image = new Image(Asset.getAsset().getTexture("test.png")){
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
                program.setUniformf(contrast,time*0.1F);
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
        Image image = new Image(Asset.getAsset().getTexture("test.png")){
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
