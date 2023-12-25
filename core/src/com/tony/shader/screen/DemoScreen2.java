package com.tony.shader.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.tony.shader.asset.Asset;
import com.tony.shader.screen.base.BaseScreen;

public class DemoScreen2 extends BaseScreen {
    private ShaderProgram program;

    @Override
    public void show() {
        super.show();
//        colorspace();
        bgTest();
    }

    public void bgTest(){
        ShaderImage2 image2 = new ShaderImage2(
                new SpriteDrawable(
                        new Sprite(
                            Asset.getAsset().getTexture("levelAtlas.png"))));
        addActor(image2);
        image2.setScale(0.4F);
    }

    private void colorspace() {
        if (program == null){
            program = new ShaderProgram(Gdx.files.internal("shader2/shaderVert.vert"),
                    Gdx.files.internal("shader2/shderFrag.glsl"));
        }

        Image image = new Image(Asset.getAsset().getTexture("_floor-58868.png")){
            private float timeDelta = 0;
            @Override
            public void act(float delta) {
                super.act(delta);
                timeDelta += delta;
            }

            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.setShader(program);
                int time = program.getUniformLocation("time");
                program.setUniformf(time,timeDelta);
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        addActor(image);
    }
}
