#ifdef GL_ES
precision mediump float;
#endif


//input from vertex shader
varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;


void main() {

    float tempColor = texture2D(u_texture,v_textCoords).w;
    float xlat = tempColor * v_color.a;
    gl_FragColor.w = xlat;
    gl_FragColor.xyz = v_color.xyz;
}