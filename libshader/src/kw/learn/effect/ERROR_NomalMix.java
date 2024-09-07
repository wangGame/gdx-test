package kw.learn.effect;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.kw.gdx.asset.Asset;

public class ERROR_NomalMix extends Group {
    public ERROR_NomalMix(){
        ShaderProgram program = new ShaderProgram(
                Gdx.files.internal("mix/hsl.gl"),
                Gdx.files.internal("mix/hsl.fs")
        );
        Texture texture = Asset.getAsset().getTexture("mix/ceshiimg.png");
        Image image = new Image(Asset.getAsset().getTexture("big.png")){
            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.flush();
                batch.setShader(program);

                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE1);
                texture.bind();
                int uniformLocation = program.getUniformLocation("u_texture1");
                program.setUniformi(uniformLocation,1);
                Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);
                super.draw(batch, parentAlpha);
                batch.flush();
                batch.setShader(null);
            }
        };
        addActor(image);
    }
}
