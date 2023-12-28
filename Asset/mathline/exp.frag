#ifdef GL_ES
precision mediump float;
#endif

#define PI 3.14159265
varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;

float sinmathod(float a){
    float value = 2.0;
    float power = 5.0;
    float min = pow(value,(-power));
    float scale = 1.0 / (1.0 - min);
    if (a <= 0.5){
        return (pow(value, power * (a * 2.0 - 1.0)) - min) * scale / 2.0;
    }else{
        return (2.0 - (pow(value, -power * (a * 2 - 1.0)) - min ) * scale)/ 2.0;
    }
}

void main() {
    vec4 textureColor = texture2D(u_texture, v_textCoords)*v_color;
    float a = v_textCoords.x;
    float ss = sinmathod(a);
    float dis = abs(v_textCoords.y-ss);
    if(dis<0.001){
        gl_FragColor = vec4(1.0,0,0,textureColor.a);
    }
  //  float f = step(ss, v_textCoords.y) - step(ss+0.01, v_textCoords.y);
}