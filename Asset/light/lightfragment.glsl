#ifdef GL_ES
precision mediump float;
#endif

varying vec2 v_tex;
uniform float width;
uniform float height;
uniform float offsetXY;
float xzax = 0.01;


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


void main(){
    v_tex.x = v_tex.x / (width-offsetXY*2) - offsetXY/(width-offsetXY*2);
    v_tex.y = v_tex.y / (height-offsetXY*2) - offsetXY/(height - offsetXY*2);



    float offDistance = 0.0001;
    float expvalue = sinmathod(v_tex.x);
    float expvalue1 = sinmathod(v_tex.x+offDistance);
    float k = (expvalue1 - expvalue) / offDistance;
    float b = expvalue - k * v_tex.x;

    //y = kx + b  ==> kx - y + c
    //abs (k * x1 + b * y1 + c) / sqrt (A * A + B * B)
    float distance = abs (k * v_tex.x - v_tex.y + b ) / sqrt(k * k + 1);
    bool draw = false;
    if(v_tex.x>0. && v_tex.x<1.0){
        if (distance < 0.009) {
            draw = true;
            if(distance<0.009){
                gl_FragColor = vec4(1.0, .0, .0, (1.0-(distance*10/6.0)));
            }else{
                gl_FragColor = vec4(1.0, 1.0, 1.0, 1.0);
            }
        }

        if ((v_tex.x < xzax || v_tex.y < xzax)
        && v_tex.x >= 0.0 && v_tex.x <= 1.0
        && v_tex.y >= 0.0 && v_tex.y <= 1.0) {
            gl_FragColor = vec4(1.0, 1.0, 0, 1.0);
        }else{
            if(!draw){
                discard;
            }
        }
    }else{
        discard;
    }
}