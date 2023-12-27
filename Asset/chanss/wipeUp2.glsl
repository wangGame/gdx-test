
#ifdef GL_ES
precision mediump float;
#endif
varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
uniform sampler2D u_texture2;
uniform float time;

uniform float u;
uniform float u2;
uniform float v;
uniform float v2;

void main() {
    vec2 temp_textCoord = vec2(v_textCoords.xy);
    float vvv = (temp_textCoord.x - u) * 1.77 / (u2 - u);
    float uuu = (temp_textCoord.y - v) * 1.7 / (v2 - v);
    vec2 vecCoords = vec2(vvv,uuu);
    vec4 sourceColor = texture2D(u_texture, v_textCoords) * v_color;
    vec4 sourceColor2 = texture2D(u_texture2, vecCoords) * v_color;
    float xx = (sourceColor2.r + sourceColor2.g + sourceColor2.b) / 3.0;
//        gl_FragColor = vec4(vec3(1.0),sourceColor.a * xx);
        gl_FragColor = vec4(vec3(sourceColor.rgb), xx);
}
