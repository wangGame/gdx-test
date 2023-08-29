#ifdef GL_ES
precision mediump float;
#endif

varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
uniform float time;
uniform float rato;
uniform float ra;
uniform float offsetXL;
uniform float offsetXR;

vec3 W = vec3(0.2125, 0.7154, 0.0721);

void main() {
    vec4 tc = v_color * texture2D(u_texture, v_textCoords);
    float rr = ra;

    float startX = offsetXR;
    float endX = 1.0-offsetXR;

    float startY = offsetXR*rato;
    float endY = 1.0-offsetXR*rato;
    float dddd  = 0.2f;

    if((v_textCoords.x>=startX && v_textCoords.x <= endX)&&
    (v_textCoords.y>=startY && v_textCoords.y <= endY)){
        if(v_textCoords.x <= startX+dddd && v_textCoords.y <= startY + dddd*rato){


            vec2 center = vec2(rr,rr);
            vec2 uv = vec2(startX+(v_textCoords.x - startX),v_textCoords.y);
            float distanceToCenter = distance(uv,center);
            float alpha = 1.0;
            if(distanceToCenter * distanceToCenter <= 0.004){
                gl_FragColor = vec4(1.0,1,0,1.0);
            }else{
                gl_FragColor = vec4(tc.rgb, tc.a * alpha);
            }


            //            gl_FragColor = vec4(1.0f,1.0,0.0,1.0f);
        }else if(v_textCoords.x > endX-0.2f && v_textCoords.y < startY + 0.2f*rato){
            gl_FragColor = vec4(1.0f,1.0,0.0,1.0f);
        }else if(v_textCoords.x < startX+0.2f && v_textCoords.y > endY - 0.2f*rato){
            gl_FragColor = vec4(1.0f,1.0,0.0,1.0f);
        }else if(v_textCoords.x > endX-0.2f && v_textCoords.y > endY - 0.2f*rato){
            gl_FragColor = vec4(1.0f,1.0,0.0,1.0f);
        }else{
            gl_FragColor = tc;
        }
    }else{
        gl_FragColor = vec4(1.0,0,0,1.0);
    }




    vec2 center = vec2(rr,startY+rr);
    vec2 uv = vec2(v_textCoords.x,v_textCoords.y);
    float distanceToCenter = distance(uv,center);
    float alpha = 1.0;
    if(distanceToCenter * distanceToCenter <= 0.004){
        gl_FragColor = vec4(1.0,1,0,1.0);
    }else{
        gl_FragColor = vec4(tc.rgb, tc.a * alpha);
    }


    //    if(((v_textCoords.x-offsetXL)-offsetXL)*rato<rr && (v_textCoords.y > time &&v_textCoords.y <rr+time)){
//        vec2 center = vec2(offsetXL+rr,rr+time);
//        v_textCoords.x = offsetXL+(v_textCoords.x-offsetXL)*rato;
//        float distanceToCenter = distance(v_textCoords,center);
//        float alpha = 1.0;
//        if(distanceToCenter * distanceToCenter > rr * rr){
//            alpha = 0;
//        }
//        gl_FragColor = vec4(tc.rgb, tc.a * alpha);
//    }else if(v_textCoords.x> 1.0-rr-offsetXR/rato&& (v_textCoords.y > time &&v_textCoords.y <rr+time)){
//        vec2 center = vec2(rato-rr-offsetXR,rr+time);
//        v_textCoords.x = v_textCoords.x * rato;
//        float distanceToCenter = distance(v_textCoords,center);
//        float alpha = 1.0;
//        if(distanceToCenter * distanceToCenter > rr * rr){
//            alpha = 0;
//        }
//        gl_FragColor = vec4(tc.rgb, tc.a *  alpha);
//    } else if(v_textCoords.x*rato<rr&& v_textCoords.y > 1.0-rr - time){
//        vec2 center = vec2(rr,1.0-rr-time);
//        v_textCoords.x = v_textCoords.x * rato;
//        float distanceToCenter = distance(v_textCoords,center);
//        float alpha = 1.0;
//        if(distanceToCenter * distanceToCenter > rr * rr){
//            alpha = 0;
//        }
//        gl_FragColor = vec4(tc.rgb, tc.a * alpha);
//    } else if(v_textCoords.x> 1.0-rr/rato && v_textCoords.y > 1.0-rr - time){
//        vec2 center = vec2(rato-rr,1.0-rr-time);
//        v_textCoords.x = v_textCoords.x * rato;
//        float distanceToCenter = distance(v_textCoords,center);
//        float alpha = 1.0;
//        if(distanceToCenter * distanceToCenter > rr * rr){
//            alpha = 0;
//        }
//        gl_FragColor = vec4(tc.rgb, tc.a * alpha);
//    } else{
//        gl_FragColor = tc;
//    }

}