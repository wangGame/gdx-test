package com.tony.shader.interpolation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;

public class SlowFastGroup   extends BaseGroup{
   public SlowFastGroup(){
      program = new ShaderProgram(
              Gdx.files.internal("mathline/txt.vert"),
              Gdx.files.internal("mathline/linear.glsl")
      );
   }
}
