package kw.learn.image;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.kw.gdx.asset.Asset;

import kw.learn.base.BaseImage;

public class NoiseImage extends BaseImage {

    public NoiseImage(){
        vertShader = "realseshader/common.vert";
        frangShader = "realseshader/noise.glsl";
    }
}
