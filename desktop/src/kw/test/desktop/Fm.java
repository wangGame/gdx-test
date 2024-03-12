package kw.test.desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.kw.gdx.asset.Asset;
import com.kw.gdx.constant.Constant;
import com.kw.gdx.listener.OrdinaryButtonListener;
import com.kw.gdx.resource.annotation.GameInfo;
import com.libGdx.test.base.LibGdxTestMain;

@GameInfo(width = 900,height = 900)
public class Fm extends LibGdxTestMain {
    public static void main(String[] args) {
        Fm f = new Fm();
        f.start();
    }
    private float num1;
    private float num2;
    private float num3;
    private float num4;
    private float num5;
    private float num6;
    @Override
    public void useShow(Stage stage) {
        super.useShow(stage);
//        num1:0.10000002   num2:1.1000001   num3:1.4901161E-8
        ImagePre imagePre = new ImagePre("1_115_29_512.jpg");
        addActor(imagePre);
        imagePre.setPosition(0,400);

        Image image = new Image(Asset.getAsset().getTexture("target1.png"));
        addActor(image);
        image.setPosition(500,400);

        Table n = new Table(){{
            Image image1 = new Image(Asset.getAsset().getTexture("Soft.png"));
            add(image1);
            image1.addListener(new OrdinaryButtonListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                    num1+=0.1f;
                    imagePre.setNum1(num1);
                }
            });
            Image image2 = new Image(Asset.getAsset().getTexture("Soft.png"));
            add(image2);
            image2.addListener(new OrdinaryButtonListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                    num1-=0.1f;

                    imagePre.setNum1(num1);
                }
            });

            Image image3 = new Image(Asset.getAsset().getTexture("Soft.png"));
            add(image3);
            image3.addListener(new OrdinaryButtonListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                    num2+=0.1f;

                    imagePre.setNum2(num2);
                }
            });

            Image image4 = new Image(Asset.getAsset().getTexture("Soft.png"));
            add(image4);
            image4.addListener(new OrdinaryButtonListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                    num2-=0.1f;

                    imagePre.setNum2(num2);
                }
            });
            Image image5 = new Image(Asset.getAsset().getTexture("Soft.png"));
            add(image5);
            image5.addListener(new OrdinaryButtonListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                    num3+=0.1f;

                    imagePre.setNum3(num3);
                }
            });
            Image image6 = new Image(Asset.getAsset().getTexture("Soft.png"));
            add(image6);
            image6.addListener(new OrdinaryButtonListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                    num3-=0.1f;

                    imagePre.setNum3(num3);
                }
            });
//            image1.setScale(0.3f);
//            image2.setScale(0.3f);
//            image3.setScale(0.3f);
//            image4.setScale(0.3f);
//            image5.setScale(0.3f);
//            image6.setScale(0.3f);

            pack();
        }};
        addActor(n);
        n.setY(1000);

//        ScrollPane pane = new ScrollPane(new Table(){{
//            FileHandle internal = Gdx.files.internal("artdengm");
//            for (FileHandle fileHandle : internal.list()) {
//
//                Image image = new Image(Asset.getAsset().getTexture("artdengm/"+fileHandle.name()));
//                add(image);
//                row();
//            }
//            pack();
//        }});
//        addActor(pane);
//        pane.setSize(Constant.GAMEWIDTH, Constant.GAMEHIGHT);

    }
}
