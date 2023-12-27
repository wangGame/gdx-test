package kw.learn.image;

import kw.learn.base.BaseImage;

/**
 * @Auther jian xian si qi
 * @Date 2023/12/27 18:38
 */
public class PosterImage extends BaseImage {
    public PosterImage(){
        frangShader = pre+"poster.glsl";
    }

    @Override
    protected void setArgs() {
        super.setArgs();
        setUniformTime("colorLevels");
    }
}
