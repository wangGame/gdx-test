/* BlurFragmentShader.glsl */
precision mediump float;
 
uniform sampler2D u_texture;
varying vec2 vTexCoord;
varying vec4 vColor;
 
void main(){
    float center = 0.5;
    float xx = vTexCoord.x - center;
    float yy = vTexCoord.y - center;
    float x1 = cos(atan2(yy,xx)) * 0.8 * sqrt(xx * xx + yy * yy) + center;
    float y1 = sin(atan2(yy,xx)) * 0.8 * sqrt(xx * xx + yy * yy) + center;
    vec2 pos = new vec2(x1,y1);
    gl_FragColor = vColor * texture2D(u_texture, pos);
}

