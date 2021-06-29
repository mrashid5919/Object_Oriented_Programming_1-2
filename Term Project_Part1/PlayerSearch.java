import java.util.HashMap;
import java.util.Scanner;

public class PlayerSearch extends Menu{
    private static boolean a;

    public static void setA(boolean a) {
        PlayerSearch.a = a;
    }

    public static void SearchPlayerName(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter player name: ");
        String nm=sc.nextLine();
        for(Player p:playerList){
            if(nm.equalsIgnoreCase(p.getName())){
                a=true;
                p.displayPlayerInfo();
            }
        }
        if(!a){
            System.out.println("No such player with this name");
        }
    }

    public static void SearchPlayerCountryClub(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Country Name: ");
        String cn=sc.nextLine();
        System.out.print("Enter Club Name: ");
        String cln=sc.nextLine();
        if(cln.equalsIgnoreCase("ANY")){
            for(Player p:playerList){
                if(cn.equalsIgnoreCase(p.getCountry())){
                    a=true;
                    p.displayPlayerInfo();
                }
            }
        }
        else{
            for(Player p:playerList){
                if(cn.equalsIgnoreCase(p.getCountry()) && cln.equalsIgnoreCase(p.getClub())){
                    a=true;
                    p.displayPlayerInfo();
                }
            }
        }
        if(!a){
            System.out.println("No such player with this country and club");
        }
    }

    public static void SearchPlayerPosition(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter position: ");
        String pn=sc.nextLine();
        for(Player p:playerList){
            if(pn.equalsIgnoreCase(p.getPosition())){
                a=true;
                p.displayPlayerInfo();
            }
        }
        if(!a){
            System.out.println("No such player with this position");
        }
    }

    public static void SearchPlayerSalary(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the starting value: ");
        double low=0.0;
        boolean x=false;
        while(!x){
            try {
                low =sc.nextDouble();
                x=true;
            }
            catch (Exception e){
                String g=sc.nextLine();
                System.out.print("Wrong input. Enter a valid salary: ");
            }
        }
        System.out.print("Enter the ending value: ");
        double high=0.0;
        x=false;
        while(!x){
            try {
                high =sc.nextDouble();
                x=true;
            }
            catch (Exception e){
                String g=sc.nextLine();
                System.out.print("Wrong input. Enter a valid salary: ");
            }
        }
        for(Player p:playerList){
            if(p.getWeeklySalary()>=low && p.getWeeklySalary()<=high){
                a=true;
                p.displayPlayerInfo();
            }
        }
        if(!a){
            System.out.println("No such player with this weekly salary range");
        }
    }

    public static void CountryPlayerCount(){
        HashMap<String, Integer> countryCount= new HashMap<String,Integer>();
        for(Player p:playerList){
            boolean c=false;
            for(String sr:countryCount.keySet()){
                if(sr.equalsIgnoreCase(p.getCountry())){
                    c=true;
                    break;
                }
            }
            if(!c){
                countryCount.put(p.getCountry(),1);
            }
            else{
                int count=countryCount.get(p.getCountry());
                countryCount.put(p.getCountry(),count+1);
            }
        }
        for(String sr:countryCount.keySet()){
            System.out.println(sr + " "+ countryCount.get(sr));
        }
    }

    public static void SearchPlayerHeight(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the minimum height: ");
        double low=0.0;
        boolean x=false;
        while(!x){
            try {
                low =sc.nextDouble();
                x=true;
            }
            catch (Exception e){
                String g=sc.nextLine();
                System.out.print("Wrong input. Enter a valid height: ");
            }
        }
        System.out.print("Enter the maximum height: ");
        double high=0.0;
        x=false;
        while(!x){
            try {
                high =sc.nextDouble();
                x=true;
            }
            catch (Exception e){
                String g=sc.nextLine();
                System.out.print("Wrong input. Enter a valid height: ");
            }
        }
        for(Player p:playerList){
            if(p.getHeight()>=low && p.getHeight()<=high){
                a=true;
                p.displayPlayerInfo();
            }
        }
        if(!a){
            System.out.println("No such player with this height range");
        }
    }


}
