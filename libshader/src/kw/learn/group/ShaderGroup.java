package kw.learn.group;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;

import kw.learn.gutils.ShapeShaderRenderer;

/**
 * @Auther jian xian si qi
 * @Date 2023/12/29 13:47
 */
public class ShaderGroup extends Group {
    ShapeShaderRenderer renderer;
    public ShaderGroup(){
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
        if (this.transform) {
            this.applyTransform(batch, this.computeTransform());
        }
        batch.flush();
        drawContent(batch);
        batch.flush();
        if (this.transform) {
            this.resetTransform(batch);
        }
    }

    private void drawContent(Batch batch) {
        renderer.setProjectionMatrix(batch.getProjectionMatrix());
        renderer.setTransformMatrix(batch.getTransformMatrix());
        renderer.begin();
        renderer.rect(0,0,700,700);
        renderer.end();
    }
}
