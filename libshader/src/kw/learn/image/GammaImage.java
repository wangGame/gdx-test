package kw.learn.image;

import kw.learn.base.BaseImage;

/**
 * @Auther jian xian si qi
 * @Date 2023/12/27 16:32
 */
public class GammaImage extends BaseImage {
    public GammaImage(){
        frangShader = "realseshader/gamma.glsl";
    }

    @Override
    protected void setArgs() {
        super.setArgs();
        setUniformTime("gamma");
    }
}
