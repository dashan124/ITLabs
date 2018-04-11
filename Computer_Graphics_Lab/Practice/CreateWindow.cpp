#include<stdio.h>
#include<GL/glut.h>


void display()
{
    glBegin(GL_LINES);
                glColor3f(1.0,0.0,1.0);
              glVertex2i(0,0);
              glVertex2i(400,400);
       glEnd();

glutSwapBuffers();
}

void reshape(int w, int h)
{
glViewport(0.0, 0.0, w, h);
}
void intiopenGL()
{
glClearColor(1.0, 1.0, 1.0, 1.0);
}
int main(int argc, char** argv)
{
glutInit(&argc, argv);
glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGBA | GLUT_DEPTH);
glutInitWindowSize(800, 600);
glutInitWindowPosition(0,0);
glutCreateWindow("OpenGL Test");

intiopenGL();

glutDisplayFunc(display);
//glutIdleFunc(display);
//glutReshapeFunc(reshape);
glutMainLoop();


return 0;
}
