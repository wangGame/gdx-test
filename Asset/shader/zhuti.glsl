#ifdef GL_ES
precision mediump float;
#endif

varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
uniform float contrast;


//nv general settings
#define NV_BRIGHTNESS 2.5
#define NV_COLOR      vec3(1.0, 0.40, 0.53) //can be higher than 1 bcuz i saturated it
#define NV_BLURRING vec3(0.002,0.003,0.004)

//effect settings
#define FLICKERING_INTENSITY 0.015
#define FLICKERING_FREQ 50.0
#define NOISE_INTENSITY 1.15
#define SCANLINES_INTENSITY 0.025

float saturate(float x) {
    return clamp(x, 0.0, 1.0);
}

//vec3 saturate(vec3 x) {
//    return clamp(x, vec3(0.0), vec3(1.0));
//}

//vec2 saturate(vec2 x) {
//    return clamp(x, vec2(0.0), vec2(1.0));
//}

//float sawTooth(float t) {
//    return cos(t+cos(t))+sin(2.*t)*.2+sin(4.*t)*.02;
//}

void main() {


//    vec4 textureColor = v_color* texture2D(u_texture,v_textCoords);
//    gl_FragColor = vec4(textureColor.rgb, textureColor.w);
    vec2 uv = v_textCoords;

    vec4 image = v_color * texture( u_texture, uv) ;


    //fast CA, and multipling image for better brightness
    image += texture( u_texture, uv + NV_BLURRING.x)*NV_BRIGHTNESS;
    image += texture( u_texture, uv + NV_BLURRING.y)*NV_BRIGHTNESS;
    image += texture( u_texture, uv + NV_BLURRING.z)*NV_BRIGHTNESS;


    //fast color remover
    image.g = ((image.r + image.g + image.b)/3.f)* saturate(NV_COLOR.x);
    image.r = ((image.r + image.g + image.b)/3.f)* saturate(NV_COLOR.y);
    image.b = ((image.r + image.g + image.b)/3.f)* saturate(NV_COLOR.z);

    if(image.r >= 1.0 &&image.g >= 1.0 &&image.b >= 1.0){
        discard;
    }else{
        gl_FragColor = image;
    }
}
