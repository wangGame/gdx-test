package com.tony.rider.clip;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.CpuPolygonSpriteBatch;
import com.badlogic.gdx.utils.Array;

/**
 * @Auther jian xian si qi
 * @Date 2023/12/21 21:44
 */
public class TexureRegionGroup {
    private Array<TextureRegionUtils> regionUtilsArray;
    private SkeletonClipping clipping;
//    private TextureRegionUtils utils1;
//    private TextureRegionUtils utils;
    public TexureRegionGroup(SkeletonClipping clipping){
        this.clipping = clipping;
        regionUtilsArray = new Array<>();
    }

    public void addRegionUtils(TextureRegionUtils textureRegionUtils){
        regionUtilsArray.add(textureRegionUtils);
    }

    public void removeRegionUtils(TextureRegionUtils textureRegionUtils){
        regionUtilsArray.removeValue(textureRegionUtils,false);
    }

    public void draw(CpuPolygonSpriteBatch batch, float parentAlpha){
        for (TextureRegionUtils textureRegionUtils : regionUtilsArray) {
            textureRegionUtils.draw(batch,clipping);
        }
    }
}
