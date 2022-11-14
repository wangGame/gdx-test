#ifdef GL_ES
precision mediump float;
#endif


//input from vertex shader
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
    float offset = 0.01;
    vec2 bottomTextureCoordinate = v_textCoords;
    bottomTextureCoordinate.y += offset;

    vec4 bottomColor = texture2D(u_texture, bottomTextureCoordinate);

    vec2 bottomLeftTextureCoordinate = v_textCoords;
    bottomLeftTextureCoordinate.x -= offset;
    bottomLeftTextureCoordinate.y += offset;
    vec4 bottomLeftColor = texture2D(u_texture, bottomLeftTextureCoordinate);

    vec2 bottomRightTextureCoordinate = v_textCoords;
    bottomRightTextureCoordinate.x += offset;
    bottomRightTextureCoordinate.y += offset;
    vec4 bottomRightColor = texture2D(u_texture, bottomRightTextureCoordinate);


    vec2 textureCoordinate = v_textCoords;
    vec4 centerColor = texture2D(u_texture, textureCoordinate);

    vec2 leftTextureCoordinate = v_textCoords;
    leftTextureCoordinate.x -= offset;
    vec4 leftColor = texture2D(u_texture, leftTextureCoordinate);


    vec2 rightTextureCoordinate = v_textCoords;
    rightTextureCoordinate.x += offset;
    vec4 rightColor = texture2D(u_texture, rightTextureCoordinate);

    vec2 topTextureCoordinate = v_textCoords;
    topTextureCoordinate.y -= offset;
    vec4 topColor = texture2D(u_texture, topTextureCoordinate);


    vec2 topRightTextureCoordinate = v_textCoords;
    topRightTextureCoordinate.x += offset;
    topRightTextureCoordinate.y -= offset;
    vec4 topRightColor = texture2D(u_texture, topRightTextureCoordinate);


    vec2 topLeftTextureCoordinate = v_textCoords;
    topLeftTextureCoordinate.x -= offset;
    topLeftTextureCoordinate.y -= offset;
    vec4 topLeftColor = texture2D(u_texture, topLeftTextureCoordinate);

    /**
    x x x
    x x x
    x x x
    */
    float xxx = 2.0;
    float h = -topLeftColor.b - xxx * topColor.b - topRightColor.b
    + bottomLeftColor.b +xxx * bottomColor.b+ bottomRightColor.b;

    float v = -bottomLeftColor.r - xxx * leftColor.r - topLeftColor.r
    + bottomRightColor.r + xxx * rightColor.r+ topRightColor.r;

    float mag = length(vec2(-h, -v));

    vec4 textureColor = v_color* texture2D(u_texture,v_textCoords) * v_color;
//    vec4 exposu = vec4(textureColor.rgb * pow(2.0, 2),1);
//    //        gl_FragColor = mix(vec4(vec3(1-mag), 1.0)+exposu,vec4(231.0/255.0,200.0/255.0,187.0/255.0,1),0.93);
//    gl_FragColor = exposu;


    vec3 W = vec3(0.2125, 0.7154, 0.0721);
    float luminance = dot(textureColor.rgb, W);
    vec3 temV3 = vec3(luminance-0.1);
    vec3 exposu = vec3(temV3.rgb * pow(2, 1.70));
    if(exposu.r<0){
        exposu.r =0;
    }else if(exposu.r>1){
        exposu.r = 1;
    }
    if(exposu.g<0){
        exposu.g = 0;
    }else if(exposu.g>1){
        exposu.g = 1;
    }
    if(exposu.b<0){
        exposu.b = 0;
    }else if(exposu.b>1){
        exposu.b = 1;
    }

    vec4 baseC = vec4(230.0/255.0,208.0/255.0,191.0/255.0,1);
    int nums = 8;
    vec3 a = vec3(0.0), b = a;
    for (int t = 0; t < nums; t++)
    {
        float v = float(t+1)*.432;
        vec3 pos = vec3(a_position1.xy, .1);
        a += hash33(pos.xyz);
    }
    // vec3 col = vec3(mix(b, a, 1.0));

//    if(a.r<0.4){
//
//        gl_FragColor = textureColor * vec4(230.0/255.0,208.0/255.0,191.0/255.0,1);
//    }else{
//        gl_FragColor = textureColor;
//    }

    if(a.r > 0.4){
        vec4 xxxxx = mix(vec4(exposu,0.2),vec4(vec3(1.0-mag),0.2),0.32);
        vec4 finc = mix(xxxxx ,baseC,0.84) * baseC;
        gl_FragColor = vec4(finc.rgb,0.5);
    }else{
        vec4 xxxxx = mix(vec4(exposu,0.2),vec4(vec3(1.0-mag),0.2),0.232);
        vec4 finc = mix(xxxxx ,baseC,0.84) * baseC;
        finc.rgba = mix(finc.rgba ,  baseC,0.5);
        gl_FragColor = finc;

    }


}