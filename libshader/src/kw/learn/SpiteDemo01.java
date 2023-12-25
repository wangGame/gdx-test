package kw.learn;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import kw.learn.base.BaseGroup;


public class SpiteDemo01 extends BaseGroup {
    public SpiteDemo01() {
        this.vertShader = "unityshader/gray.vert";
        this.frangShader = "unityshader/gray.frag";
    }
}
