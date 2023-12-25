package kw.learn;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.kw.gdx.asset.Asset;

import kw.learn.base.BaseGroup;

public class SolarizeImage extends BaseGroup {
    public SolarizeImage(){
        super(Asset.getAsset().getTexture("realsepic/_Background-58852.png"));
        if (program == null){
            this.vertShader = "shader/txt.vert";
            this.frangShader = "shader/solarize.glsl";
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.setShader(program);
        int time = program.getUniformLocation("time");
        program.setUniformf(time,time);
        super.draw(batch, parentAlpha);
        batch.setShader(null);
    }
}
