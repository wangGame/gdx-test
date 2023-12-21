package com.tony.rider.clip;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.CpuPolygonSpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.FloatArray;
import com.badlogic.gdx.utils.ShortArray;
import com.tony.rider.asset.Asset;

/**
 * @Auther jian xian si qi
 * @Date 2023/12/21 18:57
 */
public class TextureRegionUtils {
    private Texture texture;
    private RegionAttachment region1;
    FloatArray vertices = new FloatArray(32);
    FloatArray vertices11 = new FloatArray();
    final short[] quadTriangles = {0, 1, 2, 2, 3, 0};
    private int verticesLength;
    private float[] vertices12;
    private  float []uvs;
    public TextureRegionUtils(float x, float y,Texture texture){
        //创建Region
        this.texture = texture;
        region1 = new RegionAttachment();

        region1.setRegion(new TextureRegion(texture));
        region1.setX(x + region1.getWidth()/4.0F);
        region1.setY(y + region1.getHeight()/4.0F);
        region1.updateOffset(); //裁剪 所以为2
        int vertexSize = 2;
        region1.computeWorldVertices(vertices.items, 0, vertexSize);
        verticesLength = vertexSize << 2;
        vertices12 = vertices11.items;
        region1.computeWorldVertices(vertices12, 0, 2);
        uvs = region1.getUVs();
    }

    public short[] getTriangles() {
        return quadTriangles;
    }

    public int getVerticesLength() {
        return verticesLength;
    }

    public float[] getVertices12() {
        return vertices12;
    }

    public float[] getUvs() {
        return uvs;
    }

    public Texture getTexture() {
        return texture;
    }

    public void draw(Batch batch, SkeletonClipping clipper) {
        float c = -1.7014117E38f;
        clipper.clipTriangles(getVertices12(), getVerticesLength(),
                getTriangles(), getTriangles().length,
                getUvs(), c, 0, false);
        FloatArray clippedVertices = clipper.getClippedVertices();
        ShortArray clippedTriangles = clipper.getClippedTriangles();
        CpuPolygonSpriteBatch batch1 = (CpuPolygonSpriteBatch) (batch);
        batch1.draw(getTexture(),
                clippedVertices.items,
                0,
                clippedVertices.size,
                clippedTriangles.items, 0,
                clippedTriangles.size);
    }
}
