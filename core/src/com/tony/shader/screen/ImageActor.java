package com.tony.shader.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class ImageActor extends Image{
   private ShaderProgram program;

   public ImageActor(Texture texture){
      super(texture);
      if (program == null){
         program = new ShaderProgram(Gdx.files.internal("shader/txt.vert"),
                 Gdx.files.internal("shader/edge3.glsl"));
      }
   }

   @Override
   public void draw(Batch batch, float parentAlpha) {
      batch.setShader(program);
      super.draw(batch, parentAlpha);
      batch.setShader(null);
   }
}
