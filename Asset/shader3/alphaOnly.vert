#version 150


uniform mat4 u_camera;
uniform mat4 u_world;

in vec3 a_position;
in float a_alpha;

out float v_alpha;


void main() {

	v_alpha = a_alpha;
	
	gl_Position = u_camera * u_world * vec4(a_position, 1);
}