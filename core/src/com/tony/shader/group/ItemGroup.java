package com.tony.shader.group;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import com.kw.gdx.asset.Asset;
import com.kw.gdx.constant.Constant;
import com.kw.gdx.listener.OrdinaryButtonListener;
import kw.learn.meiju.ItemType;

/**
 * @Auther jian xian si qi
 * @Date 2023/12/25 14:32
 */
public class ItemGroup extends Group {
    public ItemGroup(ItemType type){
        setSize(Constant.GAMEWIDTH - 100,100);
        setOrigin(Align.center);
        Label label = new Label("",new Label.LabelStyle(){{
            font = Asset.getAsset().loadBitFont("font/inter-middle-28.fnt");
        }});
        label.setFontScale(2);
        addActor(label);
        label.setText(type.name());
        label.pack();
        label.setColor(Color.BLACK);
        label.setX(getWidth()/2.f,Align.center);
        label.setY(50, Align.center);
        addListener(new OrdinaryButtonListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                Constant.currentActiveScreen.showDialog(new ShowDetailGroup(type));
            }
        });
    }
}
