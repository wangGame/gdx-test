package kw.learn.interpolation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import com.kw.gdx.asset.Asset;

import kw.learn.group.ShaderGroup;

public class ExpGroup  extends ShaderGroup {
    public ExpGroup(InterpolationShaderType type){
        setShaderType(type);
    }
}
