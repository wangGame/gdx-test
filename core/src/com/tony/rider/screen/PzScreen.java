package com.tony.rider.screen;

import com.tony.rider.PzGroup;
import com.tony.rider.screen.base.BaseScreen;

public class PzScreen extends BaseScreen {
    @Override
    public void show() {
        super.show();
        addActor(new PzGroup());
    }
}
