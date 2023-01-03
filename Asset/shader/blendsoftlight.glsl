#ifdef GL_ES
precision mediump float;
#endif


//input from vertex shader
varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
uniform sampler2D u_texture1;

void main() {
    vec4 base = v_color* texture2D(u_texture,v_textCoords);
    vec4 overlay = v_color* texture2D(u_texture1,v_textCoords);
    gl_FragColor = base * (overlay.a * (base / base.a) +
    (2.0 * overlay * (1.0 - (base / base.a)))) +
    overlay * (1.0 - base.a) + base * (1.0 - overlay.a);
}
