package kw.learn;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.kw.gdx.asset.Asset;

import kw.learn.base.BaseGroup;

public class DissolveImage extends BaseGroup {
   private Texture texture1;
   public DissolveImage() {
      super(new Sprite(Asset.getAsset().getTexture("_Background-58852.png")));
      vertShader = "realseshader/common.vert";
      frangShader = "realseshader/dissolve.glsl";
      texture1 = Asset.getAsset().getTexture("noise.png");
      Texture texture = Asset.getAsset().getTexture("xxxxxx.png");
      texture.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);
   }

   @Override
   public void draw(Batch batch, float parentAlpha) {
      batch.setShader(program);
      int moveLeft = program.getUniformLocation("time");
      int u_texture1 = program.getUniformLocation("u_texture1");
      Gdx.gl.glActiveTexture(GL20.GL_TEXTURE1);
      texture1.bind();
      program.setUniformi(u_texture1,1);
      TextureRegionDrawable regionDrawable = ((TextureRegionDrawable) (getDrawable()));
      int u = program.getUniformLocation("u");
      int u2 = program.getUniformLocation("u2");
      int v = program.getUniformLocation("v");
      int v2 = program.getUniformLocation("v2");
      TextureRegion region = regionDrawable.getRegion();
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
