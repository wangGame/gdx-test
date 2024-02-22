package kw.learn.color;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.kw.gdx.asset.Asset;

public class RgbHsl extends Group {
    public RgbHsl(){
        ShaderProgram program = new ShaderProgram(
                Gdx.files.internal("color/hsl.gl"),
                Gdx.files.internal("color/hsl.fs")
        );
        Image image = new Image(Asset.getAsset().getTexture("big.png")){
            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.flush();
                batch.setShader(program);
                super.draw(batch, parentAlpha);
                batch.flush();
                batch.setShader(null);
            }
        };
        addActor(image);
    }
}
