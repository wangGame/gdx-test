package com.tony.rider.clip;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.FloatArray;
import com.tony.rider.asset.Asset;

/**
 * @Auther jian xian si qi
 * @Date 2023/12/21 18:57
 */
public class TextureRegionUtils {
    private Texture texture;
    private RegionAttachment region1;
    private short []triangles;
    public TextureRegionUtils(){
        region1 = new RegionAttachment("");
        region1.setRegion(new TextureRegion(Asset.getAsset().getTexture("xxxxx.png")));
        //裁剪 所以为2
        region1.updateOffset();

        final short[] quadTriangles = {0, 1, 2, 2, 3, 0};
        triangles = quadTriangles;
        FloatArray vertices = new FloatArray(32);
        region1.computeWorldVertices(vertices.items, 0, vertexSize);
        texture = region1.getRegion().getTexture();

        FloatArray vertices11 = new FloatArray();
        float[] vertices12 = vertices11.items;
        region1.computeWorldVertices(vertices12, 0, 2);
        float []uvs = region1.getUVs();
    }

            clipper.clipEnd();
}
