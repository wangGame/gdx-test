package com.tony.shader;

import com.badlogic.gdx.Gdx;
import com.kw.gdx.BaseGame;
import com.kw.gdx.constant.Constant;
import com.kw.gdx.resource.annotation.GameInfo;
import com.tony.shader.screen.MainScreen;

@GameInfo(width = 720,height = 720)
public class ShaderUtills extends BaseGame {
    private static ShaderUtills riderGame;

    public ShaderUtills() {
        super();
        riderGame = this;
    }

    protected void loadingView() {
        Constant.viewColor.set(1.0f,1.0f,1.f,1.0f);
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
