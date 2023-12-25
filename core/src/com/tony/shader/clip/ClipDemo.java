package com.tony.shader.clip;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.tony.shader.asset.Asset;

/**
 * @Auther jian xian si qi
 * @Date 2023/12/22 10:15
 */
public class ClipDemo extends ClipGroup {
    public ClipDemo(){
        Texture texture = Asset.getAsset().getTexture("test001.png");
        TextureRegionActor textureRegionActor = new TextureRegionActor(texture);
//        textureRegionActor.addAction(Actions.sequence(
//                Actions.moveTo(100,100,7),
//                Actions.moveTo(0,0,7)
//                ));
        addActor(textureRegionActor);
        //只是里面的一个图片大小
//        textureRegionActor.setSize(500,500);
        textureRegionActor.addAction(Actions.moveTo(100,100,3));
        setSize(texture.getWidth(),texture.getHeight());
        clippingAttachment = new ClippingAttachment();
        updateProcess(360);

//        float vertices[] ={
//                100,400,
//                200,300,
//                300,400,
//                400,200,
//                200,0,
//                0,200
//
//                //                0f,         304.22f,
////                150f,         600,
////                302.38f,    302.04f,
////                602.38f,    102.04f,
////                300.8f,     0,
////                30,          40f
//        };
    }


    private float target;

    @Override
    public void act(float delta) {
        super.act(delta);

    }

    float convertToRadians(float angleInDegrees) {
        float angleInRadians = angleInDegrees * 0.0174532925f;
        return angleInRadians;
    }

    private void updateProcess(int num) {
        if (num>360)num = 360;
        float centerX = 300;
        float centerY = 300;
//        int num = 360;
        int length = (num+1) * 2;
        float vertices[] = new float[length+2];
        int indx = 0 ;
        vertices[indx++] = centerX;
        vertices[indx++] = centerY;

        for (int angle = 0; angle <= num; angle++) {
            float dy = (float) (Math.sin(angle * 0.0174532925f) * 300);
            float dx = (float) (Math.cos(angle * 0.0174532925f) * 300);
            vertices [indx++] = centerX + dx;
            vertices [indx++] = centerY + dy;
        }
        clippingAttachment.setVerties(vertices);
    }
}
