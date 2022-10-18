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
//        threeXthree();
//        contract();
//        gamma();
//        colorInvert();
//        pix();
//        hue();
//        bright();
//        grayScale();
        sepia();
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
