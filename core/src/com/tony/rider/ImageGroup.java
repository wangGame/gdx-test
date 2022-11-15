package com.tony.rider;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.tony.rider.asset.Asset;
import com.tony.rider.screen.ImageActor;

public class ImageGroup extends Group {
    private ImageActor imageActor;
    private Image image;
    public ImageGroup(Texture texture){
        image = new Image(Asset.getAsset().getTexture("baise.png"));
        imageActor = new ImageActor(texture);
        setSize(imageActor.getWidth(),imageActor.getHeight());
        addActor(imageActor);
        image.setSize(getWidth(),getHeight());
        image.setColor(229.0F/255, 208.0F/255, 190.0F/255,0F);;
        addActor(image);

    }
}
