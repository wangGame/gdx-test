package kw.learn;

import com.kw.gdx.BaseGame;
import com.kw.gdx.screen.BaseScreen;
import kw.learn.interpolation.ExpGroup;
import kw.learn.interpolation.InterpolationShaderType;
import kw.learn.interpolation.Pow2InInverseGroup;
import kw.learn.interpolation.PowGroup;
import kw.learn.interpolation.PowInGroup;
import kw.learn.interpolation.PowOutGroup;
import kw.learn.interpolation.SinGroup;
import kw.learn.interpolation.SinInGroup;
import kw.learn.interpolation.SinOutGroup;
import kw.learn.interpolation.SmoothGroup;
import kw.learn.interpolation.SmoothGroup2;
import kw.learn.interpolation.Smoother;
import kw.learn.interpolation.SwingGroup;

public class InterpolationScreen extends BaseScreen {
    public InterpolationScreen(BaseGame game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();
//        linear();
//      smooth
//        smooth();
//        smooth2();
//        Interpolation
//        smoother();

//        powGroup();
//        powInGroup();
//        powOutGroup();
//
//        slowFast();
//        pow2InInverse();
//        sinGroup();

//        sinInGroup();
//         sinOutGroup();
//        swingGroup();

//        exp();


//        Table table = new Table(){{
//            add(new SmoothGroup2()).pad(20);
//            add(new SmoothGroup()).pad(20);
//            row();
//            add(new Smoother()).pad(20);
//
//            row();
//            add(new PowGroup()).pad(20);
//            add(new PowInGroup()).pad(20);
//
//            row();
//            add(new PowOutGroup()).pad(20);

//            add(new SwingGroup()).pad(20);
//            row();
//            add(new SinGroup()).pad(20);
//            add(new Pow2InInverseGroup()).pad(20);
//            pack();
//        }};
//        ScrollPane pane = new ScrollPane(table,new ScrollPane.ScrollPaneStyle());
//        addActor(pane);
//        pane.setSize(Constant.GAMEWIDTH,Constant.GAMEHIGHT);
    }

//    public void exp(){
//        ExpGroup expGroup = new ExpGroup(InterpolationShaderType.EXPOSE);
//        addActor(expGroup);
//    }

    private void sinOutGroup() {
        SinOutGroup sinOutGroup = new SinOutGroup();
        sinOutGroup.setPosition(100,100);
        addActor(sinOutGroup);
    }

    private void sinInGroup() {
        SinInGroup group = new SinInGroup();
        addActor(group);
        group.setPosition(100,100);
    }

    private void slowFast() {
        //slowFast = pow2In
        //fastSlow = pow2Out
    }

    private void linear() {
//        LinearGroup linearGroup = new LinearGroup();
//        addActor(linearGroup);
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
