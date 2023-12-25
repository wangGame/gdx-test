package com.tony.shader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class AllTest extends Group {
    private ShaderProgram program;
    public AllTest(Texture texture){

        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/lumin.glsl"));
        }
        System.out.println("-------------------");

        Image image = new Image(texture){
            private float time = 0.2f;
            @Override
            public void act(float delta) {
                super.act(delta);
//                time += delta;
            }

            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                int time1 = program.getUniformLocation("threshold");
                program.setUniformf(time1,time);
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };

        image.setSize(300,300);
        addActor(image);
        setSize(300,300);
    }

}
