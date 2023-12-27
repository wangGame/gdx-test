#ifdef GL_ES
precision mediump float;
#endif
//input from vertex shader
varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
void main() {
    vec2 uv  = v_textCoords.xy;
    float dx = 0.05;
    float dy = 0.05;
    vec2 coord = vec2(dx * floor(uv.x / dx), dy * floor(uv.y / dy));
    vec3 tc = texture2D(u_texture, coord).xyz;
    gl_FragColor = vec4(tc, 1.0);
}