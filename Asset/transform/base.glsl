#ifdef GL_ES
precision mediump float;
#endif
varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;

void main() {
    vec4 rgb = texture2D(u_texture, v_textCoords);
    gl_FragColor = rgb;
}