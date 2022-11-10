#ifdef GL_ES
precision mediump float;
#endif
varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;

uniform float fz;

void main() {
    vec2 uv = v_textCoords;
    if(uv.x>0.5){
        uv.x = uv.x - fz;
    }else{
        uv.x = uv.x + fz;
    }
    vec4 rgb = texture2D(u_texture, uv);
    gl_FragColor = rgb;
}