package com.tony.rider.screen;

import com.badlogic.gdx.Gdx;
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
//
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
            float xxx = 0;
            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                int xzxxx = program.getUniformLocation("xxx");
                program.setUniformf(xzxxx,xxx);
                super.draw(batch, parentAlpha);
                xxx += Gdx.graphics.getDeltaTime();
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
