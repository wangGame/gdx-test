#ifdef GL_ES
precision mediump float;
#endif
varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
uniform float exposure;
uniform float offset;
uniform float gamma;
void main() {
    vec4 textureColor = v_color* texture2D(u_texture,v_textCoords);
    vec3 endColor =max(min(textureColor.rgb * pow(2.0, exposure/(2.2f*3.0))+offset,1.0),0.0);

    gl_FragColor = vec4(endColor, textureColor.w);
}