package kw.learn.image;

import kw.learn.base.BaseImage;

/**
 * @Auther jian xian si qi
 * @Date 2023/12/27 18:21
 */
public class SharpenImage extends BaseImage {
    public SharpenImage(){
        frangShader = pre +"sharpen.frag";
    }

    @Override
    protected void setArgs() {
        super.setArgs();
        setUniformTime("time");
    }
}
