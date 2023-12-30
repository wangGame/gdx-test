#ifdef GL_ES
precision mediump float;
#endif

varying vec2 v_tex;
uniform float width;
uniform float height;
uniform float offsetXY;
float xzax = 0.01;

float sinmathod(float a){
    a = a * a * (3.0f - 2.0f * a);
    return a * a * (3.0f - 2.0f * a);
}


void main(){
    v_tex.x = v_tex.x / (width-offsetXY*2) - offsetXY/(width-offsetXY*2);
    v_tex.y = v_tex.y / (height-offsetXY*2) - offsetXY/(height - offsetXY*2);



    float offDistance = 0.00001;
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
            if(distance<0.003){
                gl_FragColor = vec4(1.0, .0, .0, 1.0);
            }else{
                gl_FragColor = vec4(1.0, 1.0, 1.0, 1.0);
            }
        }

        if ((v_tex.x < xzax || v_tex.y < xzax)
        && v_tex.x >= 0.0 && v_tex.x <= 1.0
        && v_tex.y >= 0.0 && v_tex.y <= 1.0) {
            gl_FragColor = vec4(1.0, 0, 0, 1.0);
        }else{
            if(!draw){
                discard;
            }
        }
    }else{
        discard;
    }
}