package kw.learn.image;

import kw.learn.base.BaseImage;

/**
 * @Auther jian xian si qi
 * @Date 2023/12/28 10:33
 */
public class HighlightShadowImage extends BaseImage {
    public HighlightShadowImage(){
        frangShader = pre + "highlightShadow.glsl";
    }

    @Override
    protected void setArgs() {
        super.setArgs();
        setUniformTime("highlights");
    }
}
