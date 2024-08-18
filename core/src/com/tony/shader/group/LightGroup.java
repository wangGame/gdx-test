package com.tony.shader.group;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.ScreenUtils;
import com.kw.gdx.asset.Asset;

public class LightGroup extends Group {
    private ShaderProgram program;
    public LightGroup(){
        program = new ShaderProgram(
                Gdx.files.internal("flight/cir.vert"),
                Gdx.files.internal("flight/cir.glsl")
        );
        Image image = new Image(Asset.getAsset().getTexture("cirtest.png"));
        addActor(image);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.flush();
        batch.setShader(program);
        super.draw(batch, parentAlpha);
        batch.flush();
        batch.setShader(null);
    }
}
