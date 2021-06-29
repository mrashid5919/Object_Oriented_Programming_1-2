import java.util.HashMap;
import java.util.Scanner;

public class AddPlayer extends Menu{
    public static void Add(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Name: ");
        String name=sc.nextLine();
        for(Player p:playerList){
            if(p.getName().equalsIgnoreCase(name)){
                System.out.println("Player with the same name already exists.");
                return;
            }
        }
        name=capitalizeWord(name);
        System.out.print("Country: ");
        String country=sc.nextLine();
        country=capitalizeWord(country);
        System.out.print("Age: ");
        int age=0;
        boolean x=false;
        while(!x){
            try {
                age =sc.nextInt();
                x=true;
            }
            catch (Exception e){
                String g=sc.nextLine();
                System.out.print("Wrong input. Enter an integer: ");
            }
        }
        System.out.print("Height: ");
        double height=0.0;
        x=false;
        while(!x){
            try {
                height =sc.nextDouble();
                x=true;
            }
            catch (Exception e){
                String g=sc.nextLine();
                System.out.print("Wrong input. Enter a valid height: ");
            }
        }
        System.out.print("Club: ");
        sc.nextLine();
        String club=sc.nextLine();
        HashMap<String, Integer> clubCount= new HashMap<String,Integer>();
        for(Player p:playerList){
            boolean c=false;
            for(String sr:clubCount.keySet()){
                if(sr.equalsIgnoreCase(p.getClub())){
                    c=true;
                    break;
                }
            }
            if(!c){
                clubCount.put(p.getClub(),1);
            }
            else{
                int count=clubCount.get(p.getClub());
                clubCount.put(p.getClub(),count+1);
            }
        }
        boolean d=false;
        for(String sr:clubCount.keySet()){
            if(sr.equalsIgnoreCase(club)){
                club=sr;
                d=true;
                break;
            }
        }
        if(d && clubCount.get(club)==7){
            System.out.println("No more player can be added to this club");
            return;
        }
        if(!d){
            club=capitalizeWord(club);
            clubCount.put(club,1);
        }
        else{
            int count=clubCount.get(club);
            clubCount.put(club,count+1);
        }
        System.out.print("Position: ");
        String position=sc.nextLine();
        if(!(position.equalsIgnoreCase("Goalkeeper") || position.equalsIgnoreCase("Midfielder") || position.equalsIgnoreCase("Defender") || position.equalsIgnoreCase("Forward"))){
            System.out.println("Wrong input. Enter a valid position");
            return;
        }
        position=capitalizeWord(position);
        System.out.print("Number: ");
        int number=0;
        x=false;
        while(!x){
            try {
                number=sc.nextInt();
                x=true;
            }
            catch (Exception e){
                String g=sc.nextLine();
                System.out.print("Wrong input. Enter an integer: ");
            }
        }
        for(Player p:playerList){
            if(club.equalsIgnoreCase(p.getClub()) && number==p.getNumber()){
                System.out.println("Player with this number already exists in the club");
                return;
            }
        }
        System.out.print("Weekly Salary: ");
        double salary=0.0;
        x=false;
        while(!x){
            try {
                salary =sc.nextDouble();
                x=true;
            }
            catch (Exception e){
                String g=sc.nextLine();
                System.out.print("Wrong input. Enter an integer: ");
            }
        }
        Player p=new Player(name,country,age,height,club,position,number,salary);
        playerList.add(p);
    }

    public static String capitalizeWord(String str){
        String words[]=str.split("\\s");
        String cWord="";
        for(String w:words){
            String first=w.substring(0,1);
            String after=w.substring(1);
            cWord+=first.toUpperCase()+after.toLowerCase()+" ";
        }
        return cWord.trim();
    }
}
