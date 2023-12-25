package com.tony.shader.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.kw.gdx.BaseGame;
import com.kw.gdx.screen.BaseScreen;
import com.tony.shader.asset.Asset;

/**
 * @Auther jian xian si qi
 * @Date 2023/3/18 11:15
 */
public class ShaderScreen extends BaseScreen {
    private ShaderProgram program;

    public ShaderScreen(BaseGame game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();
//        CirShape shape = new CirShape();
//        addActor(shape);

//        ChangeImage changeImage = new ChangeImage();

//        Image image = new Image(Asset.getAsset().getTexture("game.png"));
//        addActor(image);
//        image.setScale(7);
//        image.setScale(10);
        FileHandle internal = Gdx.files.internal("anglary/divice.vert");
        FileHandle internal1 = Gdx.files.internal("anglary/spriteclone.glsl");

        program = new ShaderProgram(internal,internal1);
        Group g = new Group(){
            private float tyt = 0;
            @Override
            public void act(float delta) {
                super.act(delta);
                tyt += delta;
            }

            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.flush();
                batch.setShader(program);
//                program.setUniformf("time",tyt);
                super.draw(batch, parentAlpha);
                batch.flush();
                batch.setShader(null);
            }
        };
        addActor(g);
        Image image = new Image(Asset.getAsset().getTexture("ttttttt.png"));
        g.addActor(image);

    }

}
