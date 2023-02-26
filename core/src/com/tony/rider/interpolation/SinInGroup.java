package com.tony.rider.interpolation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;

public class SinInGroup extends BaseGroup{
    public SinInGroup(){
        program = new ShaderProgram(
                Gdx.files.internal("mathline/txt.vert"),
                Gdx.files.internal("mathline/sinInfrag.frag")
        );
    }

    @Override
    protected void extendsMethod() {
        super.extendsMethod();
        program.setUniformf("pww",2.0f);
    }
}
