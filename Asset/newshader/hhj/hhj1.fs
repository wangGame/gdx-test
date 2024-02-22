/* BlurFragmentShader.glsl */
precision mediump float;
 
uniform sampler2D u_texture;
varying vec2 vTexCoord;
varying vec4 vColor;

void main(){
    vec2 p = (vTexCoord - 0.5) * 2.0;
    float radius = 0.7 * length(p);
    vec2 uv = p * (1.0 + radius * radius);
    vec4 color = vColor*texture2D(u_texture, uv * 0.5 + 0.5);
    gl_FragColor = color;
}

