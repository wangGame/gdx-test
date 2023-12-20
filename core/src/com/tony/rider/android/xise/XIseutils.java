package com.tony.rider.android.xise;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.ScreenUtils;

/**
 * @Auther jian xian si qi
 * @Date 2023/12/20 15:19
 */
public class XIseutils {

    public static Pixmap getColorAtPixel(int x, int y) {
        Pixmap pixmap = ScreenUtils.getFrameBufferPixmap(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        return pixmap;
    }
}
