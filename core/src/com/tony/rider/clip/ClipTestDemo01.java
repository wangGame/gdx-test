package com.tony.rider.clip;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.CpuPolygonSpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.utils.FloatArray;
import com.badlogic.gdx.utils.NumberUtils;
import com.badlogic.gdx.utils.ShortArray;
import com.tony.rider.asset.Asset;

/**
 * @Auther jian xian si qi
 * @Date 2023/12/21 14:25
 */
public class ClipTestDemo01 extends Group {
    private ClippingAttachment t = new ClippingAttachment("");
    private SkeletonClipping clipper;
    int verticesLength;
    public ClipTestDemo01() {
        clipper = new SkeletonClipping();
        int vertexSize = 2;
        verticesLength = vertexSize << 2;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        clipper.start(t);
        float c = -1.7014117E38f;
        clipper.clipTriangles(vertices12, verticesLength, triangles, triangles.length,
                uvs, c, 0, false);
        FloatArray clippedVertices = clipper.getClippedVertices();
        ShortArray clippedTriangles = clipper.getClippedTriangles();
        CpuPolygonSpriteBatch batch1 = (CpuPolygonSpriteBatch) (batch);

        batch1.draw(texture,
                clippedVertices.items,
                0,
                clippedVertices.size,
                clippedTriangles.items, 0,
                clippedTriangles.size);
        clipper.clipEnd();
    }

}
