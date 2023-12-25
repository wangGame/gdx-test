package com.tony.shader.screen;

import com.kw.gdx.BaseGame;
import com.kw.gdx.screen.BaseScreen;
import com.tony.shader.PzGroup;

public class PzScreen extends BaseScreen {

    public PzScreen(BaseGame game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();
        addActor(new PzGroup());
    }
}
