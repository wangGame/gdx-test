package com.tony.rider;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.tony.rider.asset.Asset;

public class DivideGroup extends Group {
    private ShaderProgram program;
    public DivideGroup(FileHandle fileHandle){
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/blendDivide.glsl"));
        }
        Texture texture = Asset.getAsset().getTexture("no_bg.png");
        Image image = new Image(new Texture(fileHandle)){
            float time = 2.5f;
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
                System.out.println(time);
                time += Gdx.graphics.getDeltaTime()   ;

            }
        };
        addActor(image);
        setSize(image.getWidth(),image.getHeight());
    }
}
