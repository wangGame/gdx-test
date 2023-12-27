package kw.learn.image;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import kw.learn.base.BaseImage;

public class GrayImage2 extends BaseImage {
    public GrayImage2(){
        vertShader = "realseshader/common.vert";
        frangShader = "realseshader/grayscale1.glsl";
    }
}
