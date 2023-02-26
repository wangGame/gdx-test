#ifdef GL_ES
precision mediump float;
#endif

#define PI 3.14159265
varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
uniform float time;


float sinmathod(float a){
    float value = 2.0;
    float power = 5.0;
    float min = pow(value, -power);
    float scale = 1 / (1 - min);
    if (a <= 0.495){
        return pow(value, power * (a * 2.0 - 1)) - min * scale / 2;
    }else{
        return (2.0 - pow(value, -power * (a * 2 - 1)) - min * scale) / 2;
    }
//    float ss = (1 - 0.6 * cos(1.0 * a * PI)) / 2;
////    float ss = 0.3 * sin(30.0*a) + 0.5;
//    return ss;
}

void main() {
    vec4 textureColor = texture2D(u_texture,
                                  v_textCoords)*v_color;
    float a = v_textCoords.x;


    float ss = 1.0-sinmathod(a)-0.005;
    float f = step(ss, v_textCoords.y) -
    step(ss+0.01, v_textCoords.y);
    gl_FragColor = vec4(f,f,f,textureColor.a);
}