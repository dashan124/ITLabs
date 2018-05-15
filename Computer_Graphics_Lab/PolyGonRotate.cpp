#include<stdio.h>
#include<GL/glut.h>
#include<bits/stdc++.h>
#include <math.h>
using namespace std;
void keyPress(unsigned char key,int x,int y)
{

    switch(key)
    {
       case 27:
            exit(0);
    }
}
void initRendering(){
glEnable(GL_DEPTH_TEST);
}
void handleResize(int w,int h){
glViewport(0,0,w,h);
glMatrixMode(GL_PROJECTION);
glLoadIdentity();
gluPerspective(45.0,(double)w/(double)h,1.0,200.0);
}
float angle=1.0f;
float camre=0.0f;
void display(){
glClear(GL_COLOR_BUFFER_BIT);

//glLineWidth(2.5);
glRotated(angle,0.0f,1.0f,0.0f);
glTranslated(0.0011,0.0011,0);
glScalef(1.01,1.01,0);
glColor3f(0.3, 0.3, 0.3);
glBegin(GL_TRIANGLES);
glVertex3f(-0.3, -0.3, 0.0);
glVertex3f(0.3, -0.3, 0.0);
glVertex3f(0.0,+0.3,0.0);
glEnd();
glutSwapBuffers();
}
void reshape(int w, int h)
{
glViewport(0.0, 0.0, w, h);
}
void intiopenGL()
{
glClearColor(1.0, 0.0, 0.0, 1.0);
}
int main(int argc, char** argv)
{
glutInit(&argc, argv);
glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGBA | GLUT_DEPTH);
glutInitWindowSize(500, 500);
glutInitWindowPosition(100, 100);
glutCreateWindow("OpenGL Test");
intiopenGL();
glutDisplayFunc(display);
glutIdleFunc(display);
glutReshapeFunc(reshape);
glutMainLoop();
}
