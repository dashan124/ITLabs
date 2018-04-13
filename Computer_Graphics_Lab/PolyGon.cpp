#include <GL/glut.h>
#include<GL/glu.h>
#include <stdlib.h>
#include <math.h>
#include<iostream>
#define M_PI  3.14159265358979323846
using namespace std;
int n;
int (*xy)[2];
double angle;
void Translation(int *x,int *y,int X,int Y);
void Rotation(int *x,int *y,int X,int Y);
void MatrixMultiplication(float m[3][3],int *cord[3][1]);
void Scaling(int *x,int *y,int Sx,int Sy);
void MatrixMultiplication(float m[3][3],int *cord[3][1])
{ int i,k,sum=0;
    float x[2][1];
  for(i=0;i<3;i++)
  { sum=0;
    for(k=0;k<3;k++)
    { sum+=m[i][k]*(*cord[k][0]);

    }
     x[i][0]=sum;
  }
  *cord[0][0]=round(x[0][0]);
  *cord[1][0]=round(x[1][0]);
  *cord[2][0]=round(x[2][0]);
}
void Rotation(int *x,int *y,int X,int Y)
{ Translation(x,y,-1*X,-1*Y);
   float m[3][3]={{cos(angle),-1*sin(angle),0},{sin(angle),cos(angle),0},{0,0,1}};
  int W=1;
  int *w=&W;
  int *cord[3][1]={{x},{y},{w}};
  MatrixMultiplication(m,cord);
 Translation(x,y,X,Y);
}
void Translation(int *x,int *y,int X,int Y)
{  float m[3][3]={{1,0,X},{0,1,Y},{0,0,1}};
  int W=1;
  int *w=&W;
  int *cord[3][1]={{x},{y},{w}};
  MatrixMultiplication(m,cord);

}
void Scaling(int *x,int *y,int Sx,int Sy)
{  float m[3][3]={{Sx,0,0},{0,Sy,0},{0,0,1}};
  int W=1;
  int *w=&W;
  int *cord[3][1]={{x},{y},{w}};
  MatrixMultiplication(m,cord);

}
void setPixel2(int x,int y)
{ //Rotation(&x,&y,50,50);
 Scaling(&x,&y,2,2);
 Translation(&x,&y,100,200);

glBegin(GL_POINTS);
glVertex2i(x,y);
glEnd();
glutSwapBuffers();
}
void setPixel (GLint xCoord, GLint yCoord,float m)
{
 if(m<=1.0 && m>=0)
 {
 setPixel2(xCoord, yCoord);

 }
 else if(m>1.0)
 {
 setPixel2(yCoord, xCoord);

 }
 else if(m>-1.0 && m<0)
 {
 setPixel2(xCoord, -1*yCoord);

 }
 else if(m<=-1.0)
 {
setPixel2(-1*yCoord, xCoord);

 }


}
void swap(int *x,int *y)
{int temp;
    temp=*x;
    *x=*y;
    *y=temp;
}
void Bresenhams (int x0,int y00,int xEnd,int yEnd)
{ float m ;
    if (xEnd-x0==0)
    m=48;
else
m=(float)(yEnd-y00)/(xEnd-x0);
   if (m>1)
   { swap(&yEnd,&xEnd);
     swap(&y00,&x0);
   }
   else if(m>-1 && m<0)
   { y00=-1*y00;
     yEnd=-1*yEnd;
   }
   else  if(m<=-1)
   { swap(&yEnd,&xEnd);
     swap(&y00,&x0);
     y00=-1*y00;
     yEnd=-1*yEnd;
   }
if(x0>xEnd)
{ swap(&x0,&xEnd);
  swap(&y00,&yEnd);
}
  int dx=xEnd -x0;
   int dy=yEnd-y00;
   int x=x0,y=y00;
  int dne=2*(dy-dx);
  int de=2*dy;
  int d=2*dy-dx;
  for(;x<=xEnd;x++)
  { setPixel(x,y,m);


    if(d>0)
    {
        y=y+1;
        d=d+dne;
    }
    else
     d=d+de;
  }


}
void Polygon()
{int i;
for(i=0;i<n;i++)
{
    Bresenhams(*(*(xy+i)+0),*(*(xy+i)+1),*(*(xy+(i+1)%n)+0),*(*(xy+(i+1)%n)+1));
}
glFlush();
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
{ int i;
cout<<"enter number of points \n";
cin>>n;
cout<<"enter coordinates\n";
int xxy[n][2];
xy=&xxy[0];
for(i=0;i<n;i++)
cin>>xxy[i][0]>>xxy[i][1];
angle=45*M_PI/180;

glutInit(&argc, argv);
glutInitDisplayMode(GLUT_SINGLE | GLUT_RGBA );
glutInitWindowSize(800, 600);
glutInitWindowPosition(0,0);
glutCreateWindow("POLYGON");
gluOrtho2D(-400,400,-300,300);//x-axis:-400-400 ; y-axis: -300-300
intiopenGL();

glutDisplayFunc(Polygon);

//glutIdleFunc(line);
//glutIdleFunc(lin);
glutReshapeFunc(reshape);
glutMainLoop();
return 0;
}
