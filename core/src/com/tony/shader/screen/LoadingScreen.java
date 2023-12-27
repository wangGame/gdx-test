package com.tony.shader.screen;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.kw.gdx.screen.BaseScreen;
import com.tony.shader.ShaderUtills;
import com.kw.gdx.asset.Asset;

public class LoadingScreen extends BaseScreen {

    private float time;
    public LoadingScreen() {
        super(ShaderUtills.instence());
//        OrthOcamPostionDemo orthographicCamera = new OrthOcamPostionDemo();
//        addActor(orthographicCamera);D
//        orthographicCamera.init();

//        AssetManager assetManager = new AssetManager();
//        assetManager.load("test.png", Texture.class);
//        assetManager.finishLoading();
//        Texture text = assetManager.get("test.png");
//        Image image = new Image(text);
//        stage.addActor(image);







        Image image = new Image(Asset.getAsset().getTexture("whale2-22756.png"));
        addActor(image);
        image.addAction(new Action() {
            private float xx = 0;
            private float yy = 0;
            private float R = 200;
            private float timeTemp;
            @Override
            public boolean act(float delta) {
                timeTemp += delta * 0.01f;
                float v = (float) Math.toDegrees(Math.toDegrees(timeTemp));
                System.out.println("角度  ： "+v+"   "+timeTemp);
                xx = (float) (R * Math.cos(Math.toRadians(-v)));
                yy = (float) (R * Math.sin(Math.toRadians(-v)));
                image.setPosition(300 + yy,300 + xx);
                return false;
            }
        });

   /*     p = p / iResolution.xy*2.-1.;
        p+=0.4;
        p*=1.25;
        o = drawFilter(iChannel0,p,mat3(-1.,-1.,-1.,-1.,8.,-1.,-1.,-1.,-1.),1./vec2(512.));
   */
/*

        p = p / iResolution.xy*2.-1.;
        o = drawSobel(iChannel0,p,1./vec2(512.));
*/

        /*
        p = p / iResolution.xy*2.-1.;
        o = drawGrayScale(iChannel0,p);
        */
/*
        p.y+=1.;
        o = drawRoberts(iChannel0,p,1./vec2(512.));

        */
/*
*
*
*
*
* p = p / iResolution.xy*2.-1.;


    if(abs(p.x)<=0.4 && abs(p.y)<=0.4){
        p+=0.4;
        p*=1.25;
        //My favourite filter :D
        o = drawFilter(iChannel0,p,mat3(-1.,-1.,-1.,-1.,8.,-1.,-1.,-1.,-1.),1./vec2(512.));
    }else if(p.x<0.){
        if(p.y<0.)
            o = drawSobel(iChannel0,p,1./vec2(512.));
        else
            o = drawGrayScale(iChannel0,p);
    }else{
        if(p.y<0.){
            p.y+=1.;
    		o = drawRoberts(iChannel0,p,1./vec2(512.));
        }else{
    		o = drawPrewitt(iChannel0,p,1./vec2(512.));
        }

    }*/

        /*
        *
        *
        vec4 drawNormal(sampler2D sampler, vec2 uv){
    return texture(sampler,uv);
}
vec4 drawGrayScale(sampler2D sampler, vec2 uv){
    vec4 c = drawNormal(sampler,uv);
    return vec4(vec3(c.r+c.g+c.b)/3.,1.);

}
vec4 drawFilter (sampler2D sampler, vec2 uv, mat3 _filter, vec2 s){
    vec3 c = drawGrayScale(sampler,uv-s).rgb*_filter[0][0];
    c += drawGrayScale(sampler,vec2(uv.x,uv.y-s.y)).rgb*_filter[0][1];
    c += drawGrayScale(sampler,vec2(uv.x+s.x,uv.y-s.y)).rgb*_filter[0][2];
    c += drawGrayScale(sampler,vec2(uv.x-s.x,uv.y)).rgb*_filter[1][0];
    c += drawGrayScale(sampler,uv).rgb*_filter[1][1];
    c += drawGrayScale(sampler,vec2(uv.x+s.x,uv.y)).rgb*_filter[1][2];
    c += drawGrayScale(sampler,vec2(uv.x-s.x,uv.y+s.y)).rgb*_filter[2][0];
    c += drawGrayScale(sampler,vec2(uv.x,uv.y+s.y)).rgb*_filter[2][1];
    c += drawGrayScale(sampler,uv+s).rgb*_filter[2][2];

    return vec4(c,1.);
}
vec4 drawRoberts (sampler2D sampler, vec2 uv, vec2 s){
    return drawFilter(sampler,uv,mat3(0.,-1,0.,0.,0.,1.,0.,0.,0.),s);
}
vec4 drawPrewitt (sampler2D sampler, vec2 uv, vec2 s){
    return drawFilter(sampler,uv,mat3(-1.,0.,1.,-1.,0.,1.,-1.,0.,1.),s);
}
vec4 drawSobel (sampler2D sampler, vec2 uv, vec2 s){
    return drawFilter(sampler,uv,mat3(-1.,0.,1.,-2.,0.,2.,-1.,0.,1.),s);
}


void mainImage( out vec4 o, in vec2 p )
{
   p = p / iResolution.xy;
   vec4 o1 = drawPrewitt(iChannel0,p,1./vec2(512.));
   float xx = (o1.r + o1.g + o1.b) / 3.0;
   if(xx < 0.2){
       o = vec4(1.0,1.0,1.0,0.0);
   }else{
       o = texture(iChannel0,p);
   }


}
        *
        * */


//        Image image = new Image(Asset.getAsset().getTexture("whale2-22756.png"));
//        addActor(image);
//        image.addAction(new Action() {
//            private float xx = 0;
//            private float yy = 0;
//            private float R = 200;
//            private float timeTemp;
//            @Override
//            public boolean act(float delta) {
//                timeTemp += delta * 0.01f;
//                xx = (float) (R * Math.cos(Math.toDegrees(timeTemp)));
//                yy = (float) (R * Math.sin(Math.toDegrees(timeTemp)));
//                image.setPosition(300 + yy,300 + xx);
//                System.out.println("角度  ： "+Math.toDegrees(Math.toDegrees(timeTemp))+"   "+timeTemp);
//                return false;
//            }
//        });

//        Group group1 = new Group(){
//            @Override
//            public void act(float delta) {
//                super.act(delta);
//
//            }
//        };
//        addActor(group1);
    }

    @Override
    public void show() {
        super.show();
//        stage.addAction(Actions.delay(0,Actions.run(()->{
//            setScreen(new InterpolationScreen());
//        })));
    }
}
