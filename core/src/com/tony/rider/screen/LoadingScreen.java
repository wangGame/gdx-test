package com.tony.rider.screen;

import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.tony.rider.screen.base.BaseScreen;

public class LoadingScreen extends BaseScreen {

    private float time;
    public LoadingScreen() {
        super();
//        OrthOcamPostionDemo orthographicCamera = new OrthOcamPostionDemo();
//        addActor(orthographicCamera);D
//        orthographicCamera.init();

//        AssetManager assetManager = new AssetManager();
//        assetManager.load("test.png", Texture.class);
//        assetManager.finishLoading();
//        Texture text = assetManager.get("test.png");
//        Image image = new Image(text);
//        stage.addActor(image);

    }

    @Override
    public void show() {
        super.show();
        stage.addAction(Actions.delay(0,Actions.run(()->{
            setScreen(new InterpolationScreen());
        })));
    }
}
