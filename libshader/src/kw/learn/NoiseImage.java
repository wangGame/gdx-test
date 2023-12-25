package kw.learn;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.kw.gdx.asset.Asset;

public class NoiseImage extends Image {
    private ShaderProgram program;

    public NoiseImage(){
        super(new TextureRegion(Asset.getAsset().getTexture("realsepic/_Background-58852.png")));
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("realseshader/common.vert"),
                    Gdx.files.internal("realseshader/noise.glsl"));
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.setShader(program);
        super.draw(batch, parentAlpha);
        batch.setShader(null);
    }
}
