package kw.learn;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.kw.gdx.asset.Asset;

import kw.learn.base.BaseGroup;

/**
 * @Auther jian xian si qi
 * @Date 2023/12/25 15:54
 */
public class LuminImage extends BaseGroup {

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
