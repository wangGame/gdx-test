package com.tony.rider.clip;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.FloatArray;
import com.esotericsoftware.spine.Bone;
import com.esotericsoftware.spine.Skeleton;

/**
 * @Auther jian xian si qi
 * @Date 2023/12/21 14:22
 */
public class ClippingAttachment extends VertexAttachment {
    private int n;
    public void setVerties(float [] floats){
        this.n = floats.length;
        vertices = floats;
    }

    public int getN() {
        return n;
    }
}
