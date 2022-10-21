#ifdef GL_ES
precision mediump float;
#endif


//input from vertex shader
varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
uniform sampler2D u_texture1;



void main() {
    vec4 textureColor = v_color* texture2D(u_texture,v_textCoords);
    vec4 textureColor1 = v_color* texture2D(u_texture1,v_textCoords);
    gl_FragColor = mix(textureColor1,textureColor, textureColor.w);
//    gl_FragColor = textureColor1;
}