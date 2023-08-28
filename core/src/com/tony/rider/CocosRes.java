package com.tony.rider;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.tony.rider.asset.Asset;
import com.ui.ManagerUIEditor;
import com.ui.loader.ManagerUILoader;

/**
 * @Auther jian xian si qi
 * @Date 2023/8/5 18:10
 */
public class CocosRes {
    public static Group loadFile(String resourcePath){
        if (resourcePath!=null) {
            if (!Asset.getAsset().getAssetManager().isLoaded(resourcePath)){
                ManagerUILoader.ManagerUIParameter managerUIParameter1 =
                        new ManagerUILoader.ManagerUIParameter("cocos/", Asset.getAsset().getAssetManager());
                Asset.getAsset().getAssetManager().load(resourcePath, ManagerUIEditor.class, managerUIParameter1);
                Asset.getAsset().getAssetManager().finishLoading();
            }
            ManagerUIEditor managerUIEditor = Asset.getAsset().getAssetManager().get(resourcePath);
            return managerUIEditor.createGroup();
        }
        return new Group();
    }
}
