#version 150

in float v_alpha;
out vec4 finalColor;


void main() {
	
	//premultiply
	finalColor = vec4(v_alpha,v_alpha,v_alpha,v_alpha);
}