package kw.learn.effect;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.kw.gdx.asset.Asset;

public class ERROR_HaHaJingDemo extends Group {
    public ERROR_HaHaJingDemo(){
        ShaderProgram program = new ShaderProgram(
                Gdx.files.internal("newshader/hhj/hhj.gl"),
                Gdx.files.internal("newshader/hhj/hhjr.fs")
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
