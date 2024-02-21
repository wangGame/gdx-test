/* BlurFragmentShader.glsl */
precision mediump float;
 
uniform sampler2D u_texture;
varying vec2 vTexCoord;
varying vec4 vColor;
 
void main(){
    float xx = vTexCoord.x - 0.5;
    float yy = vTexCoord.y - 0.5;
    vec2 pos = new vec2(xx,yy);
    float radius =  0.7*length(pos);
    vec2 pp = pos * (1.5 + radius * radius);
    gl_FragColor = vColor * texture2D(u_texture, pp + 0.5);
}

