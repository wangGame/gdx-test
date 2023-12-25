package com.tony.shader.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.kw.gdx.BaseGame;
import com.kw.gdx.screen.BaseScreen;
import com.tony.shader.asset.Asset;

public class Transform extends BaseScreen {
    private ShaderProgram program;

    public Transform(BaseGame game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();
//        ceshi();
//        yidong();
//        fanshu();
//        fanzhuan();
//        move2();
//        halfmove();
//        wipeUp();
//        wipeRight();
        wipeCir();
    }

    private void wipeCir() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("transform/wipe_cir/vert.vert"),
                    Gdx.files.internal("transform/wipe_cir/wipeUp.glsl"));
        }
        Texture texture = Asset.getAsset().getTexture("test.png");
        texture.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);
        Texture texture1 = Asset.getAsset().getTexture("sprite.png");
        Image image = new Image(texture){
            float time = 0;
            @Override
            public void act(float delta) {
                super.act(delta);
                time += Gdx.graphics.getDeltaTime();
            }

            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                int moveLeft = program.getUniformLocation("time");


                int u_texture1 = program.getUniformLocation("u_texture1");
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE1);
                texture1.bind();
                program.setUniformi(u_texture1,1);
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);
                program.setUniformf(moveLeft,(float) Math.abs(Math.sin(time)));
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        addActor(image);
    }


    private void wipeRight() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("transform/wipe_right/vert.vert"),
                    Gdx.files.internal("transform/wipe_right/wipeUp.glsl"));
        }
        Texture texture = Asset.getAsset().getTexture("test.png");
        texture.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);

        Texture texture1 = Asset.getAsset().getTexture("sprite.png");
        Image image = new Image(texture){
            float time = 0;
            @Override
            public void act(float delta) {
                super.act(delta);
                time += Gdx.graphics.getDeltaTime();
            }

            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                int moveLeft = program.getUniformLocation("time");


                int u_texture1 = program.getUniformLocation("u_texture1");
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE1);
                texture1.bind();
                program.setUniformi(u_texture1,1);
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);
                program.setUniformf(moveLeft,(float) Math.abs(Math.sin(time)));
//                if (time*0.1>=1F){
//                    program.setUniformf(moveLeft,1);
//                }else {
//                    program.setUniformf(moveLeft,time*0.1F);
//                }
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        addActor(image);
    }


    private void wipeRightDown() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("transform/wipe_right_down/vert.vert"),
                    Gdx.files.internal("transform/wipe_right_down/wipeUp.glsl"));
        }
        Texture texture = Asset.getAsset().getTexture("test.png");
        texture.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);

        Texture texture1 = Asset.getAsset().getTexture("sprite.png");
        Image image = new Image(texture){
            float time = 0;
            @Override
            public void act(float delta) {
                super.act(delta);
                time += Gdx.graphics.getDeltaTime();
            }

            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                int moveLeft = program.getUniformLocation("time");


                int u_texture1 = program.getUniformLocation("u_texture1");
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE1);
                texture1.bind();
                program.setUniformi(u_texture1,1);
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);
                program.setUniformf(moveLeft,(float) Math.abs(Math.sin(time)));
//                if (time*0.1>=1F){
//                    program.setUniformf(moveLeft,1);
//                }else {
//                    program.setUniformf(moveLeft,time*0.1F);
//                }
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        addActor(image);
    }

    public void wipeUp(){
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("transform/wipe_up/vert.vert"),
                    Gdx.files.internal("transform/wipe_up/wipeUp.glsl"));
        }
        Texture texture = Asset.getAsset().getTexture("test.png");
        texture.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);

        Texture texture1 = Asset.getAsset().getTexture("sprite.png");
        Image image = new Image(texture){
            float time = 0;
            @Override
            public void act(float delta) {
                super.act(delta);
                time += Gdx.graphics.getDeltaTime();
            }

            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                int moveLeft = program.getUniformLocation("time");


                int u_texture1 = program.getUniformLocation("u_texture1");
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE1);
                texture1.bind();
                program.setUniformi(u_texture1,1);
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);
                program.setUniformf(moveLeft,(float) Math.abs(Math.sin(time)));
