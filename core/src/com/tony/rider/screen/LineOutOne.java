package com.tony.rider.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class LineOutOne extends Image {
   private ShaderProgram shadowProgram;
   private float time = 0;
   private Texture texture;
   private boolean startAnimation = false;
   private Sprite sprite;
   public LineOutOne(Sprite sprite){
      super(new SpriteDrawable(sprite));
      this.sprite = sprite;
      shadowProgram = new ShaderProgram(
              Gdx.files.internal("shader4/line.vert"),Gdx.files.internal("shader4/line.frag"));
      texture = new Texture("shader4/noise.png");
   }

   @Override
   public void act(float delta) {
      super.act(delta);
      time+=delta*0.5f;

   }

   @Override
   public void draw(Batch batch, float parentAlpha) {
      if (shadowProgram!=null&&startAnimation) {
         batch.setShader(shadowProgram);
         int timeLocation = shadowProgram.getUniformLocation("time");
         int v = shadowProgram.getUniformLocation("v");
         int v1 = shadowProgram.getUniformLocation("v1");
         int u = shadowProgram.getUniformLocation("u");
         int u1 = shadowProgram.getUniformLocation("u1");
         shadowProgram.setUniformf(v,sprite.getV());
         shadowProgram.setUniformf(v1,sprite.getV2());
         shadowProgram.setUniformf(u,sprite.getU());
         shadowProgram.setUniformf(u1,sprite.getU2());
         shadowProgram.setUniformf(timeLocation,time);
         super.draw(batch, parentAlpha);
         batch.setShader(null);
      }
   }

   public void setAnimation() {
      startAnimation = true;
      time = 0.5f;
   }
}

