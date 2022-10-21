#ifdef GL_ES
precision mediump float;
#endif
varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
uniform float opacity;

void main() {
    vec4 textureColor = v_color* texture2D(u_texture,v_textCoords);
    gl_FragColor = vec4(textureColor.rgb,textureColor.a*opacity);
}
