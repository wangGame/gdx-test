package kw.learn.image;

import kw.learn.base.BaseImage;

/**
 * @Auther jian xian si qi
 * @Date 2023/12/26 18:36
 */

public class EdgeImage2 extends BaseImage {

    public EdgeImage2(){
        vertShader = "realseshader/common.vert";
         frangShader = "realseshader/edge1.glsl";
    }
}