//                if (time*0.1>=1F){
//                    program.setUniformf(moveLeft,1);
//                }else {
//                    program.setUniformf(moveLeft,time*0.1F);
//                }
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        addActor(image);
    }

    private void halfmove() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("transform/txt.vert"),
                    Gdx.files.internal("transform/halfmove.glsl"));
        }
        Texture texture = Asset.getAsset().getTexture("test.png");
        texture.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);

        Texture texture1 = Asset.getAsset().getTexture("sprite.png");
        Image image = new Image(texture){
            float time = 0;
            @Override
            public void act(float delta) {
                super.act(delta);
                time += Gdx.graphics.getDeltaTime();
            }

            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                int moveLeft = program.getUniformLocation("time");


                int u_texture1 = program.getUniformLocation("u_texture1");
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE1);
                texture1.bind();
                program.setUniformi(u_texture1,1);
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);
                program.setUniformf(moveLeft,(float) Math.abs(Math.sin(time)));
//                if (time*0.1>=1F){
//                    program.setUniformf(moveLeft,1);
//                }else {
//                    program.setUniformf(moveLeft,time*0.1F);
//                }
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        addActor(image);
    }


    private void move2() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("transform/txt.vert"),
                    Gdx.files.internal("transform/move2.glsl"));
        }
        Texture texture = Asset.getAsset().getTexture("test.png");
        texture.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);

        Texture texture1 = Asset.getAsset().getTexture("sprite.png");
        Image image = new Image(texture){
            float time = 0;
            @Override
            public void act(float delta) {
                super.act(delta);
                time += Gdx.graphics.getDeltaTime();
            }

            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                int moveLeft = program.getUniformLocation("time");


                int u_texture1 = program.getUniformLocation("u_texture1");
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE1);
                texture1.bind();
                program.setUniformi(u_texture1,1);
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);
                program.setUniformf(moveLeft,(float) Math.abs(Math.sin(time)));
//                if (time*0.1>=1F){
//                    program.setUniformf(moveLeft,1);
//                }else {
//                    program.setUniformf(moveLeft,time*0.1F);
//                }
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        addActor(image);
    }



    private void fanzhuan() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("transform/txt.vert"),
                    Gdx.files.internal("transform/fanzhuan.glsl"));
        }
        Texture texture = Asset.getAsset().getTexture("test.png");
        texture.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);

        Texture texture1 = Asset.getAsset().getTexture("sprite.png");
        Image image = new Image(texture){
            float time = 0;
            @Override
            public void act(float delta) {
                super.act(delta);
                time += Gdx.graphics.getDeltaTime();
            }

            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                int moveLeft = program.getUniformLocation("time");


                int u_texture1 = program.getUniformLocation("u_texture1");
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE1);
                texture1.bind();
                program.setUniformi(u_texture1,1);
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);
                program.setUniformf(moveLeft,(float) Math.abs(Math.sin(time)));
//                if (time*0.1>=1F){
//                    program.setUniformf(moveLeft,1);
//                }else {
//                    program.setUniformf(moveLeft,time*0.1F);
//                }
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        addActor(image);
    }



    private void fanshu() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("transform/txt.vert"),
                    Gdx.files.internal("transform/fanshu.glsl"));
        }
        Texture texture = Asset.getAsset().getTexture("test.png");
        texture.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);
        Image image = new Image(texture){
            float time = 0;
            @Override
            public void act(float delta) {
                super.act(delta);
                time += Gdx.graphics.getDeltaTime();
            }

            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                int moveLeft = program.getUniformLocation("fz");
                if (time*0.1>=1){
                    program.setUniformf(moveLeft,1);
                }else {
                    program.setUniformf(moveLeft,time*0.1F);
                }
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        addActor(image);
    }

    private void yidong() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("transform/txt.vert"),
                    Gdx.files.internal("transform/move.glsl"));
        }
        Texture texture = Asset.getAsset().getTexture("test.png");
        texture.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);
        Image image = new Image(texture){
            float time = 0;
            @Override
            public void act(float delta) {
                super.act(delta);
                time += Gdx.graphics.getDeltaTime();
            }

            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                int moveLeft = program.getUniformLocation("moveLeft");
                if (time*0.1>=1){
                    program.setUniformf(moveLeft,1);
                }else {
                    program.setUniformf(moveLeft,time*0.1F);
                }
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        addActor(image);
    }

    private void ceshi() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("transform/txt.vert"),
                    Gdx.files.internal("transform/base.glsl"));
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

}
