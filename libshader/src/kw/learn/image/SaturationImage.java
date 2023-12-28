package kw.learn.image;

import kw.learn.base.BaseImage;

/**
 * @Auther jian xian si qi
 * @Date 2023/12/28 10:23
 */
public class SaturationImage extends BaseImage {
    public SaturationImage(){
        frangShader = pre +"saturation.glsl";
    }

    @Override
    protected void setArgs() {
        super.setArgs();
        setUniformTime("saturation");
    }
}
