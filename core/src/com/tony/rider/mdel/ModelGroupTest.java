package com.tony.rider.mdel;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.tony.rider.asset.Asset;

/**
 * @Auther jian xian si qi
 * @Date 2023/5/16 20:08
 *
 * д╔╬ъ  й╣ож
 */
public class ModelGroupTest extends Group {
    public ModelGroupTest(){
        String name [][] = new String[][]{
                {"model"}
        };
        Texture texture = Asset.getAsset().getTexture("pic/test.png");
        int width = texture.getWidth();
        int height = texture.getHeight();
        int i1 = width / 10;
        int i2 = height / 10;
        for (int i3 = 0; i3 < name.length; i3++) {
            for (int i4 = 0; i4 < name[0].length; i4++) {
                ModelGroup maskImage = new ModelGroup("pic/model.png");
                addActor(maskImage);
                maskImage.setSize(i1,i2);
                maskImage.setStartU(i4/10.0f);
                maskImage.setStartV((10-i3-1)/10.0f);
                maskImage.setX((i1) * i4);
                maskImage.setY((i2) *(i3));
            }
        }
    }
}
