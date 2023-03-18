#ifdef GL_ES
precision mediump float;
#endif


//input from vertex shader
varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
uniform float time;

void main() {
    vec2 uv = v_textCoords;
    vec3 col = texture(u_texture, uv).rgb;
    float r = sin(col.r * 6.28 * .9);
    vec3 silhouette = vec3(smoothstep(0., .8, 1. - pow(r, 6.)));
    col = mix(col * silhouette, silhouette, sin(time * .8) * .5 + .5);
    gl_FragColor = vec4(col,1.0);

//
//    vec4 textureColor = v_color* texture2D(u_texture,v_textCoords);
//    float offset=0.01;
//    vec2 temp = v_textCoords;

    //    vec2 bottomLeftTextureCoordinate = temp;
//    bottomLeftTextureCoordinate.x = temp.x - offset;
//    bottomLeftTextureCoordinate.y = temp.y + offset;
//
//    vec2 topRightTextureCoordinate = temp;
//    topRightTextureCoordinate.x = temp.x + offset;
//    topRightTextureCoordinate.y = temp.y - offset;
//
//    vec2 topLeftTextureCoordinate = temp;
//    topLeftTextureCoordinate.x = temp.x - offset;
//    topLeftTextureCoordinate.y = temp.y - offset;
//
//    vec2 bottomRightTextureCoordinate = temp;
//    bottomRightTextureCoordinate.x = temp.x + offset;
//    bottomRightTextureCoordinate.y = temp.y + offset;
//
//    vec2 leftTextureCoordinate = temp;
//    leftTextureCoordinate.x = temp.x - offset;
//    leftTextureCoordinate.y = temp.y;
//
//    vec2 rightTextureCoordinate = temp;
//    rightTextureCoordinate.x = temp.x + offset;
//    rightTextureCoordinate.y = temp.y;
//
//    vec2 bottomTextureCoordinate = temp;
//    bottomTextureCoordinate.x = temp.x;
//    bottomTextureCoordinate.y = temp.y + offset;
//
//    vec2 topTextureCoordinate = temp;
//    topTextureCoordinate.x = temp.x;
//    topTextureCoordinate.y = temp.y - offset;
//
//    float bottomLeftIntensity = texture2D(  u_texture, bottomLeftTextureCoordinate).r;
//    float topRightIntensity = texture2D(    u_texture, topRightTextureCoordinate).r;
//    float topLeftIntensity = texture2D(     u_texture, topLeftTextureCoordinate).r;
//    float bottomRightIntensity = texture2D( u_texture, bottomRightTextureCoordinate).r;
//    float leftIntensity = texture2D(        u_texture, leftTextureCoordinate).r;
//    float rightIntensity = texture2D(       u_texture, rightTextureCoordinate).r;
//    float bottomIntensity = texture2D(      u_texture, bottomTextureCoordinate).r;
//    float topIntensity = texture2D(         u_texture, topTextureCoordinate).r;
//    float centerIntensity = textureColor.r;
//
//    float h = -topLeftIntensity - 2.0 * topIntensity - topRightIntensity + bottomLeftIntensity + 2.0 * bottomIntensity + bottomRightIntensity;
//    float v = -bottomLeftIntensity - 2.0 * leftIntensity - topLeftIntensity + bottomRightIntensity + 2.0 * rightIntensity + topRightIntensity;
//    float mag = length(vec2(h, v));
//    gl_FragColor = vec4(vec3(1.0-mag*mag), 1.0*textureColor.a);








//    gl_FragColor = textureColor;
//    gl_FragColor.a = mag ;

//    float pixelIntensitySum = bottomLeftIntensity +
//            topRightIntensity + topLeftIntensity +
//            bottomRightIntensity + leftIntensity +
//            rightIntensity + bottomIntensity +
//            topIntensity + centerIntensity;
//    float sumTest = step(6.8, pixelIntensitySum);
//    float pixelTest = step(0.0001, centerIntensity);
//    if(sumTest * pixelTest <0.0001){
//       gl_FragColor = textureColor;
//    }else{
////        gl_FragColor = vec4(vec3(sumTest * pixelTest), 1.0);
//discard;
//    }
}