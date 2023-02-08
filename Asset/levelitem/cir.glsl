#ifdef GL_ES
precision mediump float;
#endif
varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
uniform float saturation;
uniform float time;
vec3 luminanceWeighting = vec3(0.2125, 0.7154, 0.0721);

void main() {
    vec4 textureColor = v_color* texture2D(u_texture,v_textCoords);
    float centerX = (v_textCoords.x - 0.5);
    float centerY = (v_textCoords.y - 0.5);
    vec2 ce = vec2(centerX,centerY);
    float le = length(ce);


    float niss = 0.64;
    if(time < 0.1){
        niss = 0.64;
    }else{
        niss -= (time - 0.1)*0.5;
    }



    float c = smoothstep(time,time-niss,le);




    if((v_textCoords.x - 0.5) * (v_textCoords.x - 0.5)
    + (v_textCoords.y-0.5) * (v_textCoords.y - 0.5) < time * time){
//        if(c>=0.9){
//        }else{
//            gl_FragColor = textureColor*vec4(1.0,1.0,1.0,1.0-c);
//        }


        vec4 white = vec4(1.0,1.0,1.0,1.0);
        gl_FragColor = mix(textureColor,white,1.0-c);

    }else{
        discard;
    }
}