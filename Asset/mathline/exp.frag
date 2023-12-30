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
    float offDistance = 0.00001;
    vec4 textureColor = texture2D(u_texture, v_textCoords)*v_color;
    float a = v_textCoords.x;
    float expvalue = sinmathod(a);
    float expvalue1 = sinmathod(a+offDistance);
    float k = (expvalue1 - expvalue) / offDistance;
    float b = expvalue - k * a;

    //y = kx + b  ==> kx - y + c
    //abs (k * x1 + b * y1 + c) / sqrt (A * A + B * B)
    float distance = abs (k * a - v_textCoords.y + b ) / sqrt(k * k + 1);


    if (distance < 0.009) {
        if(distance<0.003){
            gl_FragColor = vec4(1.0, .0, .0, textureColor.a);
        }else{
            gl_FragColor = vec4(1.0, 1.0, 1.0, textureColor.a);
        }
    } else {
        gl_FragColor = vec4(0.0,0.0,0.0,0.0);
    }
}