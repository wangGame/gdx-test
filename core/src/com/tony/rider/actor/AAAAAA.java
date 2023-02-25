package com.tony.rider.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.tony.rider.AllTest;
import com.tony.rider.asset.Asset;

public class AAAAAA extends Group {
    public AAAAAA() {
        Table table = new Table() {{
            FileHandle internal = Gdx.files.internal("img");
            int index = 0;
            for (FileHandle fileHandle : internal.list()) {
                if (fileHandle.path().endsWith("png")) {
                    AllTest test = new AllTest(Asset.getAsset().getTexture("img/"+fileHandle.name()));
                    add(test);
                    index ++;
                    if (index >= 7){
                        index = 0;
                        row();
                    }
                }
            }
            pack();
        }};

        addActor(table);
    }
}
