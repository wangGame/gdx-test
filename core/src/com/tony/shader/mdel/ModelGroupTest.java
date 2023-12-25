package com.tony.shader.mdel;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.tony.shader.CocosRes;
import com.tony.shader.asset.Asset;

/**
 * @Auther jian xian si qi
 * @Date 2023/5/16 20:08
 *
 * 磨具  实现
 */
public class ModelGroupTest extends Group {
    public ModelGroupTest(){
//        String name [][] = new String[][]{
//                {"jigsawShapeMask_01","jigsawShapeMask_02",
//                        "jigsawShapeMask_03","jigsawShapeMask_04",
//                        "jigsawShapeMask_05","jigsawShapeMask_06",
//                        "jigsawShapeMask_07","jigsawShapeMask_08"},
//                {"jigsawShapeMask_9","jigsawShapeMask_10",
//                        "jigsawShapeMask_11","jigsawShapeMask_01",
//                        "jigsawShapeMask_01","jigsawShapeMask_01",
//                        "jigsawShapeMask_01","jigsawShapeMask_01"},
//                {"jigsawShapeMask_01","jigsawShapeMask_01",
//                        "jigsawShapeMask_01","jigsawShapeMask_01",
//                        "jigsawShapeMask_01","jigsawShapeMask_01",
//                        "jigsawShapeMask_01","jigsawShapeMask_01"},
//                {"jigsawShapeMask_01","jigsawShapeMask_01",
//                        "jigsawShapeMask_01","jigsawShapeMask_01",
//                        "jigsawShapeMask_01","jigsawShapeMask_01",
//                        "jigsawShapeMask_01","jigsawShapeMask_01"},
//                {"jigsawShapeMask_01","jigsawShapeMask_01",
//                        "jigsawShapeMask_01","jigsawShapeMask_01",
//                        "jigsawShapeMask_01","jigsawShapeMask_01",
//                        "jigsawShapeMask_01","jigsawShapeMask_01"},
//                {"jigsawShapeMask_01","jigsawShapeMask_01",
//                        "jigsawShapeMask_01","jigsawShapeMask_01",
//                        "jigsawShapeMask_01","jigsawShapeMask_01",
//                        "jigsawShapeMask_01","jigsawShapeMask_01"},
//                {"jigsawShapeMask_01","jigsawShapeMask_01",
//                        "jigsawShapeMask_01","jigsawShapeMask_01",
//                        "jigsawShapeMask_01","jigsawShapeMask_01",
//                        "jigsawShapeMask_01","jigsawShapeMask_01"},
//                {"jigsawShapeMask_01","jigsawShapeMask_01",
//                        "jigsawShapeMask_01","jigsawShapeMask_01",
//                        "jigsawShapeMask_01","jigsawShapeMask_01",
//                        "jigsawShapeMask_01","jigsawShapeMask_01"},
//        };

        Texture texture = Asset.getAsset().getTexture("pic/test.png");
        int width = texture.getWidth();
        int height = texture.getHeight();
        int i1 = width / 8;
        int i2 = height / 8;

        Group group = CocosRes.loadFile("cocos/start_16.json");

        float startU = 0.0f;
        float startV = 0.0f;
        float startX = 0.0f;
        float startY = 0.0f;
        int in = 0;
        for (int i3 = 0; i3 < 6; i3++) {
            startX = 0;
            for (int i4 = 0; i4 < 6; i4++) {
                in ++;
                String picName = in+"";
                if (in<10){
                    picName = "0"+picName;
                }
                Actor actor = group.findActor("kuai" + i3 * 6 + (i4 + 1));
                ModelGroup maskImage = new ModelGroup("pic/jigsawShapeMask_"+picName+".png");
//                ModelGroup maskImage = new ModelGroup("pic/model.png");
                addActor(maskImage);
                // 磨具/磨具宽（高）  == i1（i2）/游戏宽高
                maskImage.setSize(i1+65,i2+65);
                maskImage.setX(startX);
                maskImage.setY(height - startY);
                //startX（starY） / 游戏宽（高）
                maskImage.setStartU(startX/width+0.0f*i1/width);
                startX = startX + i1;
                maskImage.setStartV(startY/height+0.0f*i2/height);
                //i1（i2）/游戏宽


            }
            startY = startY + i2;
        }
        setScale(1.3f);
    }
}
