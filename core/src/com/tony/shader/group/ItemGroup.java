package com.tony.shader.group;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import com.kw.gdx.asset.Asset;
import com.kw.gdx.constant.Constant;
import com.kw.gdx.listener.OrdinaryButtonListener;

/**
 * @Auther jian xian si qi
 * @Date 2023/12/25 14:32
 */
public class ItemGroup extends Group {
    private int index;
    public ItemGroup(String text, int i){
        setSize(700,300);
        this.index = i;
        Image bg = new Image(new NinePatch(
                Asset.getAsset().getTexture("white_bg.png"),
                3,3,3,3
        ));
        setOrigin(Align.center);
        addActor(bg);
        bg.setSize(getWidth(),getHeight());
        bg.setColor(Color.valueOf("#AAAAAA"));
        Label label = new Label("",new Label.LabelStyle(){{
            font = Asset.getAsset().loadBitFont("font/inter-middle-28.fnt");
        }});
        addActor(label);
        label.setText(text);
        label.pack();
        label.setY(getHeight()/2.0f, Align.center);
        addListener(new OrdinaryButtonListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                Constant.currentScreen.showDialog(new ShowDetailGroup(index));
            }
        });
    }
}
