package kw.learn.image;

import kw.learn.base.BaseImage;

/**
 * @Auther jian xian si qi
 * @Date 2023/12/27 17:02
 */
public class SepiaImage extends BaseImage {
    public SepiaImage(){
        frangShader = pre +"sepia.glsl";
    }

    @Override
    protected void setArgs() {
        super.setArgs();
        setUniformTime("intensity");
    }
}
