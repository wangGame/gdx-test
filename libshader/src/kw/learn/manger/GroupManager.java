package kw.learn.manger;

import static kw.learn.interpolation.InterpolationShaderType.*;

import com.badlogic.gdx.scenes.scene2d.Actor;

import kw.learn.effect.BlurDemo;
import kw.learn.effect.ERROR_RgbHsl;
import kw.learn.effect.OutLight;
import kw.learn.base.BaseImage;
import kw.learn.bean.ItemBean;
import kw.learn.blend.SrcAlpha_One;
import kw.learn.constant.ImageShaderType;
import kw.learn.effect.ERROR_HaHaJingDemo;
import kw.learn.effect.ERROR_HUAIJIU;
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
import kw.learn.interpolation.ExpGroup;
import kw.learn.meiju.ItemType;
import kw.learn.effect.ERROR_NomalMix;

/**
 * @Auther jian xian si qi
 * @Date 2023/12/27 15:21
 */
public class GroupManager {
    public static ItemBean InterpolationShaderItems[] = {
            new ItemBean(EXPOSE.name(), EXPOSE.getIndex()),
            new ItemBean(POW2INVERTSE.name(), POW2INVERTSE.getIndex()),
            new ItemBean(LINEAR.name(),LINEAR.getIndex()),
            new ItemBean(SMOOTH.name(),SMOOTH.getIndex()),

    };

    public static Actor createInterShader(int index) {
        Actor actor = null;
        switch (index) {
            case 0:
                actor = new ExpGroup(EXPOSE);
                break;
            case 1:
                actor = new ExpGroup(POW2INVERTSE);
                break;
            case 2:
                actor = new ExpGroup(LINEAR);
                break;
            case 3:
                actor = new ExpGroup(SMOOTH);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + index);
        }
        return actor;
    }

    public static ItemBean imageShaderItems[] = {
            new ItemBean("LUMIN", ImageShaderType.LUMIN),
            new ItemBean("EDG", ImageShaderType.EDG),
            new ItemBean("EXPOSURE", ImageShaderType.EXPOSURE),
            new ItemBean("DISSOLVE", ImageShaderType.DISSOLVE),

            new ItemBean("NOISEONE", ImageShaderType.NOISEONE),
            new ItemBean("SOLARIZE", ImageShaderType.SOLARIZE),
            new ItemBean("EDG2", ImageShaderType.EDG2),
            new ItemBean("GRAY", ImageShaderType.GRAY),

            new ItemBean("GRAY2", ImageShaderType.GRAY2),
            new ItemBean("CONTRAST", ImageShaderType.CONTRAST),
            new ItemBean("GAMMA", ImageShaderType.GAMMA),
            new ItemBean("COLORINERT", ImageShaderType.COLORINERT),

            new ItemBean("PIX", ImageShaderType.PIX),
            new ItemBean("HUE", ImageShaderType.HUE),
            new ItemBean("BRIGHT", ImageShaderType.BRIGHT),
            new ItemBean("SEPIA", ImageShaderType.SEPIA),
            new ItemBean("SHARPEN", ImageShaderType.SHARPEN),
            new ItemBean("THREOHOLD", ImageShaderType.THREOHOLD),
            new ItemBean("POSTER", ImageShaderType.POSTER),
            new ItemBean("SATURATION", ImageShaderType.SATURATION),
            new ItemBean("HIGHTSHADOW", ImageShaderType.HIGHTSHADOW)
    };

    public static Actor createGroup(ItemType itemType){
        Actor actor = null;
        switch (itemType){
            case HIGHTSHADOW:
                actor = new HighlightShadowImage();
            break;
            case SATURATION:
                actor = new SaturationImage();
                break;
            case LUMIN:
                actor = new LuminImage();
                break;
            case EDG:
                actor = new EdegeImage();
                break;
            case EXPOSURE:
                actor = new ExpuseImage();
                break;
            case DISSOLVE:
                actor = new DissolveImage();
                break;
            case NOISEONE:
                actor = new NoiseImage();
                break;
            case SOLARIZE:
                actor = new SolarizeImage();
                break;
            case EDG2:
                actor = new EdgeImage2();
                break;
            case GRAY:
                actor = new GrayImage();
                break;
            case GRAY2:
                actor = new GrayImage2();
                break;
            case CONTRAST:
                actor = new ContractImage();
                break;
            case GAMMA:
                actor = new GammaImage();
                break;
            case COLORINERT:
                actor = new ColorInvertImage();
                break;
            case PIX:
                actor = new PixImage();
                break;
            case HUE:
                actor = new HueImage();
                break;
            case BRIGHT:
                actor = new BrightImage();
                break;
            case SEPIA:
                actor = new SepiaImage();
                break;
            case SHARPEN:
                actor = new SharpenImage();
                break;
            case HREOHOLD:
                actor = new ThreoholdImage();
                break;
            case POSTER:
                actor = new PosterImage();
                break;
            case OUTLIGHT:
                actor = new OutLight();
                break;
            case SRCALPHA_ONE:
                actor = new SrcAlpha_One();
                break;
            case RGBHSL:
                actor = new ERROR_RgbHsl();
                break;
            case BLUR:
                actor = new BlurDemo();
                break;
            case HAHAJING:
                actor = new ERROR_HaHaJingDemo();
                break;
            case HUAIJIU:
                actor = new ERROR_HUAIJIU();
                break;
            case MIX:
                actor = new ERROR_NomalMix();
                break;
        }
        if (actor instanceof BaseImage){
            ((BaseImage)(actor)).initShader();
        }
        return actor;
    }

    public static Actor createGroup(int index) {
        Actor actor = null;
        switch (index){
            case ImageShaderType.HIGHTSHADOW:
                actor = new HighlightShadowImage();
                break;
            case ImageShaderType.SATURATION:
                actor = new SaturationImage();
                break;
            case ImageShaderType.LUMIN:
                actor = new LuminImage();
                break;
            case ImageShaderType.EDG:
                actor = new EdegeImage();
                break;
            case ImageShaderType.EXPOSURE:
                actor = new ExpuseImage();
                break;
            case ImageShaderType.DISSOLVE:
                actor = new DissolveImage();
                break;
            case ImageShaderType.NOISEONE:
                actor = new NoiseImage();
                break;
            case ImageShaderType.SOLARIZE:
                actor = new SolarizeImage();
                break;
            case ImageShaderType.EDG2:
                actor = new EdgeImage2();
                break;
            case ImageShaderType.GRAY:
                actor = new GrayImage();
                break;
            case ImageShaderType.GRAY2:
                actor = new GrayImage2();
                break;
            case ImageShaderType.CONTRAST:
                actor = new ContractImage();
                break;
            case ImageShaderType.GAMMA:
                actor = new GammaImage();
                break;
            case ImageShaderType.COLORINERT:
                actor = new ColorInvertImage();
                break;
            case ImageShaderType.PIX:
                actor = new PixImage();
                break;
            case ImageShaderType.HUE:
                actor = new HueImage();
                break;
            case ImageShaderType.BRIGHT:
                actor = new BrightImage();
                break;
            case ImageShaderType.SEPIA:
                actor = new SepiaImage();
                break;
            case ImageShaderType.SHARPEN:
                actor = new SharpenImage();
                break;
            case ImageShaderType.THREOHOLD:
                actor = new ThreoholdImage();
                break;
            case ImageShaderType.POSTER:
                actor = new PosterImage();
                break;
        }
        if (actor instanceof BaseImage){
            ((BaseImage)(actor)).initShader();
        }
        return actor;
    }


}
