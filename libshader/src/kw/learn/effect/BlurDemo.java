package kw.learn.effect;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.kw.gdx.asset.Asset;

public class BlurDemo extends Group {
    public BlurDemo(){
        ShaderProgram program = new ShaderProgram(
                Gdx.files.internal("shader2/UniBlurVertexShader.vs"),
                Gdx.files.internal("shader2/xxx.gl")
//                Gdx.files.internal("shader2/x3.fs")
        );
        Image image = new Image(Asset.getAsset().getTexture("big.png")){
            private float time=0;

            @Override
            public void act(float delta) {
                super.act(delta);
                time -= delta;

            }

            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.flush();
                batch.setShader(program);
                program.setUniformf("time",-0.606f);

                super.draw(batch, parentAlpha);
                batch.flush();
                batch.setShader(null);
            }
        };
        addActor(image);
        setSize(image.getWidth(),image.getHeight());
    }

}
