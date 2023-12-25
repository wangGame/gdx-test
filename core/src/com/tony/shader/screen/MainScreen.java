package com.tony.shader.screen;

import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.kw.gdx.constant.Constant;
import com.tony.shader.group.ItemGroup;
import com.tony.shader.screen.base.BaseScreen;

public class MainScreen extends BaseScreen {
    @Override
    public void show() {
        ScrollPane pane = new ScrollPane(new Table(){{
            add(new ItemGroup("show bei sai er",0)).row();
            add(new ItemGroup("mesh ",1));
            pack();

            align(Align.top);
        }});
        addActor(pane);
        pane.setSize(Constant.GAMEWIDTH,Constant.GAMEHIGHT);
    }
}
