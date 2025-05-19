attribute vec4 av_Position;
attribute vec2 af_Position;
varying vec2 v_texPosition;
uniform mat4 mvpMatrix;
void main() {
    v_texPosition = af_Position;
    gl_Position = mvpMatrix*av_Position;
}