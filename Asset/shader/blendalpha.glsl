#ifdef GL_ES
precision mediump float;
#endif


//input from vertex shader
varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
uniform sampler2D u_texture1;
uniform float mixturePercent;

void main() {
    vec4 textureColor = v_color* texture2D(u_texture,v_textCoords);
    vec4 textureColor2 = v_color* texture2D(u_texture1,v_textCoords);
    gl_FragColor = vec4(mix(textureColor.rgb, textureColor2.rgb,
    textureColor2.a * mixturePercent), textureColor.a);
}
