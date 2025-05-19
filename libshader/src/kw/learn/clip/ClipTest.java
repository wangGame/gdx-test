package kw.learn.clip;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Align;
import com.kw.gdx.asset.Asset;
import com.kw.gdx.constant.Constant;

/**
 * @Auther jian xian si qi
 * @Date 2023/8/22 18:10
 */
public class ClipTest extends Group {
    private Image srcKuang;
    private Image levelPic;
    private Image levelItemKuang;
    private boolean flag = false;
    private final float srcWidth = 520-20;
    private final float srcHeght = 684-20;
    private final float endWidth = 324;

    public ClipTest(){
//        ValueTool tool = new ValueTool();
//        tool.setStart(srcWidth);
//        tool.setEnd(endWidth);
//        tool.setDuration(0.5333f);
//        tool.setInterpolation(new BseInterpolation(
//                0.0444f,
//                0.4777f,
//                0.48f,
//                1.0f
//        ));
//        ValueTool tool1 = new ValueTool();
//        tool1.setStart(srcHeght);
//        tool1.setEnd(endWidth);
//        tool1.setDuration(0.53333f);
//        tool1.setInterpolation(new BseInterpolation(
//                0.0444f,
//                0.4777f,
//                0.48f,
//                1.0f
//        ));
        levelItemKuang = new Image(new NinePatch(
                Asset.getAsset().getTexture("test.png"),
                30,30,30,30));
        levelPic = new Image(Asset.getAsset().getTexture("noise.png")){
            private float clipOffSetX;
            private float clipOffsetY;
            @Override
            public void act(float delta) {
                super.act(delta);
                if (flag) {

//                    clipOffSetX = Math.abs(tool.getValue());
//                    clipOffsetY = Math.abs(tool1.getValue());
                }
            }

            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.flush();
                srcKuang.setSize(ClipTest.this.getWidth()- clipOffSetX,ClipTest.this.getHeight()- clipOffsetY);
                srcKuang.setPosition(ClipTest.this.getWidth()/2,ClipTest.this.getHeight()/2,Align.center);
                levelItemKuang.setSize(levelPic.getWidth() - clipOffSetX, levelPic.getHeight() - clipOffsetY);
                levelItemKuang.setPosition(ClipTest.this.getWidth()/2,ClipTest.this.getHeight()/2,Align.center);
                if (clipBegin(getX()+ clipOffSetX /2.0f,getX()+ clipOffsetY /2.0f,
                        getWidth()- clipOffSetX,getHeight()- clipOffsetY)) {
                    super.draw(batch, parentAlpha);
                    batch.flush();
                    clipEnd();
                }
            }
        };
        setSize(srcWidth,srcHeght);
        addActor(levelPic);
        levelPic.setSize(srcWidth,srcHeght);
        levelPic.setPosition(getWidth()/2,getHeight()/2, Align.center);
        srcKuang = new Image(new NinePatch(
                Asset.getAsset().getTexture("test.png"),
                40,40,40,40)){
            float clipOffsetX = 0;
            float clipOffsetY = 0;
            float ra = 0.f;
            private ShaderProgram program = new ShaderProgram(
                    Gdx.files.internal("gamee/line.vert"),
                    Gdx.files.internal("gamee/line1.frag")
                    );
            @Override
            public void act(float delta) {
                super.act(delta);
                if (flag) {
                    clipOffsetX += delta * 130;
                    clipOffsetY += delta * 130;
                    ra += delta*150;
                    if (ra > 0.3f) {
                        ra = 0.3f;
                    }
                }
            }

            @Override
            public void draw(Batch batch, float parentAlpha) {
                    batch.flush();
                    batch.setShader(program);
                    if (clipBegin(getX()+ clipOffsetX /2.0f,getY()+ clipOffsetY /2.0f,
                            getWidth()- clipOffsetX,getHeight()- clipOffsetY)) {
                        super.draw(batch, parentAlpha);
                        batch.flush();
                        clipEnd();
                    }
                    batch.setShader(null);
            }
        };
        addActor(srcKuang);
        srcKuang.setSize(getWidth(),getHeight());
        srcKuang.setPosition(getWidth()/2,getHeight()/2,Align.center);
        addActor(levelItemKuang);
        setPosition(Constant.GAMEWIDTH/2.0f,Constant.GAMEHIGHT/2.0f,Align.center);
        setOrigin(Align.center);
        addAction(
                Actions.sequence(
                        Actions.delay(4.3333f),
//                        Actions.scaleTo(1.1f,1.1f,0.333f,new BseInterpolation(
//                                0.035f,0,0.75f,1.0f
//                        )),
//                        Actions.scaleTo(1.0f,1.0f,0.1f,new BseInterpolation(
//                                0.356f,0.48f,0.786f,1.0f
//                        )),
                        Actions.run(new Runnable() {
                            @Override
                            public void run() {
                                flag = true;
//                                addAction(tool);
//                                addAction(tool1);
                            }
                        })));
        levelItemKuang.getColor().a = 0;
        levelItemKuang.addAction(Actions.sequence(Actions.delay(0.3f,Actions.fadeIn(0.1667f))));
//        img ->0  0.83333f    新 0.6-> 0.83333f
        addAction(
                Actions.delay(4,Actions.moveToAligned(500,500,Align.center,0.4f)));

    }
}
