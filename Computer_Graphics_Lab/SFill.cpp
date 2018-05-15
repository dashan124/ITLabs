#include<GL/glut.h>
#include<vector>
#include<fstream>
#include<algorithm>
#include<cmath>
#include<limits>
using namespace std;
const int n = 4;

class Point{
public:
    int x, y;
    Point(){
    };
    Point(int a, int b){
        x = a;
        y = b;
    };
    void set(int a, int b){
        x = a;
        y = b;
    };
};
Point P[n];
int min(int x, int y)
{
    if (x <= y) return x;
    else return y;
}
int max(int x, int y)
{
    if (x >= y) return x;
    else return y;
}
double solve(int y, Point A, Point B)
{
    if (y >= min(A.y, B.y) && y <= max(A.y, B.y))
    {
        return ((y * B.x) - (y * A.x) - (A.y * B.x) + (A.x * B.y)) / (B.y - A.y);
    }
    else return -1;
}

bool doubleComparison(double i, double j) { return (i < j); }
bool isVertex(int x, int y)
{
    for (int i = 0; i < n; i++)
    {
        if (P[i].x == x && P[i].y == y) return 1;
    }
    return 0;
}
void scanfill()
{
    int i, j, color = 1, k;
    double x;
    vector<double> inter[501];

    for (j = 0; j < 500; j++)
    {
        for (k = 0; k < n - 1; k++)
        {
            x = solve(j, P[k], P[k + 1]);
            if (x != -1 && !isVertex(x,j))
            {
                inter[j].push_back(x);
            }
        }
        x = solve(j, P[n - 1], P[0]);
        if (x != -1 && !isVertex(x, j))
        {
            inter[j].push_back(x);
        }
    }
    for (j = 0; j < 500; j++)
    {
        sort(inter[j].begin(), inter[j].end(), doubleComparison);
    }

    for (j = 0; j < 500; j++)
    {
        glColor3f(0.0, 0.0, 1.0);
        glBegin(GL_LINES);
        for (vector<double>::iterator it = inter[j].begin(); it != inter[j].end(); it++)
        {
            glVertex2d(*it, j);
        }
        glEnd();

    }



}


void display()
{
    glClear(GL_COLOR_BUFFER_BIT);
    glColor3f(0.0, 0.0, 0.0);

    P[0] = Point(100,100);
    P[1] = (Point(200,300));
    P[2] = (Point(100,400));
    P[3] = (Point(0,300));
  /* P[4] = (Point(393, 175));
    P[5] = (Point(393, 390-175));
   P[6] = (Point(150, 111));*/
    glBegin(GL_LINE_LOOP);
    for (int i = 0; i < n; i++)
    {
        glVertex2i(P[i].x, P[i].y);
    }
    glEnd();

    scanfill();


    glFlush();
}


void init()
{
    glClearColor(1.0, 1.0, 1.0, 1.0);
    //glMatrixMode(GL_PROJECTION);
    //glLoadIdentity();
    glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	glOrtho(0, 1000, 10.0, 650,-2000,1500);
	glMatrixMode(GL_MODELVIEW);
  //  gluOrtho2D(0.0, 499.0, 0.0, 499.0);
}

int main(int argc, char **argv)
{
    glutInit(&argc, argv);
    glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB);
    glutInitWindowSize(1000, 650);
    glutInitWindowPosition(0,0);

    glutCreateWindow("scanline");
    glutDisplayFunc(display);

    init();
    glutMainLoop();
    return 0;
}
