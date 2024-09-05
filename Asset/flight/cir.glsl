#ifdef GL_ES
precision mediump float;
#endif
varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;

void main() {
     float offset = 0.006;
     float Gx = -1.0 * (v_color* texture2D(u_texture,v_textCoords + offset * vec2(-1.0, -1.0))).r+
                1.0 * (v_color* texture2D(u_texture,v_textCoords + offset * vec2(1.0, -1.0))).r+
                -2.0 * (v_color* texture2D(u_texture,v_textCoords + offset * vec2(-1.0, 0.0))).r+
                2.0 * (v_color* texture2D(u_texture,v_textCoords + offset * vec2(1.0, 0.0))).r+
                -1.0 * (v_color* texture2D(u_texture,v_textCoords + offset * vec2(-1.0, 1.0))).r+
                1.0 * (v_color* texture2D(u_texture,v_textCoords + offset * vec2(1.0, 1.0))).r;


     float Gy = -1.0 * (v_color* texture2D(u_texture,v_textCoords + offset * vec2(-1.0, -1.0))).r+
                -2.0 * (v_color* texture2D(u_texture,v_textCoords + offset * vec2(0.0, -1.0))).r+
                -1.0 * (v_color* texture2D(u_texture,v_textCoords + offset * vec2(1.0, -1.0))).r+
                1.0 * (v_color* texture2D(u_texture,v_textCoords + offset * vec2(-1.0, 1.0))).r+
                2.0 * (v_color* texture2D(u_texture,v_textCoords + offset * vec2(0.0, 1.0))).r+
                1.0 * (v_color* texture2D(u_texture,v_textCoords + offset * vec2(1.0, 1.0))).r;

    float edgeMagnitude = length(vec2(Gx, Gy));
    if(edgeMagnitude>0.6){
        gl_FragColor = vec4(0.0,0,0,1.0f);
    }else{
        discard;
    }
}