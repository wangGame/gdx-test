
#ifdef GL_ES
precision mediump float;
#endif
varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
uniform sampler2D u_texture1;
uniform float time;

const vec2 CENTER = vec2(0.5);
const float OFFSET = 0.2;
void main(){
    vec4 sourceColor = texture2D(u_texture, v_textCoords);
    vec4 sourceColor2 = texture2D(u_texture1, v_textCoords);

    float radius = length(v_textCoords - CENTER);
    float maxR = length(CENTER);
    float curR = maxR * time;

    gl_FragColor = mix(sourceColor2, sourceColor, smoothstep(curR, curR + OFFSET, radius));
}