package kw.learn.light;

import kw.learn.group.ShaderGroup;
import kw.learn.interpolation.InterpolationShaderType;

/**
 * @Auther jian xian si qi
 * @Date 2024/1/16 13:46
 */
public class DrawLightShaderGroup extends ShaderGroup {
    public DrawLightShaderGroup(){
        setShaderType(InterpolationShaderType.LIGHT);
    }

}
