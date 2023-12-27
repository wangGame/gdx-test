package kw.learn.model;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

public class BgGroup4 extends Image {
    private ShaderProgram shadowProgram;
    private float time = 0;

    private boolean startAnimation = true;
    public BgGroup4(SpriteDrawable spriteDrawable){
        super(spriteDrawable);
        shadowProgram = new ShaderProgram(
                Gdx.files.internal("gamee/line.vert"),Gdx.files.internal("gamee/line.frag"));
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if (time<1.0){
            time+=delta*0.5f;
        }else {
            time = 1.0f;
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if (shadowProgram!=null&&startAnimation) {
            batch.setShader(shadowProgram);
            int timeLocation = shadowProgram.getUniformLocation("time");
            shadowProgram.setUniformf(timeLocation,time);
            super.draw(batch, parentAlpha);
            batch.setShader(null);
        }
    }

    public void setAnimation() {
        startAnimation = true;
        time = 0.5f;
    }
}

