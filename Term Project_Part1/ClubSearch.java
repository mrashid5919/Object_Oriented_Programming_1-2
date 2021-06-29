import java.util.Scanner;

public class ClubSearch extends Menu{
    private static boolean b;

    public static void setB(boolean b) {
        ClubSearch.b = b;
    }

    public static void ClubMaxSalary(){
        double ms=0.0;
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Club Name: ");
        String cln=sc.nextLine();
        for(Player p:playerList){
            if(p.getWeeklySalary()>=ms && p.getClub().equalsIgnoreCase(cln)){
                b=true;
                ms=p.getWeeklySalary();
            }
        }
        if(!b){
            System.out.println("No such club with this name");
        }
        else{
            for(Player p:playerList){
                if(p.getWeeklySalary()==ms && p.getClub().equalsIgnoreCase(cln)){
                    p.displayPlayerInfo();
                }
            }
        }
    }

    public static void ClubMaxAge(){
        int ma=0;
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Club Name: ");
        String cln=sc.nextLine();
        for(Player p:playerList){
            if(p.getAge()>=ma && p.getClub().equalsIgnoreCase(cln)){
                b=true;
                ma=p.getAge();
            }
        }
        if(!b)
            System.out.println("No such club with this name");
        else{
            for(Player p:playerList){
                if(p.getAge()==ma && p.getClub().equalsIgnoreCase(cln)){
                    p.displayPlayerInfo();
                }
            }
        }
    }

    public static void ClubMaxHeight(){
        double mh=0.0;
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Club Name: ");
        String cln=sc.nextLine();
        for(Player p:playerList){
            if(p.getHeight()>=mh && p.getClub().equalsIgnoreCase(cln)){
                b=true;
                mh=p.getHeight();
            }
        }
        if(!b){
            System.out.println("No such club with this name");
        }
        else{
            for(Player p:playerList){
                if(p.getHeight()==mh && p.getClub().equalsIgnoreCase(cln)){
                    p.displayPlayerInfo();
                }
            }
        }
    }

    public static void ClubTotalSalary(){
        double ts=0.0;
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Club Name: ");
        String cln=sc.nextLine();
        for(Player p:playerList){
            if(p.getClub().equalsIgnoreCase(cln)){
                b=true;
                ts+=p.getWeeklySalary()*52;
            }
        }
        if(!b){
            System.out.println("No such club with this name");
        }
        else
        {
            System.out.printf("Total salary: %10f",ts);
            System.out.println();
        }
    }

}
