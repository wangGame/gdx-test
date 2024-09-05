#ifdef GL_ES
precision mediump float;
#endif
varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
uniform vec2 u_shadowOffset;
uniform vec4 u_shadowColor;
void main() {
    vec4 texColor = v_color* texture2D(u_texture,v_textCoords);
    vec4 shadowColor = texColor * u_shadowColor;
    shadowColor.a *= 0.5;
    vec4 finalColor = mix(texColor, shadowColor, step(0.3, v_textCoords.x)); // 外投影
    gl_FragColor = finalColor;
}