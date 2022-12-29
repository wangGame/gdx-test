#ifdef GL_ES
precision mediump float;
#endif


//input from vertex shader
varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
uniform sampler2D u_texture1;


void main() {

    vec4 tempColor = texture2D(u_texture,v_textCoords) * v_color;
    gl_FragColor = tempColor;

    float xx = texture2D(u_texture1,v_textCoords).x;
    gl_FragDepth = xx;
}