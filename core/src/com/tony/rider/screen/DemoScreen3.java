package com.tony.rider.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.tony.rider.ImageGroup;
import com.tony.rider.screen.base.BaseScreen;

public class DemoScreen3 extends BaseScreen {
    @Override
    public void show() {
        super.show();
        addActor(new Table(){{
            FileHandle sprite = Gdx.files.internal("Sprite");
            int index = 0;
            int count = 14;
            for (FileHandle fileHandle : sprite.list()) {
                ImageGroup imageGroup = new ImageGroup(new Texture(fileHandle.path()));
                add(imageGroup).pad(20);
                index ++;
                count --;
                if (count<0)break;
                if (index>3){
                    index = 0;
                    row();
                }
            }
            pack();
        }});
        addActor(new Table(){{
            FileHandle sprite = Gdx.files.internal("xxx/Sprite");
            int index = 0;
            int count = 14;
            for (FileHandle fileHandle : sprite.list()) {
                Image imageActor = new Image(new Texture(fileHandle.path()));
                add(imageActor).pad(20);
                index ++;
                count --;
                if (count<0)break;
                if (index>3){
                    index = 0;
                    row();
                }
            }
            pack();
            setPosition(1200,0);
        }});

        addActor(new Table(){{
            FileHandle sprite = Gdx.files.internal("Sprite/");
            int index = 0;
            int count = 14;
            for (FileHandle fileHandle : sprite.list()) {
                Image imageActor = new Image(new Texture(fileHandle.path()));
                add(imageActor).pad(20);
                index ++;
                count --;
                if (count<0)break;
                if (index>3){
                    index = 0;
                    row();
                }
            }
            pack();
            setPosition(2700,0);
        }});
    }
}
