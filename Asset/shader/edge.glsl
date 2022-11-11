#ifdef GL_ES
precision mediump float;
#endif


//input from vertex shader
varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;


void main() {
    float offset = 0.003;
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
    float xxx = 1.5;
    float h = -topLeftColor.g - xxx * topColor.g - topRightColor.g
    + bottomLeftColor.g +xxx * bottomColor.g+ bottomRightColor.g;

    float v = -bottomLeftColor.r - xxx * leftColor.r - topLeftColor.r
    + bottomRightColor.r + xxx * rightColor.r+ topRightColor.r;

    float mag = length(vec2(-h, -v));
//    if(mag<0.0000001){
////        discard;
//        gl_FragColor = vec4(vec3(231.0/255.0,200.0/255.0,187.0/255.0),1);
//    }else{
    vec3 W = vec3(0.2125, 0.7154, 0.0721);
    vec4 textureColor = v_color* texture2D(u_texture,v_textCoords);
    float luminance = dot(textureColor.rgb, W);
    if(luminance<0.3){
        discard;
    }else{
        gl_FragColor = vec4(vec3(luminance), textureColor.a);

    }
//        gl_FragColor = mix(vec4(vec3(1-mag), 1.0),vec4(231.0/255.0,200.0/255.0,187.0/255.0,1),0.9);
//    }

}