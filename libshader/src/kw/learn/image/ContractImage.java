package kw.learn.image;

import com.badlogic.gdx.scenes.scene2d.Group;

import kw.learn.base.BaseImage;

/**
 * @Auther jian xian si qi
 * @Date 2023/12/27 16:27
 */
public class ContractImage extends BaseImage {
    public ContractImage(){
        vertShader = "realseshader/common.vert";
        frangShader = "realseshader/contrast.frag";
    }

    @Override
    protected void setArgs() {
        super.setArgs();
        program.setUniformf("contrast",time);
    }
}
