#ifdef GL_ES
precision mediump float;
#endif

varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
uniform float time;

void main() {
    vec4 pic = v_color * texture2D(u_texture, v_textCoords);
    float vvv = (pic.r + pic.g + pic.b) / 3.0;

    vec2 uv = v_textCoords;
    uv.x = uv.x-0.5F;
    uv.y = uv.y-0.5F;
    float sinV =1 - time;
    if(sinV<0.0){
        sinV = 0.0;
    }
    float r = sinV;
    float d = length(uv);
    float c = smoothstep(r,r-0.6,d);
//    vec4 v= vec4(240.0F/255, 217.0F/255, 187.0F/255,vvv);
    gl_FragColor=vec4(240.0F/255, 217.0F/255, 187.0F/255,c);
}