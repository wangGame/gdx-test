package com.tony.rider;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.esotericsoftware.spine.SkeletonRenderer;
import com.tony.rider.constant.Constant;
import com.tony.rider.screen.DemoScreen;
import com.tony.rider.screen.LoadingScreen;
import com.tony.rider.screen.PzScreen;

public class RiderGame extends Game {
    private Batch batch;
    private ExtendViewport stageViewport;
    private SkeletonRenderer renderer;
    private static RiderGame riderGame;

    public RiderGame() {

    }

    @Override
    public void create() {
        initInstance();
        initViewport();
        loadRsource();
        loadingView();
    }

    private void loadRsource() {

    }

    private void loadingView() {
        Gdx.app.postRunnable(()->{
            setScreen(new DemoScreen());
        });
    }

    private void initInstance(){
        Gdx.input.setCatchBackKey(true);
        riderGame = this;
    }

    private void initViewport() {
        stageViewport = new ExtendViewport(Constant.WIDTH,Constant.HIGHT);
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width,height);
        viewPortResize(width, height);
    }

    private void viewPortResize(int width, int height) {
        stageViewport.update(width,height);
        stageViewport.apply();
        Constant.GAMEWIDTH = stageViewport.getWorldWidth();
        Constant.GAMEHIGHT = stageViewport.getWorldHeight();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(229.0F/255, 208.0F/255, 190.0F/255,1);
//        Gdx.gl.glClearColor(1f,1f,1f,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        super.render();
    }

    public SkeletonRenderer getRenderer() {
        if (renderer == null){
            renderer = new SkeletonRenderer();
        }
        return renderer;
    }

    public ExtendViewport getStageViewport() {
        return stageViewport;
    }

    public Batch getBatch() {
        if (batch==null) {
            batch = new SpriteBatch();
        }
        return batch;
    }

    public static RiderGame instence() {
        if (riderGame ==null){
            System.err.println("error rider is null");
        }
        return riderGame;
    }

    @Override
    public void dispose() {
        if (batch!=null) {
            batch.dispose();
            batch = null;
        }
    }
}
