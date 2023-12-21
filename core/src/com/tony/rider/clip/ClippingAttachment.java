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

    final Color color = new Color(0.2275F, 0.2275F, 0.8078F, 1.0F);

    float xx = 0;
    public ClippingAttachment(String name) {
        super(name);
    }

    public void init(){
        vertices = new float[8];
//        vertices[0] = -9.83f + xx;
//        vertices[1] = 3108.55f;
//        vertices[2] = 175.02f + xx;
//        vertices[3] = 3100.57f;
//        vertices[4] = 2.94f + xx;
//        vertices[5] = -322.43f;
//        vertices[6] = -340.28f + xx;
//        vertices[7] = -311.07f;


//        vertices[0] = 0.32f;
//        vertices[1] = 204.22f;
//        vertices[2] = 202.38f;
//        vertices[3] = 202.04f;
//        vertices[4] = 200.8f;
//        vertices[5] = 0;
//        vertices[6] = 0;
//        vertices[7] = 0.05f;



        vertices[0] = 0;
        vertices[1] = 308.55f;
        vertices[2] = 375.02f;
        vertices[3] = 310.57f;
        vertices[4] = 308.94f;
        vertices[5] = 0.43f;
        vertices[6] = 0.28f;
        vertices[7] = 0.07f;

//        -839.83,2308.55,-375.02,2310.57,2362.94,-322.43,-840.28,-311.07
    }

    public Color getColor() {
        return this.color;
    }
}
