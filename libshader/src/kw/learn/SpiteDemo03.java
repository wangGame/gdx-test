package kw.learn;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class SpiteDemo03 extends Image {
    private ShaderProgram program;

    public SpiteDemo03(Texture texture){
        super(texture);
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("unityshader/gray.vert"),
                    Gdx.files.internal("unityshader/Hidden_Compositing.glsl"));
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.setShader(program);

        super.draw(batch, parentAlpha);
        batch.setShader(null);
    }
}
