package kw.learn.manger;

import com.badlogic.gdx.scenes.scene2d.Actor;

import kw.learn.base.BaseImage;
import kw.learn.bean.ItemBean;
import kw.learn.blend.SrcAlpha_One;
import kw.learn.constant.ShaderType;
import kw.learn.image.DissolveImage;
import kw.learn.image.EdegeImage;
import kw.learn.image.EdgeImage2;
import kw.learn.image.ExpuseImage;
import kw.learn.image.GrayImage;
import kw.learn.image.GrayImage2;
import kw.learn.image.LuminImage;
import kw.learn.image.NoiseImage;
import kw.learn.image.SolarizeImage;

/**
 * @Auther jian xian si qi
 * @Date 2023/12/27 15:21
 */
public class GroupManager {
    public static Actor createGroup(int index) {
        Actor actor = null;
        switch (index){
            case ShaderType.LUMIN:
                actor = new LuminImage();
                break;
            case ShaderType.EDG:
                actor = new EdegeImage();
                break;
            case ShaderType.EXPOSURE:
                actor = new ExpuseImage();
                break;
            case ShaderType.DISSOLVE:
                actor = new DissolveImage();
                break;
            case ShaderType.NOISEONE:
                actor = new NoiseImage();
                break;
            case ShaderType.SOLARIZE:
                actor = new SolarizeImage();
                break;
            case ShaderType.EDG2:
                actor = new EdgeImage2();
                break;
            case ShaderType.GRAY:
                actor = new GrayImage();
                break;
            case ShaderType.GRAY2:
                actor = new GrayImage2();
                break;
        }
        if (actor instanceof BaseImage){
            ((BaseImage)(actor)).initShader();
        }
        return actor;
    }

    public static ItemBean itemBeans[] = {
            new ItemBean("LUMIN", ShaderType.LUMIN),
            new ItemBean("EDG", ShaderType.EDG),
            new ItemBean("EXPOSURE", ShaderType.EXPOSURE),
            new ItemBean("DISSOLVE", ShaderType.DISSOLVE),
            new ItemBean("NOISEONE", ShaderType.NOISEONE),
            new ItemBean("SOLARIZE", ShaderType.SOLARIZE),
            new ItemBean("EDG2", ShaderType.EDG2),
            new ItemBean("GRAY", ShaderType.GRAY),
            new ItemBean("GRAY2", ShaderType.GRAY2),

    };
}
