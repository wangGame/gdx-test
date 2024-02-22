/* BlurFragmentShader.glsl */
precision mediump float;
 
uniform sampler2D u_texture;
varying vec2 vTexCoord;
varying vec4 vColor;
 
void main(){
    vec4 colortemp = vColor * texture2D(u_texture, vTexCoord);
    float R=0.393*colortemp.r+0.769*colortemp.g+0.189*colortemp.b;
    float G=0.349*colortemp.r+0.686*colortemp.g+0.168*colortemp.b;
    float B=0.272*colortemp.r+0.534*colortemp.g+0.131*colortemp.b;
    gl_FragColor = vec4(R,G,B,colortemp.a);

}

