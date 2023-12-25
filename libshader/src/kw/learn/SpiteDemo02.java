package kw.learn;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.kw.gdx.asset.Asset;

public class SpiteDemo02 extends Image {
    private ShaderProgram program;
    private Texture texture1;

    public SpiteDemo02(Texture texture){
        super(texture);
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("unityshader/gray.vert"),
                    Gdx.files.internal("unityshader/GUI_Text Shader.glsl"));
        }
        texture1 = Asset.getAsset().getTexture("noise.png");
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.setShader(program);

        int u_texture1 = program.getUniformLocation("u_texture1");
        Gdx.gl.glActiveTexture(GL20.GL_TEXTURE1);
        texture1.bind();
        program.setUniformi(u_texture1,1);
        Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);

        super.draw(batch, parentAlpha);
        batch.setShader(null);
    }
}
