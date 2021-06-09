#include <iostream>
#include <stdio.h>
#include<string.h>
using namespace std;

class personalInfo
{
    protected:
        char    name[30];
        int     employeeId;
        char    gender;
    public:
        personalInfo(char *pName, int eId, char g)
        {
            strcpy(name, pName);
            employeeId = eId;
            gender = g;
        }
        void showPersonalInfo(void)
        {
            cout<<"Showing personalInformation: "<<endl;
            cout << "Name: "<< name<<endl;
            cout << "Employee Id: "<<employeeId<<endl;
            cout << "Gender: "<<gender<<endl;
        }
};


class departmentInfo
{

    protected:
        char    deptName[30];
        char    assignedWork[30];
    public:
        departmentInfo(char *dName, char* aw)
        {
            strcpy(deptName, dName);
            strcpy(assignedWork, aw);
        }
        void showDepartmentalInfo(void)
        {
            cout<<"Showing Departmental Information: "<<endl;
            cout << "Department Name: "<<deptName<<endl;
            cout << "Assigned work: "<<assignedWork<<endl;
        }
};

///Write an employee class that inherits both personalInfo and departmentInfo
///Additionally, it keeps the information about employee's joining_year (integer)
/* Write Code Here */
class employee:public personalInfo,public departmentInfo
{
    char nam[10];
    int y;
    public:
    employee(char* nm,int n,char g,char* dep,char* wo,int year) : personalInfo(nm,n,g),departmentInfo(dep,wo)
    {
       y=year;
       strcpy(nam,nm);
    }
    void showEmployeeInfo()
    {
        cout<<"===Showing details information of employee: ";
        printf("%s",nam);
        cout<<"===\n";
        showPersonalInfo();
        showDepartmentalInfo();
    }
};

int main()
{
    employee emp1("A",1,'m',"CSE","Office Cleaning", 1995); //name, employeeId, gender, department name, assigned work, and joining year
    employee emp2("B",2,'f',"EEE","Typing", 1997); //name, employeeId, gender, department name, assigned work, and joining year

    emp1.showEmployeeInfo();
    emp2.showEmployeeInfo();

    return 0;
}
