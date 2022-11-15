#ifdef GL_ES
precision mediump float;
#endif
varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;

vec4 clam(vec4 ve){
    if(ve.r > 1.0){
        ve.r = 1;
    }
    if(ve.g > 1.0){
        ve.g = 1.0;
    }
    if(ve.b > 1.0){
        ve.b = 1.0;
    }
    return ve;
}

void main() {
    vec4 textureColor = v_color* texture2D(u_texture,v_textCoords);
    vec4 end = vec4(textureColor.rgb * pow(2.0, 2), textureColor.w);






    float rrr = (end.r + end.g + end.b) / 6.0;
    if(rrr<0.65){
        gl_FragColor = vec4(0,0,0,(rrr));
    }else{
        discard;
    }
}