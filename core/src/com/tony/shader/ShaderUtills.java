package com.tony.shader;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.CpuPolygonSpriteBatch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.esotericsoftware.spine.SkeletonRenderer;
import com.kw.gdx.BaseGame;
import com.tony.shader.constant.Constant;
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
//            setScreen(new DemoScreen());
//            setScreen(new DemoScreen(this));

        });
    }

    public static ShaderUtills instence() {
        if (riderGame ==null){
            System.err.println("error rider is null");
        }
        return riderGame;
    }
}
