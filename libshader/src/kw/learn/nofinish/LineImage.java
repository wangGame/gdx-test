package kw.learn.nofinish;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.Actor;

import kw.learn.base.BaseGroup;

/**
 * @Auther jian xian si qi
 * @Date 2023/12/26 18:56
 */
public class LineImage extends BaseGroup {
    private Sprite sprite;
    public LineImage(){
        this.sprite = sprite;
        frangShader = "shader4/line.frag";
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if (program!=null) {
            batch.setShader(program);
            int timeLocation = program.getUniformLocation("time");
            int v = program.getUniformLocation("v");
            int v1 = program.getUniformLocation("v1");
            int u = program.getUniformLocation("u");
            int u1 = program.getUniformLocation("u1");
            program.setUniformf(v,sprite.getV());
            program.setUniformf(v1,sprite.getV2());
            program.setUniformf(u,sprite.getU());
            program.setUniformf(u1,sprite.getU2());
            program.setUniformf(timeLocation,time);
            super.draw(batch, parentAlpha);
            batch.setShader(null);
        }
    }
}
