#ifdef GL_ES
precision mediump float;
#endif


//input from vertex shader
varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
uniform float time;

void main() {
    vec2 b_xlat = vec2(0.0,0.0);
    b_xlat.x = time;
    b_xlat.xy = v_textCoords.yx * vec2(0.02f,0.02f) + b_xlat.xx;
    b_xlat.xy = sin(b_xlat.xy);
    b_xlat.xy = b_xlat.xy * vec2(0.3) + v_textCoords.xy;


    vec2 a_xlat = vec2(0.0,0.0);
//    if(b_xlat.x > 0){
//        a_xlat.x = b_xlat.x;
//        a_xlat.y = v_textCoords.x;
//    }else{
        a_xlat.x = b_xlat.x;
        a_xlat.y = v_textCoords.y;
//    }
    vec4 textureColor = v_color* texture2D(u_texture,a_xlat);
    gl_FragColor.rgb = textureColor.rgb * textureColor.www;
    gl_FragColor.a = textureColor.w;
}