precision mediump float;
uniform sampler2D u_texture;
uniform sampler2D u_texture1;
varying vec2 vTexCoord;
varying vec4 vColor;

void main(){
    vec4 colortemp = vColor * texture2D(u_texture, vTexCoord);
    vec4 colortemp1 = vColor * texture2D(u_texture1, vTexCoord);
    //nomal
    if(colortemp1.a == 0){
         gl_FragColor = colortemp;
    }else{
    //     gl_FragColor = vec4(colortemp.rgb * 0.5 + colortemp1.rgb * 0.5,colortemp1.a * colortemp.a);
    //     gl_FragColor = colortemp * colortemp1;
    //     gl_FragColor = colortemp - ((1.0-colortemp1)*(1-colortemp))/colortemp1;
    //     gl_FragColor = colortemp + colortemp1 - 1.0;
    //     gl_FragColor = colortemp / (1.0-colortemp1);
    //     gl_FragColor = colortemp + colortemp1;
    //https://www.bilibili.com/read/cv1874791/
    /*

           float xx = (colortemp1.r + colortemp1.g + colortemp1.b) / 3.0;
           if(xx <= 0.69){
               gl_FragColor = 2.0 * colortemp * colortemp1;
           }else{
               gl_FragColor = 1.0 - 2.0 * ( 1.0 - colortemp ) * ( 1.0 - colortemp1 );
           }
*/

         gl_FragColor = colortemp1 + colortemp - colortemp1 * colortemp * 2;

    //     gl_FragColor = abs(colortemp1 - colortemp);

    //    vec4 ifFlag = step(colortemp1.r+colortemp1.g+colortemp1.b,colortemp.r+colortemp.g+colortemp.b);
    //    gl_FragColor = ifFlag*(colortemp1)+(1-ifFlag)*(colortemp);


    //   vec4 ifFlag = step(colortemp1.r+colortemp1.g+colortemp1.b,colortemp.r+colortemp.g+colortemp.b);
    //   gl_FragColor = ifFlag*(colortemp)+(1-ifFlag)*(colortemp1);

    //     gl_FragColor = colortemp1 - colortemp;
    //     gl_FragColor = colortemp / colortemp1;

    }

    /*
    if(colortemp1.a == 0){
        gl_FragColor = vec4(colortemp.r,colortemp.g,colortemp.b,colortemp.a);
    }else{
        gl_FragColor = mix(colortemp,colortemp1,0.5);
    }

    if(colortemp1.a == 0){
       gl_FragColor = vec4(colortemp.r,colortemp.g,colortemp.b,colortemp.a);
    }else{
        if(colortemp.b > 0.59){
            gl_FragColor = colortemp1;
        }else{
           gl_FragColor = mix(colortemp,colortemp1,0.5);
        }
    }
   */


}

