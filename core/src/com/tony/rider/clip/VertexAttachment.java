package com.tony.rider.clip;

/**
 * @Auther jian xian si qi
 * @Date 2023/12/21 15:34
 */

import static com.esotericsoftware.spine.utils.SpineUtils.cosDeg;
import static com.esotericsoftware.spine.utils.SpineUtils.sinDeg;

import com.badlogic.gdx.utils.FloatArray;
import java.util.concurrent.atomic.AtomicInteger;

public class VertexAttachment extends Attachment {
    static private final AtomicInteger nextID = new AtomicInteger();

    private final int id = (nextID.getAndIncrement() & 65535) << 11;
    int[] bones;
    float[] vertices;
    int worldVerticesLength;

    public VertexAttachment (String name) {
        super(name);
    }

    public void computeWorldVertices (int start, int count, float[] worldVertices, int offset, int stride) {
        count = offset + (count >> 1) * stride;
        float[] vertices = this.vertices;
        int[] bones = this.bones;
        if (bones == null) {
//            float x = bone.getWorldX(), y = bone.getWorldY();
//            float a = bone.getA(), b = bone.getB(), c = bone.getC(), d = bone.getD();

            float a = Constant.a;
            float b = Constant.b;
            float c = Constant.c;
            float d = Constant.d;


            for (int v = start, w = offset; w < count; v += 2, w += stride) {
                float vx = vertices[v], vy = vertices[v + 1];
                worldVertices[w] = vx * a + vy * b + x;
                worldVertices[w + 1] = vx * c + vy * d + y;
            }
            return;
        }
        int v = 0, skip = 0;
        for (int i = 0; i < start; i += 2) {
            int n = bones[v];
            v += n + 1;
            skip += n;
        }
    }

    private float x;
    private float y;

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int[] getBones () {
        return bones;
    }

    /** @param bones May be null if this attachment has no weights. */
    public void setBones (int[] bones) {
        this.bones = bones;
    }

    /** The vertex positions in the bone's coordinate system. For a non-weighted attachment, the values are <code>x,y</code>
     * entries for each vertex. For a weighted attachment, the values are <code>x,y,weight</code> entries for each bone affecting
     * each vertex. */
    public float[] getVertices () {
        return vertices;
    }

    public void setVertices (float[] vertices) {
        this.vertices = vertices;
    }

    public int getWorldVerticesLength () {
        return worldVerticesLength;
    }

    public void setWorldVerticesLength (int worldVerticesLength) {
        this.worldVerticesLength = worldVerticesLength;
    }

    /** Returns a unique ID for this attachment. */
    public int getId () {
        return id;
    }
}
