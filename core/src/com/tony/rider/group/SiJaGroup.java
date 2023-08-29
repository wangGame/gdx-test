package com.tony.rider.group;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.tony.rider.asset.Asset;

/**
 * @Auther jian xian si qi
 * @Date 2023/8/23 10:11
 */
public class SiJaGroup extends Group {
    private ShaderProgram shadowProgram;
    Image group;
    public SiJaGroup(){

        shadowProgram = new ShaderProgram(Gdx.files.internal("colormap/line.vert"),
                Gdx.files.internal("colormap/line2.glsl"));

        Texture texture = Asset.getAsset().getTexture("1234.png");
        TextureRegion region = new TextureRegion(texture);
        region.setRegion(0,0,400,800);
        group = new Image(region){
            private float time = 0;
            float rr = 0;
            @Override
            public void act(float delta) {
                super.act(delta);
                time += delta;

            }

            @Override
            public void draw(Batch batch, float parentAlpha) {
                if (shadowProgram!=null) {
                    batch.setShader(shadowProgram);
                    float u = region.getU();
                    float u2 = region.getU2();
                    float v = region.getV();
                    float v2 = region.getV2();
                    float uv = (u2 - u) / 2.0f;
                    float vv = (v2 - v) / 2.0f;
                    shadowProgram.setUniformf("uv",uv);
                    shadowProgram.setUniformf("vv",vv);
                    float i = 30.0f / region.getRegionHeight();
                    shadowProgram.setUniformf("ra",i);
                    shadowProgram.setUniformf("h",time*0.01f);
                    super.draw(batch, parentAlpha);
                    batch.setShader(null);
                }else {
                    super.draw(batch, parentAlpha);
                }
            }
        };
        group.setPosition(0,0);
        group.setColor(240.0F/255, 217.0F/255, 187.0F/255,1);
        addActor(group);
        group.setScale(0.4f);
    }
}
