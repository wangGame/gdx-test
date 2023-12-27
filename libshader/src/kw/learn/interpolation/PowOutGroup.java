package kw.learn.interpolation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;

public class PowOutGroup extends BaseGroup{
    public PowOutGroup(){
        program = new ShaderProgram(
                Gdx.files.internal("mathline/txt.vert"),
                Gdx.files.internal("mathline/powOut.frag")
        );
    }

    @Override
    protected void extendsMethod() {
        super.extendsMethod();
        program.setUniformf("pww",2.0f);
    }
}
