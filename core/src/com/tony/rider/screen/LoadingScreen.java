package com.tony.rider.screen;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.tony.rider.demo.orthocame.OrthOcamPostionDemo;
import com.tony.rider.screen.base.BaseScreen;

public class LoadingScreen extends BaseScreen {
    public LoadingScreen() {
        super();
//        OrthOcamPostionDemo orthographicCamera = new OrthOcamPostionDemo();
//        addActor(orthographicCamera);
//        orthographicCamera.init();

        AssetManager assetManager = new AssetManager();
        assetManager.load("demo.png", Texture.class);
        assetManager.load("demo.png", Texture.class);

        assetManager.finishLoading();
        Texture text = assetManager.get("demo.png");
        Image image = new Image(text);
        stage.addActor(image);

        System.out.println("-----------------------");


    }

    @Override
    public void show() {
        super.show();
    }

}
