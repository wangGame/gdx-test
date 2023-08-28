package com.tony.rider.group;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
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
                Gdx.files.internal("colormap/line1.frag"));
        group = new Image(Asset.getAsset().getTexture("_Background-58852.png")){
            private float time = 0;
            float rr = 0;
            @Override
            public void act(float delta) {
                super.act(delta);
                time += delta;
                rr += delta*60;
            }

            @Override
            public void draw(Batch batch, float parentAlpha) {
                if (shadowProgram!=null) {
                    batch.setShader(shadowProgram);
                    int timeLocation = shadowProgram.getUniformLocation("time");
                    shadowProgram.setUniformf(timeLocation,time);
                    shadowProgram.setUniformf("rato",group.getWidth()/group.getHeight());
                    shadowProgram.setUniformf("ra",0.1f);
                    shadowProgram.setUniformf("time",0.1f);
                    shadowProgram.setUniformf("offsetXL",0.3f);
//                    shadowProgram.setUniformf("offsetXR",0.1f);
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
