#ifdef GL_ES
precision mediump float;
#endif

varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
uniform float time;

//传值尽量就是不对，如果写值是对的    emmmmmmmmmmmmmmmm
uniform float pww;

float powmathod(float a,float power){
    if (a <= 0.5f) return pow(a * 2, power) / 2;
    float endV = -2.0;
    if(mod(power,2.0) == 1){
        endV = 2.0;
    }

    return pow((a - 1) * 2, power) / endV + 1;
}

void main() {
    vec4 textureColor = texture2D(u_texture,
                                  v_textCoords)*v_color;
    float a = v_textCoords.x;
//    float ss = powmathod(a,pww);
    float ss = 1.0 - powmathod(a,2.0) - 0.01;
    float f = step(ss, v_textCoords.y) -
    step(ss+0.01, v_textCoords.y);
    gl_FragColor = vec4(f,f,f,textureColor.a);
}