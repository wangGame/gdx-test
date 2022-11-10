#ifdef GL_ES
precision mediump float;
#endif
varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
uniform sampler2D u_texture1;
uniform float time;
void main() {
    vec2 uv = v_textCoords;
    float temp = abs(time);
    if(time>0.5){
        temp = 1- time;
    }
    if(uv.x<temp || uv.x > (1-temp)){
        gl_FragColor = vec4(0,0,0,1.0);
    }else{
//        if(uv.x>0.5){
//            uv.x = uv.x+time;
//        }else{
//            uv.x = uv.x - time;
//        }
        uv.x = (uv.x - temp)/(1-2*temp);
        if(time > 0.5 ){
            vec4 rgb = texture2D(u_texture1, uv);
            gl_FragColor = rgb;
        }else{
            vec4 rgb = texture2D(u_texture, uv);
            gl_FragColor = rgb;
        }
    }
}