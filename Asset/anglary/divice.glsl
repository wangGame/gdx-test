#ifdef GL_ES
precision mediump float;
#endif

varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;

uniform float time;


void main() {

    float speed = 1.0;
    float waves = 2.0;

    vec2 u_xlat0;
    u_xlat0.x = time * speed;
    u_xlat0 = v_textCoords * vec2(vec2(waves,waves)) + u_xlat0.xx;
    u_xlat0.xy = sin(u_xlat0.xy);
    u_xlat0.xy = u_xlat0.xy * vec2(0.25,0.25)  + v_textCoords;

    vec2 u_xlat1;

//        u_xlat1.x = u_xlat0.x;
//        u_xlat1.y = v_textCoords.y;
//    }else{
        u_xlat1.x = v_textCoords.x;
        u_xlat1.y = u_xlat0.y;
//    }

    vec4 u_xlat10_0 = v_color * texture2D(u_texture, u_xlat1);
    vec4 u_xlat16_0 = u_xlat10_0 + vec4(0.1,0.1,0.1,1.0);
    gl_FragColor = u_xlat16_0;
}
//
//float waves = 0.0;
//float _Vertical = 0.0;
//
//vec2 u_xlat0;
//u_xlat0.x = time * speed;
//u_xlat0.xy = v_textCoords * vec2(vec2(waves,waves)) + u_xlat0.xx;
//u_xlat0.xy = sin(u_xlat0.xy);
//u_xlat0.xy = u_xlat0.xy  + v_textCoords;
//
//vec2 u_xlat1;
//if(0.0 < _Vertical){
//u_xlat1.x = u_xlat0.x;
//u_xlat1.y = v_textCoords.y;
//}else{
//u_xlat1.x = v_textCoords.x;
//u_xlat1.y = u_xlat0.y;
//}
//vec4 u_xlat10_0 = v_color * texture2D(u_texture, u_xlat1);
////    u_xlat10_0 = texture2D(_MainTex, u_xlat1.xy);
//u_xlat16_0 = u_xlat10_0;
//gl_FragColor = u_xlat16_0;