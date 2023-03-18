package com.tony.rider;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.tony.rider.asset.Asset;
import com.tony.rider.screen.base.BaseScreen;

import java.lang.reflect.AccessibleObject;

public class ScrollPSc extends BaseScreen {
    @Override
    public void show() {
        super.show();
        Table table = new Table(){{
            for (int i = 0; i < 10; i++) {
                add(new Image(Asset.getAsset().getTexture("img/_1-23522.png")));
                row();
            }
        }};
        ScrollPane scrollPane = new ScrollPane(table,new ScrollPane.ScrollPaneStyle());
        addActor(scrollPane);
        scrollPane.setSize(1000,10);
        scrollPane.addAction(Actions.forever(
                Actions.sequence(
                         Actions.delay(0.6f),
                        Actions.run(()->{
                            scrollPane.setHeight(scrollPane.getHeight() + 60);
                        })
                        )
        ));
    }
}
