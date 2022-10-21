#ifdef GL_ES
precision mediump float;
#endif


//input from vertex shader
varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
uniform float intensity;

void main() {
    mat4 colorMatrix = mat4(1.0f, 0.0f, 0.0f, 0.0f,
    0.0f, 1.0f, 0.0f, 0.0f,
    0.0f, 0.0f, 1.0f, 0.0f,
    0.0f, 0.0f, 0.0f, 1.0f);
    vec4 textureColor = v_color* texture2D(u_texture,v_textCoords);
    vec4 outputColor = textureColor * colorMatrix;
    gl_FragColor = (intensity * outputColor) + ((1.0 - intensity) * textureColor);;
}
