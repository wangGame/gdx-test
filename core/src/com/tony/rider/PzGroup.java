package com.tony.rider;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.tony.rider.asset.Asset;
import com.tony.rider.constant.Constant;

public class PzGroup extends Group {
    
    private Array<Image> array = new Array<>();

    private Array<Image> temp = new Array<>();

    public PzGroup(){

        for (int i = 0; i < 30; i++) {
            Image image = new Image(Asset.getAsset().getTexture("Soft.png"));
            addActor(image);
            array.add(image);
            image.setPosition(i * 100,1700);
        }
        
        setSize(Constant.GAMEWIDTH,Constant.GAMEHIGHT-100);
        setY(100);
        setDebug(true);
        addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println(x+"   "+y);
                drawPoint(x,y);
                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                for (Image image : temp) {
                    image.remove();
                }
                temp.clear();
                drawPoint(x,y);
                super.touchDragged(event, x, y, pointer);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
            }
        });
    }

    boolean sss =false;
    private void drawPoint(float x, float y) {
        Vector2 start = new Vector2(Constant.GAMEWIDTH/2,0);
        Vector2 end = new Vector2(x,y);
        Vector2 twoPointMinus = end.sub(start);
        sss = false;
        int index = 0;
        while (true){
            index += 120;
            Vector2 star = new Vector2(start);
            Vector2 vector2 = new Vector2(1 * index, 0);  //水平向量
            vector2.setAngle(twoPointMinus.angle()); //设置参数
            Vector2 target = new Vector2(star.add(vector2)); // 目标值
            Image image = new Image(Asset.getAsset().getTexture("Soft.png"));
            addActor(image);
            temp.add(image);
            image.setPosition(target.x, target.y, Align.center);

            for (Image image1 : array) {
                Vector2 tm = new Vector2(image1.getX(Align.center),image1.getY(Align.center));
                if (tm.dst(target)<140) {
                    extens(target, -twoPointMinus.angle());
                    sss = true;
                    break;
                }
            }

            if (sss){
                break;
            }

            if (target.y > getHeight()||target.y<0) {
                extens(target, -twoPointMinus.angle());
                break;
            }
            if (target.x < 0 || target.x > Constant.GAMEWIDTH){
                extens(target, 180-twoPointMinus.angle());
                break;
            }
        }
    }

    private void extens(Vector2 target, float v) {
        for (int i = 1; i < 500; i += 120) {
            Vector2 star1 = new Vector2(target);
            Vector2 end1 = new Vector2(1 * i, 0);  //水平向量
            end1.setAngle(v); //设置参数
            Vector2 target1 = new Vector2(star1.add(end1)); // 目标值
            Image image1 = new Image(Asset.getAsset().getTexture("Soft.png"));
            addActor(image1);
            image1.setPosition(target1.x, target1.y, Align.center);
            temp.add(image1);
        }
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
