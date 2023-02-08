package com.tony.rider.interpolation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;

public class Pow2InInverseGroup extends BaseGroup{
    public Pow2InInverseGroup(){
        program = new ShaderProgram(
                Gdx.files.internal("mathline/txt.vert"),
                Gdx.files.internal("mathline/powInInverse.frag")
        );
    }

    @Override
    protected void extendsMethod() {
        super.extendsMethod();
        program.setUniformf("pww",2.0f);
    }
}
