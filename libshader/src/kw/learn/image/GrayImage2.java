package kw.learn.image;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
public class GrayImage2 extends Image {
    private ShaderProgram program;
    public GrayImage2(){
        program = new ShaderProgram(Gdx.files.internal("hui/txt.vert"),
                Gdx.files.internal("hui/grayscale1.glsl"));
    }

    private float time = 0;

    @Override
    public void act(float delta) {
        super.act(delta);
        time += delta;
    }

    public void draw(Batch batch, float parentAlpha) {
        batch.setShader(program);
        int contrast = program.getUniformLocation("contrast");
        System.out.println(time*0.1f);
        program.setUniformf(contrast,time*0.1f);
        super.draw(batch, parentAlpha);
        batch.setShader(null);

    }
}
