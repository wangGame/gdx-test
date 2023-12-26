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

public abstract class BaseGroup extends Image {
   protected String vertShader = "realseshader/common.vert";
   protected String frangShader;
   protected float time;
   protected ShaderProgram program;

   public BaseGroup() {
      this(Asset.getAsset().getTexture("_Background-58852.png"));
   }

   public BaseGroup(Drawable drawable) {
      this(drawable, Scaling.stretch, 1);
   }

   public BaseGroup(NinePatch patch) {
      this(new NinePatchDrawable(patch), Scaling.stretch, 1);
   }

   public BaseGroup(TextureRegion region) {
      this(new TextureRegionDrawable(region), Scaling.stretch, 1);
   }

   public BaseGroup(Texture texture) {
      this((Drawable)(new TextureRegionDrawable(new TextureRegion(texture))));
   }

   public BaseGroup(Skin skin, String drawableName) {
      this(skin.getDrawable(drawableName), Scaling.stretch, 1);
   }

   public BaseGroup(Drawable drawable, Scaling scaling, int align) {
      super(drawable,scaling,align);
   }

   public void initShader(){
//      program = new ShaderProgram(
//              Gdx.files.internal("realseshader/common.vert"),
//              Gdx.files.internal("realseshader/lumin.glsl"));
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
}
