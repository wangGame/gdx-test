package kw.learn.clip;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.kw.gdx.asset.Asset;

/**
 * @Auther jian xian si qi
 * @Date 2023/8/23 10:11
 */
public class SiJaGroup1 extends Group {
    private ShaderProgram shadowProgram;

    public SiJaGroup1(){
        shadowProgram = new ShaderProgram(Gdx.files.internal("colormap/line.vert"),
                Gdx.files.internal("colormap/line3.glsl"));
        Texture texture = Asset.getAsset().getTexture("ttttttt.png");
        TextureRegion region = new TextureRegion(texture);
        Image picImage = new Image(region){
            @Override
            public void draw(Batch batch, float parentAlpha) {
                if (shadowProgram!=null) {
                    batch.setShader(shadowProgram);
                    float i = 100.0f / region.getRegionHeight();
                    shadowProgram.setUniformf("ra",i);
                    batch.flush();
                    super.draw(batch, parentAlpha);
                    batch.setShader(null);
                }
            }
        };
        picImage.setPosition(100,100);
        picImage.setSize(900,900);
        addActor(picImage);
    }
}
