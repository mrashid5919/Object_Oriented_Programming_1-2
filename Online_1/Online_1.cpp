#include<iostream>
#include<cstdlib>
using namespace std;

class Random
{
    int** mat=NULL;
    int n,m,p,q,sum;
public:
    Random(int r,int c,int mn,int mx)
    {
        n=r;
        m=c;
        p=mn;
        q=mx;
        mat=(int**)malloc(n*sizeof(int*));
        for(int i=0;i<n;i++)
            mat[i]=(int*)malloc(m*sizeof(int));
    }
    ~Random()
    {
        for(int i=0;i<n;i++)
            free(mat[i]);
        free(mat);
    }
    void print()
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
                cout<<*(*(mat+i)+j)<<" ";
            cout<<"\n";
        }
    }
    void randomize()
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
                mat[i][j]=rand()%(p+1)+(q-p);
        }
    }
    int get(int x,int y)
    {
        return mat[x][y];
    }
    void add(int x)
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
                mat[i][j]+=x;
        }
    }
    int add()
    {
        sum=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
                sum+=mat[i][j];
        }
        return sum;
    }
};

int main()
{
    cout<<"Hello World"<<'\n';
    Random m(3,3,100,200);
    m.randomize();
    m.print();
    cout<<m.get(0,0)<<'\n';
    m.add(100);
    m.print();
    cout<<m.add()<<'\n';

 return 0;
}
