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
//    gl_FragColor = gl_FragColor = mix(textureColor, textureColor1, time);
    gl_FragColor = vec4((overlay.rgb * base.a +
    base.rgb * overlay.a - 2.0 * overlay.rgb * base.rgb) +
    overlay.rgb * (1.0 - base.a) +
    base.rgb * (1.0 - overlay.a), base.a);
}