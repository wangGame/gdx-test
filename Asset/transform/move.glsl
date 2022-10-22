#ifdef GL_ES
precision mediump float;
#endif
varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;

uniform float moveLeft;

void main() {
    vec2 uv = v_textCoords;
    uv.x = v_textCoords.x + moveLeft;
    uv.y = v_textCoords.y + moveLeft;
    vec4 rgb = texture2D(u_texture, uv);
    gl_FragColor = rgb;
}