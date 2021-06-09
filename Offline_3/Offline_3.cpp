#include<iostream>
#include<cstring>
using namespace std;

class Vector
{
    char *name;
    int x,y,z;
public:
    Vector(char *n)
    {
        int l = strlen(n);
        name = new char[l+1];
        strcpy(name,n);
        x=0;
        y=0;
        z=0;
    }
    Vector(char *n, int a, int b, int c)
    {
        int l = strlen(n);
        name = new char[l+1];
        strcpy(name,n);
        x=a;
        y=b;
        z=c;
    }
    Vector(const Vector& v)
    {
        int l=strlen(v.name);
        this->name=new char[l+1];
        strcpy(this->name,v.name);
        this->x=v.x;
        this->y=v.y;
        this->z=v.z;
    }

    int setX(int a){x=a;}
    int setY(int b){y=b;}
    int setZ(int c){z=c;}

    void setName(char *n)
    {
        int l = strlen(n);
        name = new char[l+1];
        strcpy(name,n);
    }

    int getX(){return x;}
    int getY(){return y;}
    int getZ(){return z;}

    char *getName(){return name;}

    ~Vector()
    {
        delete []name;
    }

    void print()
    {
        cout<<name<<": ";
        cout<<x<<"x";
        if(y>=0)
            cout<<"+"<<y<<"y";
        else
            cout<<y<<"y";
        if(z>=0)
            cout<<"+"<<z<<"z";
        else
            cout<<z<<"z";
        cout<<endl;
    }

    Vector operator^(Vector obj)
    {
        Vector temp("Result1");
        temp.x=(this->y*obj.z)-(obj.y*this->z);
        temp.y=(this->z*obj.x)-(obj.z*this->x);
        temp.z=(this->x*obj.y)-(obj.x*this->y);
        return temp;
    }

    int operator==(Vector obj)
    {
        return (x==obj.x) && (y==obj.y) && (z==obj.z);
    }

    Vector operator=(const Vector &ob)
    {
        this->x=ob.x;
        this->y=ob.y;
        this->z=ob.z;
        return *this;
    }

    friend Vector operator*(Vector ob1,Vector ob2)
    {
        Vector temp("Result1");
        temp.x=ob1.x*ob2.x;
        temp.y=ob1.y*ob2.y;
        temp.z=ob1.z*ob2.z;
        return temp;
    }

    friend Vector operator*(Vector ob,int i)
    {
        Vector temp("v1");
        temp.x=i*ob.x;
        temp.y=i*ob.y;
        temp.z=i*ob.z;
        return temp;
    }

    friend Vector operator*(int i,Vector ob)
    {
        Vector temp("v2");
        temp.x=i*ob.x;
        temp.y=i*ob.y;
        temp.z=i*ob.z;
        return temp;
    }
};

int main()
{
    Vector v1("v1", 1,2,3), v2("v2", 4, 5, -6), v3("Result1"),v4("Result2",-27,18,-3);
    v1.print();     ///Print the components of vector v1
    v2.print();     ///Print the components of vector v2

    v3=v1^v2;       ///Calculate the cross product of vector v1 and vector v2 (Consider ^ as cross product for this assignment)
    v3.print();     ///Print the modified components of vector v3 (Name: Result1)

    if(v3==v4)      ///Check for equality; if two vectors contain equal component values (x, y, z), then they are equal.
        cout<<"Vectors are equal"<<endl;
    else
        cout<<"Vectors are not equal"<<endl;

    v1= v1*2;       ///Multiply each component of vector v1 with the given value
    v1.print();     ///Print the modified components of vector v1

    v2=2*v2;        ///Multiply each component of vector v2 with the given value
    v2.print();     ///Print the modified components of vector v2

    v3=v1*v2;       ///Multiply each component of vector v1 with the corresponding component of vector v2.
    v3.print();     ///Print the modified components of vector v3 (Name: Result1)

    if(v3==v4)      ///Check for equality; if two vectors contain equal component values (x, y, z), then they are equal.
        cout<<"Vectors are equal"<<endl;
    else
        cout<<"Vectors are not equal"<<endl;

    return 0;
}
