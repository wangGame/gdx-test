package kw.learn.manger;

import com.badlogic.gdx.scenes.scene2d.Actor;

import kw.learn.base.BaseImage;
import kw.learn.bean.ItemBean;
import kw.learn.blend.SrcAlpha_One;
import kw.learn.constant.ShaderType;
import kw.learn.image.BrightImage;
import kw.learn.image.ColorInvertImage;
import kw.learn.image.ContractImage;
import kw.learn.image.DissolveImage;
import kw.learn.image.EdegeImage;
import kw.learn.image.EdgeImage2;
import kw.learn.image.ExpuseImage;
import kw.learn.image.GammaImage;
import kw.learn.image.GrayImage;
import kw.learn.image.GrayImage2;
import kw.learn.image.HighlightShadowImage;
import kw.learn.image.HueImage;
import kw.learn.image.LuminImage;
import kw.learn.image.NoiseImage;
import kw.learn.image.PixImage;
import kw.learn.image.PosterImage;
import kw.learn.image.SaturationImage;
import kw.learn.image.SepiaImage;
import kw.learn.image.SharpenImage;
import kw.learn.image.SolarizeImage;
import kw.learn.image.ThreoholdImage;

/**
 * @Auther jian xian si qi
 * @Date 2023/12/27 15:21
 */
public class GroupManager {

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
            new ItemBean("CONTRAST", ShaderType.CONTRAST),
            new ItemBean("GAMMA", ShaderType.GAMMA),
            new ItemBean("COLORINERT", ShaderType.COLORINERT),
            new ItemBean("PIX", ShaderType.PIX),
            new ItemBean("HUE", ShaderType.HUE),
            new ItemBean("BRIGHT", ShaderType.BRIGHT),
            new ItemBean("SEPIA",ShaderType.SEPIA),
            new ItemBean("SHARPEN",ShaderType.SHARPEN),
            new ItemBean("THREOHOLD",ShaderType.THREOHOLD),
            new ItemBean("POSTER",ShaderType.POSTER),
            new ItemBean("SATURATION",ShaderType.SATURATION),
            new ItemBean("HIGHTSHADOW",ShaderType.HIGHTSHADOW)
    };
    public static Actor createGroup(int index) {
        Actor actor = null;
        switch (index){
            case ShaderType.HIGHTSHADOW:
                actor = new HighlightShadowImage();
                break;
            case ShaderType.SATURATION:
                actor = new SaturationImage();
                break;
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
            case ShaderType.CONTRAST:
                actor = new ContractImage();
                break;
            case ShaderType.GAMMA:
                actor = new GammaImage();
                break;
            case ShaderType.COLORINERT:
                actor = new ColorInvertImage();
                break;
            case ShaderType.PIX:
                actor = new PixImage();
                break;
            case ShaderType.HUE:
                actor = new HueImage();
                break;
            case ShaderType.BRIGHT:
                actor = new BrightImage();
                break;
            case ShaderType.SEPIA:
                actor = new SepiaImage();
                break;
            case ShaderType.SHARPEN:
                actor = new SharpenImage();
                break;
            case ShaderType.THREOHOLD:
                actor = new ThreoholdImage();
                break;
            case ShaderType.POSTER:
                actor = new PosterImage();
                break;
        }
        if (actor instanceof BaseImage){
            ((BaseImage)(actor)).initShader();
        }
        return actor;
    }

}
