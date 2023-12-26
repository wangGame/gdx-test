package kw.learn.image;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import kw.learn.base.BaseGroup;

public class ExpuseImage extends BaseGroup {
    public ExpuseImage(){
        this.vertShader = "realseshader/common.vert";
        this.frangShader = "realseshader/exposure.glsl";
    }

//0.317f   1.0354009
    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.setShader(program);
        program.setUniformf("exposure",2);
        program.setUniformf("offset",0.4f);
        super.draw(batch, parentAlpha);
        batch.setShader(null);
    }
}
