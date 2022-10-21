#ifdef GL_ES
precision mediump float;
#endif


//input from vertex shader
varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
uniform float time;

void main() {
    vec4 textureColor = v_color* texture2D(u_texture,v_textCoords);
    float offset=0.001;
    vec2 temp = v_textCoords;
    vec2 leftTextureCoordinate = v_textCoords;
    leftTextureCoordinate.x -= offset;
    vec2 rightTextureCoordinate = v_textCoords;
    rightTextureCoordinate.x -= offset;
    vec2 topTextureCoordinate = v_textCoords;
    topTextureCoordinate.y += offset;
    vec2 bottomTextureCoordinate = v_textCoords;
    bottomTextureCoordinate.y -= offset;
    float centerMultiplier = 1.0 + 4.0 * time;
    float edgeMultiplier = time;
    vec4 leftTextureColor = texture2D(u_texture,leftTextureCoordinate);
    vec4 rightTextureColor = texture2D(u_texture,rightTextureCoordinate);
    vec4 topTextureColor = texture2D(u_texture,topTextureCoordinate);
    vec4 bottomTextureColor = texture2D(u_texture,bottomTextureCoordinate);
//    gl_FragColor = textureColor;
    gl_FragColor = vec4(
                            (textureColor * centerMultiplier
                                -(
                                    leftTextureColor * edgeMultiplier
                                    + rightTextureColor * edgeMultiplier
                                    + topTextureColor * edgeMultiplier
                                    + bottomTextureColor * edgeMultiplier)
                            ).rgb,
    texture2D(u_texture, bottomTextureCoordinate).w);
}
//
//
//"{\n" +
//"    mediump vec3 textureColor = texture2D(inputImageTexture, textureCoordinate).rgb;\n" +
//"    mediump vec3 leftTextureColor = texture2D(inputImageTexture, leftTextureCoordinate).rgb;\n" +
//"    mediump vec3 rightTextureColor = texture2D(inputImageTexture, rightTextureCoordinate).rgb;\n" +
//"    mediump vec3 topTextureColor = texture2D(inputImageTexture, topTextureCoordinate).rgb;\n" +
//"    mediump vec3 bottomTextureColor = texture2D(inputImageTexture, bottomTextureCoordinate).rgb;\n" +
//"\n" +
//"    gl_FragColor = vec4((textureColor * centerMultiplier - (leftTextureColor * edgeMultiplier + rightTextureColor * edgeMultiplier + topTextureColor * edgeMultiplier + bottomTextureColor * edgeMultiplier)), texture2D(inputImageTexture, bottomTextureCoordinate).w);\n" +
//"}";