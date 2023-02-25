#ifdef GL_ES
precision mediump float;
#endif

varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
uniform float contrast;

void main() {


        vec4 textureColor = v_color* texture2D(u_texture,v_textCoords);
        float temvv = vec3(1.0) * contrast * 0.05;
        if (temvv < 0){
            temvv = 0;
        }
        vec3 end = (textureColor.rgb + temvv);
        float vvvv = end.r + end.g + end.b;
        if(vvvv >=3.0){
            discard;
        }else{
            gl_FragColor = vec4(textureColor.rgb, textureColor.w);
        }
}
