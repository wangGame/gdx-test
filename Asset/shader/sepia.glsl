#ifdef GL_ES
precision mediump float;
#endif


//input from vertex shader
varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
uniform float intensity;

void main() {
    mat4 colorMatrix = mat4(
//        1.0f, 0.0f, 0.0f, 0.0f,
//    0.0f, 1.0f, 0.0f, 0.0f,
//    0.0f, 0.0f, 1.0f, 0.0f,
//    0.0f, 0.0f, 0.0f, 1.0f);
//        (
       0.3588f, 0.7044f, 0.1368f, 0.0f,
        0.2990f, 0.5870f, 0.1140f, 0.0f,
        0.2392f, 0.4696f, 0.0912f, 0.0f,
        0.0f,    0.0f,    0.0f,    1.0f);
    intensity = sin(intensity);
    vec4 textureColor = v_color* texture2D(u_texture,v_textCoords);
    vec4 outputColor = textureColor * colorMatrix;
    gl_FragColor = (intensity * outputColor) + ((1.0 - intensity) * textureColor);
}
