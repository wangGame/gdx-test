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

public class DemoScreen05 extends BaseScreen {
    private ShaderProgram program;

    public DemoScreen05(BaseGame game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();
//        alphaOnly();
        hightLight();
    }

    private void alphaOnly() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader3/alphaOnly.vert"),
                    Gdx.files.internal("shader3/alphaOnly.frag"));
        }

//        ByteBuffer.allocate()
        Image image = new Image(Asset.getAsset().getTexture("_floor-58868.png")){
            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                int a_alpha = program.getAttributeLocation("a_alpha");

                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        addActor(image);
    }


    public void hightLight(){

        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/demo02.glsl"));
        }
        Texture texture = Asset.getAsset().getTexture("XPvTc.png");
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

}
