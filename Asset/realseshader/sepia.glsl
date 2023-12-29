#ifdef GL_ES
precision mediump float;
#endif

varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
uniform float intensity;
void main() {
    mat4 colorMatrix = mat4(
       0.3588, 0.7044, 0.1368, 0.0,
        0.2990, 0.5870, 0.1140, 0.0,
        0.2392, 0.4696, 0.0912, 0.0,
        0.0f,    0.0,    0.0,    1.0);
    float cc = sin(intensity);
    vec4 textureColor = v_color* texture2D(u_texture,v_textCoords);
    vec4 outputColor = textureColor * colorMatrix;
    gl_FragColor = (cc * outputColor) + ((1.0 - cc) * textureColor);
}
