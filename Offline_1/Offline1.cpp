#include<iostream>
#include<cmath>
using namespace std;

class Point
{
    int x,y;
public:
    Point(){}
    Point(int a,int b)
    {
        x=a;
        y=b;
    }
    void setPoint(int a,int b)
    {
        x=a;
        y=b;
    }
    int getx()
        {return x;}
    int gety()
        {return y;}
    void print()
    {
        cout<<"Coordinate: "<<x<<", "<<y<<endl;
    }
};

class Circle
{
    Point p;
    int radius;
public:
    Circle(int a,int b,int r)
    {
        radius=r;
        p.setPoint(a,b);
    }
    void update(int a,int b)
    {
        p.setPoint(p.getx()+a,p.gety()+b);
    }
    void update(int r)
    {
        radius+=r;
    }
    void update(int a,int b,int r)
    {
        p.setPoint(p.getx()+a,p.gety()+b);
        radius+=r;
    }
    void print()
    {
        cout<<"Center ";
        p.print();
        cout<<"Radius: "<<radius<<"\n";
    }
};

class Line
{
    Point p1,p2;
public:
    Line(int a1,int a2,int b1,int b2)
    {
        p1.setPoint(a1,b1);
        p2.setPoint(a2,b2);
    }
    void print_length()
    {
        int x1=p1.getx();
        int y1=p1.gety();
        int x2=p2.getx();
        int y2=p2.gety();
        double len=sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
        cout<<"Length of the line: "<<len<<endl;
    }
};

int main()
{
    Point p(5,5);
    Circle c(2,3,5);

    cout<<endl<<"Point Display"<<endl;
    p.print();
    cout<<endl<<"Circle Display"<<endl;
    c.print();
    cout<<endl;

    cout<<"First Update"<<endl;
    c.update(5,5);
    c.print();
    cout<<endl;

    cout<<"Second Update"<<endl;
    c.update(6);
    c.print();
    cout<<endl;

    cout<<"Third Update"<<endl;
    c.update(2,2,2);
    c.print();
    cout<<endl;

    Line l(3,2,1,4);
    l.print_length();
    return 0;
}
