package kw.learn.interpolation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;

public class SmoothGroup extends BaseGroup {
    public SmoothGroup(){
        program = new ShaderProgram(
                Gdx.files.internal("mathline/txt.vert"),
                Gdx.files.internal("mathline/smooth.frag")
        );
    }
}
