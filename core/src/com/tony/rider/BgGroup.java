package com.tony.rider;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.tony.rider.asset.Asset;

public class BgGroup extends Group {
    private Texture texture;
    private ShaderProgram shadowProgram;
    public BgGroup(float width, float height){
        texture = Asset.getAsset().getTexture("noise.png");
        shadowProgram = new ShaderProgram(Gdx.files.internal("gamee/middlespread.vert"),
                Gdx.files.internal("gamee/middlespread.frag"));
        Image group = new Image(texture){
            private float time = 0;
            @Override
            public void act(float delta) {
                super.act(delta);
                time+=delta * 0.33f;
            }

            @Override
            public void draw(Batch batch, float parentAlpha) {
                if (shadowProgram!=null) {
                    batch.setShader(shadowProgram);
                    int timeLocation = shadowProgram.getUniformLocation("time");
                    shadowProgram.setUniformf(timeLocation,time);
                    super.draw(batch, parentAlpha);
                    batch.setShader(null);
                }else {
                    super.draw(batch, parentAlpha);
                }
            }
        };
        group.setSize(width,height);
        group.setPosition(0,0);
        group.setColor(240.0F/255, 217.0F/255, 187.0F/255,1);
        addActor(group);
    }
}
