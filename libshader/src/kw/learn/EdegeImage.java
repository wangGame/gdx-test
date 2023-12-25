package kw.learn;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import kw.learn.base.BaseGroup;

public class EdegeImage extends BaseGroup {

    private float coefficient;
    private float offset;

    public EdegeImage(){
        this.coefficient = 1.0f;
        this.offset = 0.03f;
        this.vertShader = "realseshader/common.vert";
        this.frangShader = "realseshader/edge.glsl";
    }

    @Override
    protected void setArgs() {
        super.setArgs();
        program.setUniformf("coefficient",coefficient);
        program.setUniformf("offset",offset);
    }
}
