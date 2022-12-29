#ifdef GL_ES
precision mediump float;
#endif

varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
uniform sampler2D u_texture3;
uniform float time;

uniform float u;
uniform float u2;
uniform float v;
uniform float v2;


void main() {
    float vm = abs(v2 + v);
    float um = abs(u2 + u);
    vec4 pic = v_color * texture2D(u_texture, v_textCoords);
    vec4 cpic = v_color * texture2D(u_texture3,v_textCoords);

    float xv = (cpic.r + cpic.g+cpic.b)/3.0+1 - time;
    xv = xv * xv *xv;
//    gl_FragColor=vec4(vec3(cpic.rgb),  pic.a);
    gl_FragColor = pic;
}