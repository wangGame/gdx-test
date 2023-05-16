package com.tony.rider.mdel;

import com.badlogic.gdx.scenes.scene2d.Group;

/**
 * @Auther jian xian si qi
 * @Date 2023/5/16 20:08
 *
 * д╔╬ъ  й╣ож
 */
public class ModelGroupTest extends Group {
    public ModelGroupTest(){
        String name [] = new String[]{
                "round36_4.png",
                "round64_38.png"
        };
        int i = 0;
        for (String string : name) {
            ModelGroup maskImage = new ModelGroup(string);
            addActor(maskImage);
            maskImage.setX(280 * i);
            i++;
            maskImage.setY(200*i);
        }
    }
}
