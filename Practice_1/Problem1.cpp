#include<iostream>
#include<cstring>
using namespace std;

namespace infrastructure
{
    class pool
    {
        int height, width, depth;
        char painted_color[10];
public:
        pool(){}
        void set_properties(int h, int w, int d, char *pc)
        {
            height=h;
            width=w;
            depth=d;
            strcpy(painted_color,pc);
        }
        void show()//This function will show the dimention (height x width x depth), and the underlying painted_color information
        {
            cout<<"Height: "<<height<<"\nWidth: "<<width<<"\nDepth: "<<depth<<"\nColor: ";
            puts(painted_color);
        }
    };
}

namespace sports
{
    class pool
    {
        char table_ingredient[20];
        char table_color[10];
public:
        pool(){}
        void set_properties(char *ti, char* tc)
        {
            strcpy(table_ingredient,ti);
            strcpy(table_color,tc);
        }
        void show()
        {
            cout<<"Ingredient: ";
            puts(table_ingredient);
            cout<<"Color: ";
            puts(table_color);
        }
    };
}

int main()
{
    infrastructure::pool p1;
    p1.set_properties(1,2,3,"Blue");
    p1.show();
    cout<<"\n";
    sports::pool p2;
    p2.set_properties("Steel","Red");
    p2.show();
    return 0;
}

