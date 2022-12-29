package com.tony.rider.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.tony.rider.asset.Asset;

public class BlackGroup extends Group {
   private ShaderProgram program;
   public BlackGroup(String strName) {
      if (program == null){
         program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                 Gdx.files.internal("shader/lumin.glsl"));
      }
      Image image = new Image(Asset.getAsset().getTexture(strName)){
         @Override
         public void draw(Batch batch, float parentAlpha) {
            batch.setShader(program);
            int time1 = program.getUniformLocation("threshold");
            program.setUniformf(time1,0.5F);
            super.draw(batch, parentAlpha);
            batch.setShader(null);
         }
      };
      image.addAction(Actions.fadeIn(1.4f));
      addActor(image);
      setSize(image.getWidth(),image.getHeight());
   }
}
