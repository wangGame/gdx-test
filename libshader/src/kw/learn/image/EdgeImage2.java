package kw.learn.image;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import kw.learn.base.BaseGroup;

/**
 * @Auther jian xian si qi
 * @Date 2023/12/26 18:36
 */

public class EdgeImage2 extends BaseGroup {

    public EdgeImage2(){
        vertShader = "realseshader/common.vert";
         frangShader = "realseshader/edge2.glsl";
    }
}

