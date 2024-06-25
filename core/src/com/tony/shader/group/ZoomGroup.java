package com.tony.shader.group;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.kw.gdx.asset.Asset;

public class ZoomGroup extends Group {
    public ZoomGroup (){
        ShaderProgram program = new ShaderProgram(
                Gdx.files.internal("fourone/txt.vert"),
                Gdx.files.internal("fourone/txt.frag")
                );
        Group group = new Group(){
            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        Image image = new Image(Asset.getAsset().getTexture("big.png"));
        group.addActor(image);
        addActor(group);
    }
}
