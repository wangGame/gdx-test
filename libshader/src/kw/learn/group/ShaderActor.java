package kw.learn.group;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

import kw.learn.gutils.ShapeShaderRenderer;

/**
 * @Auther jian xian si qi
 * @Date 2023/12/29 13:36
 */
public class ShaderActor extends Actor {
    ShapeShaderRenderer renderer;
    public ShaderActor(){
        setDebug(true);
        setSize(800,800);
        this.renderer = new ShapeShaderRenderer();
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.flush();
        renderer.setProjectionMatrix(batch.getProjectionMatrix());
        renderer.setTransformMatrix(batch.getTransformMatrix());
        renderer.begin();
        renderer.rect(getX(),getY(),700,700);
        renderer.end();
        batch.flush();
    }
}
