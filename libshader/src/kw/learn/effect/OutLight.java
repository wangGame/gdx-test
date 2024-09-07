package kw.learn.effect;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.kw.gdx.asset.Asset;

public class OutLight extends Group {
    private ShaderProgram program;
    public OutLight(){
        setDebug(true);
        program = new ShaderProgram(
                Gdx.files.internal("xiaoguo/outlight/outlight.vert"),
                Gdx.files.internal("xiaoguo/outlight/outlight.glsl")
        );
        Image image = new Image(Asset.getAsset().getTexture("img.png"));
        addActor(image);
        setSize(image.getWidth(),image.getHeight());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.flush();
        batch.setShader(program);
        // 设置外投影偏移量和颜色
//        program.setUniformf("u_shadowOffset", 10.0f, -10.0f); // 投影偏移量
        program.setUniformf("u_shadowColor", 0.0f, 0.0f, 0.0f, 0.5f); // 投影颜色（半透明黑色）
        super.draw(batch, parentAlpha);
        batch.flush();
        batch.setShader(null);
    }
}