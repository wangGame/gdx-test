#ifdef GL_ES
precision mediump float;
#endif


//input from vertex shader
varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;

uniform float r;
uniform float g;
uniform float b;


void main() {
    vec4 textureColor = v_color* texture2D(u_texture,v_textCoords);
    gl_FragColor = vec4(textureColor.r*r,textureColor.g*g,textureColor.b*b, textureColor.w);
}