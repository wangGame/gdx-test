package com.tony.rider.interpolation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;

public class SinOutGroup extends BaseGroup{
    public SinOutGroup(){
        program = new ShaderProgram(
                Gdx.files.internal("mathline/txt.vert"),
                Gdx.files.internal("mathline/sinOutfrag.frag")
        );
    }

    @Override
    protected void extendsMethod() {
        super.extendsMethod();
        program.setUniformf("pww",2.0f);
    }
}
