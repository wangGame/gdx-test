#ifdef GL_ES
precision mediump float;
#endif


//input from vertex shader
varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
uniform float contrast;
vec3 W = vec3(0.2125, 0.7154, 0.0721);

void main() {
    vec4 textureColor = vec4(1.0,1.0,1.0,1.0)*texture2D(u_texture,v_textCoords);
    float luminance = dot(textureColor.rgb, W);
//    2 1.5  1
//    float xx = luminance  * (3 - 1 * luminance);
//    xx = xx * xx;


    float a = luminance;

//    a =  (a-1)*(a-1)*-1.4+1;
//    a = sin(a * 4.1415692 /2.5);

    a = a * (5.0 - 2.7 * contrast);
//    float xx = -1;
//    a = pow(a - 1, 3.0) * xx + 1;

//    if(a<0.5f){
//        a = (1.0 - cos(a *3.141592)) / 1.5;
//    }else{
////        a = (1.0 - cos(a * 3.141592)) / 2.0;
////        a = sin(a * 3.141592 / 2.2);
//    }


    float xx = a;
//    gl_FragColor = mix(vec4(vec3(xx), textureColor.a),v_color,0.5);
//        gl_FragColor = mix(vec4(vec3(xx), textureColor.a),v_color,0.5);
    gl_FragColor = vec4(vec3(a),1);
}
