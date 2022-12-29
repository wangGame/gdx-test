
#ifdef GL_ES
precision mediump float;
#endif
varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
uniform sampler2D u_texture1;
uniform float time;
float OFFSET = 0.4;

uniform float u;
uniform float u2;
uniform float v;
uniform float v2;

void main() {
    float vvv = (v_textCoords.y - v) / (v2 - v);
    float uuu = (v_textCoords.x - u) / (u2 - u);

    vec2 vecCoords = vec2(vvv,uuu);

    vec4 sourceColor = texture2D(u_texture, v_textCoords) * v_color;
    vec4 sourceColor2 = texture2D(u_texture1, vecCoords) * v_color;
    float xx = 1-(sourceColor2.r + sourceColor2.g + sourceColor2.b) / 3.0;
    xx = xx * xx * xx;
    xx = xx + time*0.2;
//    xx = xx - 0.5 - time*0.2;
//    gl_FragColor = vec4(sourceColor.rgb,sourceColor.a * xx);
//    gl_FragColor = mix(sourceColor2,sourceColor,0.1);

        gl_FragColor = vec4(sourceColor.rgb,sourceColor.a * xx);
}
