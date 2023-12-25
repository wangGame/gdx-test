package com.tony.shader.screen;

import com.tony.shader.PzGroup;
import com.tony.shader.screen.base.BaseScreen;

public class PzScreen extends BaseScreen {
    @Override
    public void show() {
        super.show();
        addActor(new PzGroup());
    }
}
