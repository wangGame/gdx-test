package kw.learn.image;

import kw.learn.base.BaseImage;

/**
 * @Auther jian xian si qi
 * @Date 2023/12/25 15:54
 */
public class LuminImage extends BaseImage {

    private float threshold;

    public LuminImage() {
        vertShader = "realseshader/common.vert";
        frangShader = "realseshader/lumin.glsl";
        threshold = 0.3f;
    }

    /**
     *  0 - 1
     * @param threshold
     */
    public void setThreshold(float threshold) {
        this.threshold = threshold;
    }

    @Override
    protected void setArgs() {
        super.setArgs();
        int thresholdLocation = program.getUniformLocation("threshold");
        program.setUniformf(thresholdLocation,threshold);
    }
}
