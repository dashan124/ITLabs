#include<stdio.h>
#include<GL/glut.h>
#include <GL/glu.h>
float Positions[6]={
  -0.5,-0.5,
  0.0,0.5,
  0.5,-0.5
};
void display(){
  glBegin(GL_TRIANGLES);
  glVertex2f(-0.5,-0.5);
  glVertex2f(0.0,0.5);
  glVertex2f(0.5,-0.5);
  glEnd();
  glutSwapBuffers();
}

void intiopenGL()
{
glClearColor(1.0, 1.0, 1.0, 1.0);
glutSwapBuffers();
}
void reshape(int w,int h)
{
glViewport(0,0,w,h);  //drawing at the middle of the window
}
int main(int argc,char **argv){

  glutInit(&argc, argv);
  glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGBA | GLUT_DEPTH);
  glutInitWindowSize(800, 600);
  glutInitWindowPosition(0,0);
  glutCreateWindow("OpenGL Test");

  intiopenGL();

  glutDisplayFunc(display);
  glutReshapeFunc(reshape);
  glutIdleFunc(display);

  glutMainLoop();

  return 0;
}
