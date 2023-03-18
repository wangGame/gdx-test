#ifdef GL_ES
precision mediump float;
#endif
varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
uniform float exposure;
void main() {
    vec4 textureColor = v_color* texture2D(u_texture,v_textCoords);
    vec3 endColor = textureColor.rgb * pow(2.0, exposure);
//    float vvv = (endColor.r + endColor.g + endColor.b)/3.0;
    if(endColor.r >1.0 && endColor.g >1.0 && endColor.b >1.0){
        gl_FragColor = vec4(endColor, 0);
    }else{
        gl_FragColor = vec4(endColor, textureColor.w);
    }
}