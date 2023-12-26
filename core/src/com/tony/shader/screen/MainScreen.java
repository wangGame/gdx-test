package com.tony.shader.screen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.kw.gdx.BaseGame;
import com.kw.gdx.constant.Constant;
import com.kw.gdx.screen.BaseScreen;
import com.tony.shader.asset.Asset;
import com.tony.shader.group.ItemGroup;

import kw.learn.constant.ShaderType;

public class MainScreen extends BaseScreen {
    public MainScreen(BaseGame game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();
        ScrollPane pane = new ScrollPane(new Table(){{
            add(new ItemGroup("LUMIN",ShaderType.LUMIN)).pad(20);
            add(new ItemGroup("EDG",ShaderType.EDG)).pad(20);
            row();
            add(new ItemGroup("EXPOSURE",ShaderType.EXPOSURE)).pad(20);
            add(new ItemGroup("DISSOLVE",ShaderType.DISSOLVE)).pad(20);
            row();
//            add(new ItemGroup("DISSOLVE2",ShaderType.DISSOLVE2)).pad(20);
            add(new ItemGroup("NOISEONE",ShaderType.NOISEONE)).pad(20);
            add(new ItemGroup("SOLARIZE",ShaderType.SOLARIZE)).pad(20);

            pack();
            align(Align.top);
        }});
//        addActor(pane);
        pane.setSize(Constant.GAMEWIDTH, Constant.GAMEHIGHT);
        Texture texture = Asset.getAsset().getTexture("test.png");


    }
}
