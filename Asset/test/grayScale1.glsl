#ifdef GL_ES
precision mediump float;
#endif
varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
uniform float saturation;
vec3 luminanceWeighting = vec3(0.2125, 0.7154, 0.0721);

void main() {
    vec4 textureColor = v_color* texture2D(u_texture,v_textCoords);
    float ccc = (textureColor.r + textureColor.g + textureColor.b)/3.0;
    gl_FragColor = vec4(textureColor.rgb,ccc+saturation);
}