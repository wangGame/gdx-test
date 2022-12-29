package com.tony.rider.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.tony.rider.asset.Asset;

public class ImageGroup extends Image {
   private Texture texture1;
   private ShaderProgram program;
   public ImageGroup(Sprite sprite) {
      super(new SpriteDrawable(sprite));
      if (program == null) {
         program = new ShaderProgram(
                 Gdx.files.internal("chanss/vert.vert"),
                 Gdx.files.internal("chanss/wipeUp.glsl"));
      }

      texture1 = Asset.getAsset().getTexture("noise.png");
      Texture texture = Asset.getAsset().getTexture("xxxxxx.png");
      texture.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);
   }

   float time = 0;
   @Override
   public void act(float delta) {
      super.act(delta);
      time += Gdx.graphics.getDeltaTime()*0.4;
   }

   @Override
   public void draw(Batch batch, float parentAlpha) {
      batch.setShader(program);
      int moveLeft = program.getUniformLocation("time");
      int u_texture1 = program.getUniformLocation("u_texture1");
      Gdx.gl.glActiveTexture(GL20.GL_TEXTURE1);
      texture1.bind();
      program.setUniformi(u_texture1,1);

      Sprite region = ((SpriteDrawable) (getDrawable())).getSprite();
      int u = program.getUniformLocation("u");
      int u2 = program.getUniformLocation("u2");
      int v = program.getUniformLocation("v");
      int v2 = program.getUniformLocation("v2");

      program.setUniformf(u,region.getU());
      program.setUniformf(u2,region.getU2());
      program.setUniformf(v,region.getV());
      program.setUniformf(v2,region.getV2());

      Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);
      program.setUniformf(moveLeft,time);
      super.draw(batch, parentAlpha);
      batch.setShader(null);
   }
}
