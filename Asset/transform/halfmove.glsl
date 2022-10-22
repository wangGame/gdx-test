#ifdef GL_ES
precision mediump float;
#endif
varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
uniform sampler2D u_texture1;
uniform float time;
void main() {
    vec2 uv = v_textCoords;
    if(v_textCoords.x<0.5){
        vec4 rgb = texture2D(u_texture, uv);
        gl_FragColor = rgb;
    }else{
        vec4 rgb = texture2D(u_texture, uv - vec2(time, 0.0));
        gl_FragColor = rgb;
    }
}