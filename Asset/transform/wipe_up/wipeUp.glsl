#ifdef GL_ES
precision mediump float;
#endif
varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
uniform sampler2D u_texture1;
uniform float time;
float OFFSET = 0.4;

void main() {
    vec4 sourceColor = texture2D(u_texture1, v_textCoords) * v_color;
    vec4 sourceColor2 = texture2D(u_texture, v_textCoords) * v_color;
    float progress = 1.4 - time;

    gl_FragColor = mix(sourceColor, sourceColor2, smoothstep(progress - OFFSET, progress, v_textCoords.y));

}
