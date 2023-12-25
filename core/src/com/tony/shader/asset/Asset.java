package com.tony.shader.asset;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Asset {
    private AssetManager assetManager;
    private Asset(){
        assetManager = new AssetManager();
    }

    public Texture getTexture(String s) {
        if (!assetManager.isLoaded(s)) {
            assetManager.load(s,Texture.class);
            assetManager.finishLoading();
        }
        return assetManager.get(s);
    }

    public Sprite loadAtlas(String atlasFile,String name){
        assetManager.load(atlasFile, TextureAtlas.class);
        assetManager.finishLoading();
        TextureAtlas atlas = assetManager.get(atlasFile);
        return atlas.createSprite(name);
    }

    public Sprite findAtlas(){
        assetManager.load("mm/levelAtlas.atlas", TextureAtlas.class);
        assetManager.finishLoading();
        TextureAtlas atlas = assetManager.get("mm/levelAtlas.atlas");
        return atlas.createSprite("ditu");
    }

    public AssetManager getAssetManager() {
        return assetManager;
    }

    static class AssetInstance{
        public static Asset assetInstance = new Asset();
    }

    public static Asset getAsset(){
        return AssetInstance.assetInstance;
    }


}
