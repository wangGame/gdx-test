package com.tony.shader.screen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.kw.gdx.BaseGame;
import com.kw.gdx.screen.BaseScreen;
import com.tony.shader.actor.BufferImage;
import kw.learn.NoiseImage;

public class DemoScreen04 extends BaseScreen {
   public DemoScreen04(BaseGame game) {
      super(game);
   }

   @Override
   public void show() {
      super.show();
//
      BufferImage image = new BufferImage();
      addActor(image);

      Texture buffer = image.getBuffer();
      TextureRegion textureRegion = new TextureRegion(buffer);

      textureRegion.setRegion(0,0,256,256);
      textureRegion.flip(false,true);
      NoiseImage image1 = new NoiseImage();
      addActor(image1);
      addActor(image);
//
//      Image image2 = new Image(textureRegion);
//      addActor(image2);
//      image2.setX(300);

//      EdegeImage image = new EdegeImage(new Texture("Sprite/00012.png"));
//      addActor(image);
//
//      ExpuseImage expuseImage = new ExpuseImage(new Texture("Sprite/00012.png"));
//      addActor(expuseImage);
//      expuseImage.setX(300);

//      Image ixx = new Image(Asset.getAsset().getTexture("baise.png"));
//      addActor(ixx);
//      ixx.setColor(240.0F/255,206.0F/255,185.0F/255,1);
//      ixx.setX(600);
//      ixx.setSize(256,256);
//      EdegeImage image1 = new EdegeImage(new Texture("Sprite/00012.png"));
//      addActor(image1);
//      image1.setX(600);
//      ExpuseImage expuseImage1 = new ExpuseImage(new Texture("Sprite/00012.png"));
//      addActor(expuseImage1);
//      expuseImage1.setX(600);
//      Image xxx = new Image(Asset.getAsset().getTexture("xxxxx.png"));
//      addActor(xxx);
//      xxx.setX(600);
//      GGGGG h = new GGGGG();
//      h.setX(600);
//
//      Texture buffer = h.getBuffer();
//      TextureRegion textureRegion = new TextureRegion(buffer);
//
//
//      textureRegion.flip(false,true);
//      ImageZh image1 = new ImageZh(textureRegion);
//      addActor(h);
//      image1.setColor(194.0f/255, 169.0f/255, 153.0f/255,0.6f);
//      addActor(image1);
//
//      NoiseImage n = new NoiseImage(new Texture("Sprite/00012.png"));
//      addActor(n);
//      n.setX(600);
//      Image xxxxxx = new Image(new Texture("xxx/Texture2D/00012.png"));
//      addActor(xxxxxx);
//      xxxxxx.setX(900);
//



//      Image image = new Image(Asset.getAsset().getTexture("baise.png"));
//      addActor(image);
//      image.setSize(1000,1000);
//      image.setColor(226.0F/255F,198.0F/255F,179.0F/255F,1);


   }
}
