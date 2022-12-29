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
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.tony.rider.asset.Asset;

public class ImageGroup2 extends Group {
   private ShaderProgram program;
   public ImageGroup2(float width,float height) {
      if (program == null){
         program = new ShaderProgram(
                 Gdx.files.internal("chanss/vert.vert"),
                 Gdx.files.internal("chanss/wipeDown.glsl"));
      }

      Sprite sprite = Asset.getAsset().loadAtlas("levelAtlas.atlas",
              "2_dizuo");
      Texture texture = Asset.getAsset().getTexture("_teapot-58878.png");
      texture.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);
      Texture texture1 = Asset.getAsset().getTexture("noise.png");
      Image image = new Image(texture){
         float time = 0;
         @Override
         public void act(float delta) {
            super.act(delta);
            time += Gdx.graphics.getDeltaTime();
         }

         @Override
         public void draw(Batch batch, float parentAlpha) {
            batch.setShader(program);
            int moveLeft = program.getUniformLocation("time");
            int u_texture1 = program.getUniformLocation("u_texture1");
            Gdx.gl.glActiveTexture(GL20.GL_TEXTURE1);
            texture1.bind();
            program.setUniformi(u_texture1,1);

            TextureRegion region = ((TextureRegionDrawable) (getDrawable())).getRegion();
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
      };
      image.setSize(width,height);
      addActor(image);
   }
}