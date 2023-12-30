package kw.learn.interpolation;

import static kw.learn.interpolation.InterpolationShaderType.EXPOSE;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Auther jian xian si qi
 * @Date 2023/12/30 12:02
 */
public class ShaderProgramUtils {
    private HashMap<InterpolationShaderType, ShaderProgram> hashMap = new HashMap<>();
    public ShaderProgram createShaderProgram(InterpolationShaderType type){
        if (hashMap.containsKey(type))hashMap.get(type);
        ShaderProgram shaderProgram = null;
        switch (type){
            case EXPOSE:
                shaderProgram = new ShaderProgram(
                        Gdx.files.internal("mathline/commonvert.vert"),
                        Gdx.files.internal("mathline/exp.glsl"));
                break;
            case POW2INVERTSE:
                shaderProgram = new ShaderProgram(
                        Gdx.files.internal("mathline/commonvert.vert"),
                        Gdx.files.internal("mathline/powInInverse.frag"));
                break;
            case LINEAR:
                shaderProgram = new ShaderProgram(
                        Gdx.files.internal("mathline/commonvert.vert"),
                        Gdx.files.internal("mathline/line.glsl"));
                break;
            case SMOOTH:
                shaderProgram = new ShaderProgram(
                        Gdx.files.internal("mathline/commonvert.vert"),
                        Gdx.files.internal("mathline/smooth.glsl"));
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        if (shaderProgram != null) {
            hashMap.put(type, shaderProgram);
        }
        return shaderProgram;
    }

    private static ShaderProgramUtils utils;
    public static ShaderProgramUtils getInstance(){
        if (utils == null){
            utils = new ShaderProgramUtils();
        }
        return utils;
    }
}
