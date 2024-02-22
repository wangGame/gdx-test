/* BlurFragmentShader.glsl */
precision mediump float;
 
uniform sampler2D u_texture;
varying vec2 vTexCoord;
varying vec4 vColor;
 
void main(){
    float center = 0.5;
    float xx = vTexCoord.x - center;
    float yy = vTexCoord.y - center;
    float x1 = (xx / 2.0) * sqrt((xx * xx + yy * yy) / 0.1) + center;
    float y1 = (yy / 2.0) * sqrt((xx * xx + yy * yy) / 0.1) + center;
    vec2 pos = new vec2(x1,y1);
    gl_FragColor = vColor * texture2D(u_texture, pos);
}

