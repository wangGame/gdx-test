package kw.learn.image;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.kw.gdx.asset.Asset;

import kw.learn.base.BaseImage;

public class SolarizeImage extends BaseImage {
    public SolarizeImage(){
        this.vertShader = "shader/txt.vert";
        this.frangShader = "shader/solarize.glsl";
    }

    @Override
    protected void setArgs() {
        super.setArgs();

        program.setUniformf("time",time);

    }
}
