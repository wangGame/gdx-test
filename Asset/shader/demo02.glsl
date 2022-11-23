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
    float rgb = (overlay.r + overlay.g + overlay.b)/3.0;
//    gl_FragColor = mix(base.rgba, vec4(1.0,1.0,1.0,rgb), 0.5);

}
