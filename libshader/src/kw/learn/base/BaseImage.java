package kw.learn.base;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Scaling;
import com.kw.gdx.asset.Asset;

public abstract class BaseImage extends Image {
   protected String vertShader = "realseshader/common.vert";
   protected String frangShader;
   protected ShaderProgram program;
   protected float time;
   protected String pre = "realseshader/";

   public BaseImage() {
      //测试图片
      this(Asset.getAsset().getTexture("test.png"));
   }

   public BaseImage(Drawable drawable) {
      this(drawable, Scaling.stretch, 1);
   }

   public BaseImage(NinePatch patch) {
      this(new NinePatchDrawable(patch), Scaling.stretch, 1);
   }

   public BaseImage(TextureRegion region) {
      this(new TextureRegionDrawable(region), Scaling.stretch, 1);
   }

   public BaseImage(Texture texture) {
      this((Drawable)(new TextureRegionDrawable(new TextureRegion(texture))));
   }

   public BaseImage(Skin skin, String drawableName) {
      this(skin.getDrawable(drawableName), Scaling.stretch, 1);
   }

   public BaseImage(Drawable drawable, Scaling scaling, int align) {
      super(drawable,scaling,align);
   }

   public void initShader(){
      if (program!=null)return;
      program = new ShaderProgram(
              Gdx.files.internal(vertShader),
              Gdx.files.internal(frangShader));
   }

   @Override
   public void draw(Batch batch, float parentAlpha) {
      if (program == null) {
         super.draw(batch, parentAlpha);
      }else {
         batch.setShader(program);
         setArgs();
         super.draw(batch, parentAlpha);
         batch.setShader(null);
      }
   }

   @Override
   public void act(float delta) {
      super.act(delta);
      time += delta;
   }

   protected void setArgs(){}

   protected void setUniformTime(String name){
      if (program!=null) {
         if (program.hasUniform(name)) {
            program.setUniformf(name,time);
         }
      }
   }
}
