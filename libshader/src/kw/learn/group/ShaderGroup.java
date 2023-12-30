package kw.learn.group;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import com.kw.gdx.asset.Asset;

import kw.learn.gutils.ShapeShaderRenderer;
import kw.learn.interpolation.InterpolationShaderType;

/**
 * @Auther jian xian si qi
 * @Date 2023/12/29 13:47
 */
public class ShaderGroup extends Group {
    private ShapeShaderRenderer renderer;
    public ShaderGroup() {
        this(800,800);
    }

    public ShaderGroup(float width,float height){
        setSize(width,height);
        this.renderer = new ShapeShaderRenderer();
        String name = InterpolationShaderType.EXPOSE.name();
    }

    public void setShaderType(InterpolationShaderType type){
        renderer.setShaderType(type);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch,parentAlpha);
        if (this.transform) {
            this.applyTransform(batch, this.computeTransform());
        }
        batch.end();
        batch.flush();
        drawContent(batch);
        batch.flush();

        batch.begin();
        if (this.transform) {
            this.resetTransform(batch);
        }
    }

    private void drawContent(Batch batch) {
        renderer.setProjectionMatrix(batch.getProjectionMatrix());
        renderer.setTransformMatrix(batch.getTransformMatrix());
        renderer.begin();
        renderer.addUserArgs(getWidth(),getHeight());
        renderer.rect(0,0,getWidth(),getHeight());
        renderer.end();
    }
}
