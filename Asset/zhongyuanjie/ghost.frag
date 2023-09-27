//#ifdef GL_ES
//precision mediump float;
//#endif
//
//varying vec4 v_color;
//varying vec2 v_textCoords;
//uniform sampler2D u_texture;
//uniform float iTime;
//float aa;
//vec2 ghost(vec2 uv){
//    uv.x+=.25*sin(.75*uv.y-iTime);
//    float eyes = smoothstep(.5,.5+aa,length(abs(uv)-vec2(1.,0.)));
//    float col = 1.;
//    float waist = (1./(1.+exp(-.18*uv.y)));
//    col *= smoothstep(2.1,2.1-aa,length(uv+vec2(0,.5))*waist);
//    float plis = (sin(1.*uv.x*waist*8.+iTime)+sin(1.5*uv.x*waist*8.-iTime*1.3));
//    col *= smoothstep(0.,aa,uv.y+11.+.25*plis);
//    float msk = col;
//    col*=mix(plis*.15+.3,.4,smoothstep(-6.,0.,uv.y));
//    return vec2(mix(col,(1.-eyes),.93),msk);
//}
//
//float moon(vec2 uv){
//    return smoothstep(3.,2.-aa,length(uv));
//}
//
////float clouds(vec2 uv){
////    vec2 uu = uv*vec2(1.,8.)+vec2(iTime*.1,.25);
////    float c = pow(texture(iChannel0,(uu.xy+uu.yx*vec2(-1,1))*.5).r,5.);
////    c*=mix(1.,mix(0.,1.,abs(uv.y*100.)),1.-c);
////    return clamp(c,0.,1.);
////}
//
//void mainImage() {
//    float sc = 12.;
//    vec2 uv = sc*(2.*fragCoord-iResolution.xy)/iResolution.y;
//    float scale_uv = sc*2./iResolution.y;
//    aa = 1.5*scale_uv;
//    uv.y-=2.5;
//    float c = 1.-(1.-clouds(uv*.01)*smoothstep(0.,.5,fragCoord.y/iResolution.y));
//    vec2 g = ghost(uv);
//    vec3 col = (vec3(1,.9,.7)*moon(uv-vec2(8,3))*(1.-c)+vec3(.015,.01,.02)*c*2.)*(1.-.7*g.y)+g.x*vec3(.8,.9,1.);
//
//    vec4 tc = texture(u_texture,v_textCoords);
//    fragColor = vec4(pow(col, vec3 (1./2.2)),tc.a);
//}