package com.tony.shader;

import com.badlogic.gdx.Gdx;
import com.kw.gdx.BaseGame;
import com.kw.gdx.constant.Constant;
import com.tony.shader.screen.DemoScreen;
import com.tony.shader.screen.MainScreen;

public class ShaderUtills extends BaseGame {

    private static ShaderUtills riderGame;

    public ShaderUtills() {
        super();
        riderGame = this;
    }

    protected void loadingView() {
        Gdx.app.postRunnable(()->{
            setScreen(new MainScreen(this));
        });
    }

    public static ShaderUtills instence() {
        if (riderGame ==null){
            System.err.println("error rider is null");
        }
        return riderGame;
    }
}
