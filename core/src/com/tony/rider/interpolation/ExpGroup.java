package com.tony.rider.interpolation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;

public class ExpGroup extends BaseGroup{
    public ExpGroup(){
        program = new ShaderProgram(
                Gdx.files.internal("mathline/txt.vert"),
                Gdx.files.internal("mathline/exp.frag")
        );
    }

    @Override
    protected void extendsMethod() {
        super.extendsMethod();
        program.setUniformf("pww",2.0f);
    }
}
