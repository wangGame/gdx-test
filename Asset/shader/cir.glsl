#ifdef GL_ES
precision mediump float;
#endif
//input from vertex shader
varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
uniform sampler2D u_texture1;
uniform sampler2D u_texture2;

void main() {
    vec4 textureColor = v_color* texture2D(u_texture,v_textCoords);
    vec4 textureColor1 = v_color* texture2D(u_texture1,v_textCoords);
    vec4 textureColor2 = v_color* texture2D(u_texture2,v_textCoords);
    if(textureColor2.a>0.89){
//        gl_FragColor = vec4(1.0,1.0,1.0,1.0);
        discard;
    }else{
        gl_FragColor = vec4(textureColor.rgb,textureColor1.a);
    }
}
