package kw.learn.image;

import kw.learn.base.BaseImage;

/**
 * @Auther jian xian si qi
 * @Date 2023/12/27 16:53
 */
public class HueImage extends BaseImage {
    public HueImage(){
        frangShader = pre +"hue.glsl";
    }

    @Override
    protected void setArgs() {
        super.setArgs();
        setUniformTime("time");
    }
}
