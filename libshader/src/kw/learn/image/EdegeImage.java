package kw.learn.image;

import kw.learn.base.BaseImage;

public class EdegeImage extends BaseImage {

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
