#ifdef GL_ES
precision mediump float;
#endif

varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
uniform float time;
uniform float v;
uniform float v1;
uniform float u;
uniform float u1;

void main() {
    vec4 pic = v_color * texture2D(u_texture, v_textCoords);
    vec2 uv = v_textCoords;
    float vv = (v1 + v) / 2;
    float uu = (u1 + u) / 2;
    uv.x = uv.x-uu;
    uv.y = uv.y-vv;
    float sinV =1 - time * 0.6;
    if(sinV<0.0){
        sinV = 0.0;
    }
    float r = sinV;
    float d = length(uv);
    float vvvv = (v1 - v) ;
    float uuuu = (u1 + u) ;
    float c = smoothstep(r,r+0.1,d);
    vec4 v= pic;
    gl_FragColor=vec4(vec3(v.rgb),c*v.a);
}