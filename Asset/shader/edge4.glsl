#ifdef GL_ES
precision mediump float;
#endif


//input from vertex shader
varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;


void main() {
    float offset = 0.0036;
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
    float xxx = 3.0;
    float h = -topLeftColor.b - xxx * topColor.b - topRightColor.b
    + bottomLeftColor.b +xxx * bottomColor.b+ bottomRightColor.b;
    float v = -bottomLeftColor.r - xxx * leftColor.r - topLeftColor.r
    + bottomRightColor.r + xxx * rightColor.r+ topRightColor.r;
    float mag = length(vec2(-h, -v));


    gl_FragColor = vec4(0, 0, 0,mag);
//    gl_FragColor = vec4(194.0/255, 169.0/255, 153.0/255,mag);

}