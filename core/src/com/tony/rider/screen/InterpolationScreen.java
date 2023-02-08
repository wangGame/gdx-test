package com.tony.rider.screen;

import com.tony.rider.interpolation.Pow2InInverseGroup;
import com.tony.rider.interpolation.PowGroup;
import com.tony.rider.interpolation.PowInGroup;
import com.tony.rider.interpolation.PowOutGroup;
import com.tony.rider.interpolation.SinGroup;
import com.tony.rider.interpolation.SmoothGroup;
import com.tony.rider.interpolation.SmoothGroup2;
import com.tony.rider.interpolation.Smoother;
import com.tony.rider.interpolation.SwingGroup;
import com.tony.rider.screen.base.BaseScreen;

public class InterpolationScreen extends BaseScreen {
    @Override
    public void show() {
        super.show();
//      smooth
//        smooth();
//        smooth2();
//        Interpolation
//        smoother();
//        powGroup();
//        powInGroup();
//        powOutGroup();
//        pow2InInverse();
//        sinGroup();
        swingGroup();
    }

    private void swingGroup() {
        SwingGroup group = new SwingGroup();
        addActor(group);
        group.setPosition(100,100);
    }

    private void sinGroup() {
        SinGroup group = new SinGroup();
        addActor(group);
        group.setPosition(100,100);
    }

    private void pow2InInverse() {
        Pow2InInverseGroup group = new Pow2InInverseGroup();
        addActor(group);
        group.setPosition(100,100);
    }

    private void powOutGroup() {
        PowOutGroup group = new PowOutGroup();
        addActor(group);
        group.setPosition(100,100);
    }

    private void powInGroup() {
        PowInGroup group = new PowInGroup();
        addActor(group);
        group.setPosition(100,100);
    }


    private void powGroup() {
        PowGroup group = new PowGroup();
        addActor(group);
        group.setPosition(100,100);
    }

    private void smoother() {
        Smoother group = new Smoother();
        addActor(group);
        group.setPosition(100,100);
    }

    private void smooth2() {
        SmoothGroup2 group = new SmoothGroup2();
        addActor(group);
        group.setPosition(100,100);
    }

    private void smooth() {
        SmoothGroup group = new SmoothGroup();
        addActor(group);
        group.setPosition(100,100);
    }
}
