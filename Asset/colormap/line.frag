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
vec3 W = vec3(0.2125, 0.7154, 0.0721);
void main() {

    vec2 uv  = v_textCoords.xy;
    float dx = 0.13;
    float dy = 0.13;
    vec2 coord = vec2(dx * floor(uv.x / dx), dy * floor(uv.y / dy));
    vec4 tc = v_color * texture2D(u_texture, coord);




    vec4 pic = tc;
    // 红色
    vec3 color1 = vec3(76.0/255.0, 73.0/255.0,63.0/255.0);
    // 蓝色
    vec3 color2 = vec3(219.0/255.0, 218.0/255.0, 200.0/255.0);
    // 插值因子，取0.5表示取两者之间的中间色
    float t = (pic.r + pic.g + pic.b)/3.0f;
    // 计算过渡颜色
    vec3 interpolatedColor = mix(color1, color2, t);




    float rr = 0.07f;
    if(v_textCoords.x < rr && v_textCoords.y < rr){
        if((v_textCoords.x - rr) * (v_textCoords.x - rr) + (v_textCoords.y - rr) * (v_textCoords.y - rr) < rr * rr){
            gl_FragColor=vec4(interpolatedColor.rgb,pic.a);
        }else{
            discard;
        }
    }else if(v_textCoords.x > (1.0-rr)&&v_textCoords.y<rr){
        if((1.0-v_textCoords.x - rr) * (1.0-v_textCoords.x - rr) + (v_textCoords.y - rr) * (v_textCoords.y - rr) < rr * rr){
            gl_FragColor=vec4(interpolatedColor.rgb,pic.a);
        }else{
            discard;
        }
    }else if(v_textCoords.x < rr&&v_textCoords.y>(1-rr)){
        if((v_textCoords.x - rr) * (v_textCoords.x - rr) + (1.0-v_textCoords.y - rr) * (1.0-v_textCoords.y - rr) < rr * rr){
            gl_FragColor=vec4(interpolatedColor.rgb,pic.a);
        }else{
            discard;
        }
    }else if(v_textCoords.x > (1-rr)&&v_textCoords.y>(1-rr)){
        if((1-v_textCoords.x - rr) * (1-v_textCoords.x - rr) + (1.0-v_textCoords.y - rr) * (1.0-v_textCoords.y - rr) < rr * rr){
            gl_FragColor=vec4(interpolatedColor.rgb,pic.a);
        }else{
            discard;
        }
    }else  {
        gl_FragColor=vec4(interpolatedColor.rgb,pic.a);
    }

//    if((v_textCoords.x - 0.5f)*(v_textCoords.x - 0.5f) + (v_textCoords.y - 0.5f)*(v_textCoords.y - 0.5f) < 0.45f){
//    }else{
//        discard;
//    }
}