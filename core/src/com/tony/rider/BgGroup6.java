package com.tony.rider;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.tony.rider.asset.Asset;

public class BgGroup6 extends Group {
    private ShaderProgram program;
    public BgGroup6() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("gamee/middlespread6.glsl"));
        }
        Texture texture = Asset.getAsset().getTexture("noise.png");
        Image image = new Image(Asset.getAsset().getTexture("bg.png")){
            private float time;

            @Override
            public void act(float delta) {
                super.act(delta);
                time += delta;
            }

            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);

                int u_texture1 = program.getUniformLocation("u_texture1");
                int timeLocation = program.getUniformLocation("time");
                program.setUniformf(timeLocation,time);
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
