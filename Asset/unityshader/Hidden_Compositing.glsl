#ifdef GL_ES
precision mediump float;
#endif


//input from vertex shader
varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
uniform sampler2D u_texture1;


void main() {

    vec4 tempColor = texture2D(u_texture,v_textCoords) * v_color;
    float xlat = tempColor.w * 0.4f;
    vec3 u_lat0 = tempColor.xyz * vec3(xlat);


//    gl_FragColor = tempColor;

    vec4 xx = texture2D(u_texture1,v_textCoords);
    xlat = xx.w * 0.4f;
    u_lat0 = vec3(xlat) * xx.xyz + u_lat0;
    gl_FragColor.xyz = u_lat0.xyz;
    gl_FragColor.w = 1.0;
}