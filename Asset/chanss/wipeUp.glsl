
#ifdef GL_ES
precision mediump float;
#endif
varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
uniform sampler2D u_texture1;
uniform float time;
float OFFSET = 0.4;

uniform float u;
uniform float u2;
uniform float v;
uniform float v2;
const vec3 W = vec3(0.2125, 0.7154, 0.0721);

void main() {
    float vvv = (v_textCoords.y - v) / (v2 - v);
    float uuu = (v_textCoords.x - u) / (u2 - u);

    vec2 vecCoords = vec2(vvv,uuu);

    vec4 sourceColor = texture2D(u_texture, v_textCoords) * v_color;
    vec4 sourceColor2 = texture2D(u_texture1, vecCoords) * v_color;
    float ss = (sourceColor2.r + sourceColor2.g + sourceColor2.b) / 3.0;

    float xxx = (1-ss)+time;
    float fina = xxx * xxx * xxx * xxx * xxx  ;


    float offset = (v2 - v)*0.00002f;
    vec4 finalV = v_color * texture2D(u_texture, v_textCoords);
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


    float h = -topLeftColor.r - 2.0 * topColor.r - topRightColor.r
    + bottomLeftColor.r + 2.0 * bottomColor.r + bottomRightColor.r;
    float v = -bottomLeftColor.r - 2.0 * leftColor.r -
    topLeftColor.r + bottomRightColor.r + 2.0 * rightColor.r+ topRightColor.r;
    //    float mag = length(vec2(h, v));
    float mag = length(vec2(h, v));
    mag = step(0.9, mag);


    if(mag<0.1){
        gl_FragColor = vec4(sourceColor.rgb,sourceColor.a * (fina));
    }else{
        gl_FragColor = sourceColor;
    }
//    gl_FragColor = sourceColor;
    //
//        if(thresholdResult<=0.0){
//     discard;
//    }else{
//        gl_FragColor = vec4(sourceColor.rgb,sourceColor.a * (1-fina));
////            discard;
//    }

//    gl_FragColor = mix(sourceColor2,sourceColor,0.1);
}
