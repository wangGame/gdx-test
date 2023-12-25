package com.tony.shader.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Solarize extends Image {
    private ShaderProgram program;
    private float timeDelta;
    public Solarize(Texture texture){
        super(texture);
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                    Gdx.files.internal("shader/solarize.glsl"));
        }
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        timeDelta += 0.0167f;

    }
    //0.317f   1.0354009
    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.setShader(program);
        int time = program.getUniformLocation("time");
        program.setUniformf(time,timeDelta);
        super.draw(batch, parentAlpha);
        batch.setShader(null);
    }
}
