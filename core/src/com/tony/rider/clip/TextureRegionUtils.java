package com.tony.rider.clip;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.CpuPolygonSpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.FloatArray;
import com.badlogic.gdx.utils.NumberUtils;
import com.badlogic.gdx.utils.ShortArray;

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
    private Color color = new Color(1,1,1,1f);

    public TextureRegionUtils(float x, float y,Texture texture){
        //创建Region
        this.texture = texture;
        region1 = new RegionAttachment();
        TextureRegion region = new TextureRegion(texture);
        region1.setRegion(region);
        region1.setWidth(region.getRegionWidth());
        region1.setHeight(region.getRegionHeight());
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

    public void setSize(float width, float height){
        region1.setWidth(width);
        region1.setHeight(height);
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

    public void setColor(Color color) {
        this.color = color;
    }

    public void draw(Batch batch, SkeletonClipping clipper, float parentAlpha) {
//        float c = -1.7014117E38f;
        float alpha = parentAlpha;
        float c = NumberUtils.intToFloatColor(((int)(color.a * alpha * 255.0f) << 24) //
                | ((int)(color.b * 255) << 16) //
                | ((int)(color.g * 255) << 8) //
                | (int) (color.r * 255));

        clipper.clipTriangles(getVertices12(),
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
