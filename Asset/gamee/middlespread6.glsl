#ifdef GL_ES
precision mediump float;
#endif
//input from vertex shader
varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
uniform sampler2D u_texture1;
uniform float time;

void main() {
    vec4 base = v_color* texture2D(u_texture,v_textCoords);
    vec4 overlay = v_color* texture2D(u_texture1,v_textCoords);
    float xxx = 1-(overlay.r + overlay.g + overlay.b) / 3.0;
    float fina = xxx * xxx *  xxx*  xxx*xxx + time * 0.1;
    gl_FragColor = vec4(base.rgb, fina * base.a);
}
