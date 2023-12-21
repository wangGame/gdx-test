package com.tony.rider.clip;

/**
 * @Auther jian xian si qi
 * @Date 2023/12/21 15:34
 */

public class VertexAttachment{
    private float x;
    private float y;
    protected float[] vertices;

    public void computeWorldVertices (int start,
                                      int count,
                                      float[] worldVertices,
                                      int offset,
                                      int stride) {
        count = offset + (count >> 1) * stride;
        float[] vertices = this.vertices;
        float a = Constant.a;
        float b = Constant.b;
        float c = Constant.c;
        float d = Constant.d;
        for (int v = start, w = offset; w < count; v += 2, w += stride) {
            float vx = vertices[v], vy = vertices[v + 1];
            worldVertices[w] = vx * a + vy * b + x;
            worldVertices[w + 1] = vx * c + vy * d + y;
        }
    }

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
}
