import java.util.List;

public class Menu {
    public static List<Player> playerList;

    public static void Start() throws Exception{
        playerList = FileOperations.readFromFile();
    }

    public static void DisplayMainMenu(){
        System.out.println("Main Menu:");
        System.out.println("(1) Search Players");
        System.out.println("(2) Search Clubs");
        System.out.println("(3) Add Player");
        System.out.println("(4) Exit System");
        System.out.print("Enter a value between 1 to 4: ");
    }

    public static void DisplaySearchPlayers(){
        System.out.println("Player Searching Options:");
        System.out.println("(1) By Player Name");
        System.out.println("(2) By Club and Country");
        System.out.println("(3) By Position");
        System.out.println("(4) By Salary Range");
        System.out.println("(5) Country-wise player count");
        System.out.println("(6) Back to Main Menu");
        System.out.println("(7) By Height");
        System.out.print("Enter a value between 1 to 7: ");
    }

    public static void DisplaySearchClubs(){
        System.out.println("Club Searching Options:");
        System.out.println("(1) Player(s) with the maximum salary of a club");
        System.out.println("(2) Player(s) with the maximum age of a club");
        System.out.println("(3) Player(s) with the maximum height of a club");
        System.out.println("(4) Total yearly salary of a club");
        System.out.println("(5) Back to Main Menu");
        System.out.print("Enter a value between 1 to 5: ");
    }

    public static void End() throws Exception{
        FileOperations.writeToFile(playerList);
    }
}
