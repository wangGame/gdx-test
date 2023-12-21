//package com.tony.rider;
//
//import com.badlogic.gdx.graphics.g2d.TextureRegion;
//import com.badlogic.gdx.utils.Array;
//import com.badlogic.gdx.utils.FloatArray;
//import com.badlogic.gdx.utils.ShortArray;
//import com.esotericsoftware.spine.Bone;
//
///**
// * @Auther jian xian si qi
// * @Date 2023/12/20 15:58
// */
//public class RadomClip {
//    private final Triangulator triangulator = new Triangulator();
//    private final FloatArray clippingPolygon = new FloatArray();
//    private final FloatArray clipOutput = new FloatArray(128);
//    private final FloatArray clippedVertices = new FloatArray(128);
//    private final ShortArray clippedTriangles = new ShortArray(128);
//    private final FloatArray scratch = new FloatArray();
//    private Array<FloatArray> clippingPolygons;
//
//    public RadomClip(){
//
//    }
//
//    public int clipStart (TextureRegion region) {
//        int n = 20;
//        if (n < 6) return 0;
//        float[] vertices = clippingPolygon.setSize(n);
//        clip.computeWorldVertices(slot, 0, n, vertices, 0, 2);
//        makeClockwise(clippingPolygon);
//        ShortArray triangles = triangulator.triangulate(clippingPolygon);
//        clippingPolygons = triangulator.decompose(clippingPolygon, triangles);
//        for (FloatArray polygon : clippingPolygons) {
//            makeClockwise(polygon);
//            polygon.add(polygon.items[0]);
//            polygon.add(polygon.items[1]);
//        }
//        return clippingPolygons.size;
//    }
//
//    public void clipEnd () {
//        clippingPolygons = null;
//        clippedVertices.clear();
//        clippedTriangles.clear();
//        clippingPolygon.clear();
//    }
//
//    static void makeClockwise (FloatArray polygon) {
//        float[] vertices = polygon.items;
//        int verticeslength = polygon.size;
//
//        float area = vertices[verticeslength - 2] * vertices[1] - vertices[0] * vertices[verticeslength - 1], p1x, p1y, p2x, p2y;
//        for (int i = 0, n = verticeslength - 3; i < n; i += 2) {
//            p1x = vertices[i];
//            p1y = vertices[i + 1];
//            p2x = vertices[i + 2];
//            p2y = vertices[i + 3];
//            area += p1x * p2y - p2x * p1y;
//        }
//        if (area < 0) return;
//
//        for (int i = 0, lastX = verticeslength - 2, n = verticeslength >> 1; i < n; i += 2) {
//            float x = vertices[i], y = vertices[i + 1];
//            int other = lastX - i;
//            vertices[i] = vertices[other];
//            vertices[i + 1] = vertices[other + 1];
//            vertices[other] = x;
//            vertices[other + 1] = y;
//        }
//    }
//
//
//
//    public void computeWorldVertices (int start, int count, float[] worldVertices, int offset, int stride) {
//        count = offset + (count >> 1) * stride;
//
//        FloatArray deformArray = slot.getAttachmentVertices();
//        float[] vertices = this.vertices;
//        int[] bones = this.bones;
//        if (bones == null) {
//            if (deformArray.size > 0) vertices = deformArray.items;
//            Bone bone = slot.getBone();
//            float x = bone.getWorldX(), y = bone.getWorldY();
//            float a = bone.getA(), b = bone.getB(), c = bone.getC(), d = bone.getD();
//            for (int v = start, w = offset; w < count; v += 2, w += stride) {
//                float vx = vertices[v], vy = vertices[v + 1];
//                worldVertices[w] = vx * a + vy * b + x;
//                worldVertices[w + 1] = vx * c + vy * d + y;
//            }
//            return;
//        }
//        int v = 0, skip = 0;
//        for (int i = 0; i < start; i += 2) {
//            int n = bones[v];
//            v += n + 1;
//            skip += n;
//        }
//        Object[] skeletonBones = skeleton.getBones().items;
//        if (deformArray.size == 0) {
//            for (int w = offset, b = skip * 3; w < count; w += stride) {
//                float wx = 0, wy = 0;
//                int n = bones[v++];
//                n += v;
//                for (; v < n; v++, b += 3) {
//                    Bone bone = (Bone)skeletonBones[bones[v]];
//                    float vx = vertices[b], vy = vertices[b + 1], weight = vertices[b + 2];
//                    wx += (vx * bone.getA() + vy * bone.getB() + bone.getWorldX()) * weight;
//                    wy += (vx * bone.getC() + vy * bone.getD() + bone.getWorldY()) * weight;
//                }
//                worldVertices[w] = wx;
//                worldVertices[w + 1] = wy;
//            }
//        } else {
//            float[] deform = deformArray.items;
//            for (int w = offset, b = skip * 3, f = skip << 1; w < count; w += stride) {
//                float wx = 0, wy = 0;
//                int n = bones[v++];
//                n += v;
//                for (; v < n; v++, b += 3, f += 2) {
//                    Bone bone = (Bone)skeletonBones[bones[v]];
//                    float vx = vertices[b] + deform[f], vy = vertices[b + 1] + deform[f + 1], weight = vertices[b + 2];
//                    wx += (vx * bone.getA() + vy * bone.getB() + bone.getWorldX()) * weight;
//                    wy += (vx * bone.getC() + vy * bone.getD() + bone.getWorldY()) * weight;
//                }
//                worldVertices[w] = wx;
//                worldVertices[w + 1] = wy;
//            }
//        }
//    }
//
//}
