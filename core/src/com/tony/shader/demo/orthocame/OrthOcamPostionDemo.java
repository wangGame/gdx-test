package com.tony.shader.demo.orthocame;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Align;

/**
 * 移动came的位置
 *
 * 相机存在远far 和near
 */
public class OrthOcamPostionDemo extends Group {
    private OrthographicCamera camera;
    private final Vector3 curr = new Vector3();
    private final Vector3 last = new Vector3(-1, -1, -1);
    private final Vector3 delta = new Vector3();
    private float x;
    private float y;
    private float z = 1F;

    public void init(){
        camera = (OrthographicCamera) getStage().getViewport().getCamera();
        Image image = new Image(new Texture("sprite.png"));
        image.setSize(1000,1000);
        image.setPosition(0,0, Align.center);
        addActor(image);
    }

    @Override
    public void act(float delta1) {
        super.act(delta1);
        x += delta1*10;
        camera.unproject(curr.set(x, y, z));//蒋传入的点进行转换
        if (!(last.x == -1 && last.y == -1 && last.z == -1)) {
            camera.unproject(delta.set(last.x, last.y, z));
            curr.sub(delta);//左边转换之后进行计算
            camera.position.add(curr.x, curr.y, z);//对位置
        }
        last.set(x, y, z);
    }
}
