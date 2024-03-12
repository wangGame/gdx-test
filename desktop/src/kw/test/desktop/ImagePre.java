package kw.test.desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.kw.gdx.asset.Asset;
import com.kw.gdx.listener.OrdinaryButtonListener;

public class ImagePre extends Group {
    private float num1;
    private float num2;
    private float num3;
    private float num4;
    private float num5;
    private float num6;

    public float getNum1() {
        return num1;
    }

    public void setNum1(float num1) {
        this.num1 = num1;
    }

    public float getNum2() {
        return num2;
    }

    public void setNum2(float num2) {
        this.num2 = num2;
    }

    public float getNum3() {
        return num3;
    }

    public void setNum3(float num3) {
        this.num3 = num3;
    }

    public float getNum4() {
        return num4;
    }

    public void setNum4(float num4) {
        this.num4 = num4;
    }

    public float getNum5() {
        return num5;
    }

    public void setNum5(float num5) {
        this.num5 = num5;
    }

    public float getNum6() {
        return num6;
    }

    public void setNum6(float num6) {
        this.num6 = num6;
    }

    public ImagePre(String name){
        Image image = new Image(Asset.getAsset().getTexture("artdengm/"+name)){
            private ShaderProgram program = new ShaderProgram(Gdx.files.internal("pp/pres.vert"),Gdx.files.internal("pp/pres.frag"));
            @Override
            public void draw(Batch batch, float parentAlpha) {
                batch.flush();
                batch.setShader(program);
                program.setUniformf("num1", num1);
                program.setUniformf("num2", num2);
                program.setUniformf("num3", num3);

//                program.setUniformf("num1", 0.2f);
//                program.setUniformf("num2", 0.5f);
//                program.setUniformf("num3", 0.5f);
                program.setUniformf("numx",10);

//                program.setUniformf("num4", num4);
//                program.setUniformf("num5", num5);
//                program.setUniformf("num6", num6);
                System.out.println("num1:"+num1+"   "+"num2:"+num2+"   "+"num3:"+num3+"   ");
                super.draw(batch, parentAlpha);
                batch.setShader(null);
            }
        };
        setSize(image.getWidth(),image.getHeight());
        addActor(image);

    }
}
