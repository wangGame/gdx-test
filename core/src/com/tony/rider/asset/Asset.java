package com.tony.rider.asset;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

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

    static class AssetInstance{
        public static Asset assetInstance = new Asset();
    }

    public static Asset getAsset(){
        return AssetInstance.assetInstance;
    }


}
