package kw.learn.image;

import kw.learn.base.BaseImage;

/**
 * @Auther jian xian si qi
 * @Date 2023/12/27 16:57
 */
public class BrightImage extends BaseImage {
    public BrightImage(){
        frangShader = pre +"brightness.glsl";
    }

    @Override
    protected void setArgs() {
        super.setArgs();
        setUniformTime("contrast");
    }
}
