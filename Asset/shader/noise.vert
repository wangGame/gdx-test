#ifdef GL_ES
precision mediump float;
#endif
varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
varying vec4 a_position1;
vec3 hash33(vec3 p3)
{
    p3 = fract(p3 * vec3(.1031, .1030, .0973));
    p3 += dot(p3, p3.yxz+33.33);
    return fract((p3.xxy + p3.yxx)*p3.zyx);

}
void main() {
    vec4 textureColor = v_color* texture2D(u_texture,v_textCoords);
    float xxx  = (textureColor.r + textureColor.g +textureColor.b) / 2.0F;
    int nums = 1;
    vec3 a = vec3(0.0), b = a;
    for (int t = 0; t < nums; t++)
    {
        float v = float(t+1)*.432;
        vec3 pos = vec3(a_position1.xy, .1);
        a += hash33(pos.xyz);
    }
    if(a.r > 0.4){
        gl_FragColor = textureColor ;
    }else{
        gl_FragColor = textureColor * vec4(vec3(235.0/255,210.0/255,193.0/255),1.0) ;
    }
}