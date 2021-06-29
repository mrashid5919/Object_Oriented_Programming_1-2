import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws Exception {
        Menu.Start();
        while (true) {
            Menu.DisplayMainMenu();
            Scanner scn = new Scanner(System.in);
            int st = 0;
            boolean p=false;
            while(!p){
                try {
                    st =scn.nextInt();
                    p=true;
                }
                catch (Exception e){
                    String g=scn.nextLine();
                    System.out.print("Wrong input. Please enter an integer between 1 to 4: ");
                }
            }
            if (st == 1) {
                while (true) {
                    PlayerSearch.setA(false);
                    Menu.DisplaySearchPlayers();
                    int spt=0;
                    p=false;
                    while(!p){
                        try {
                            spt =scn.nextInt();
                            p=true;
                        }
                        catch (Exception e){
                            String g=scn.nextLine();
                            System.out.print("Wrong input. Please enter an integer between 1 to 6: ");
                        }
                    }
                    if (spt == 1) {
                        PlayerSearch.SearchPlayerName();
                    } else if (spt == 2) {
                        PlayerSearch.SearchPlayerCountryClub();
                    } else if (spt == 3) {
                        PlayerSearch.SearchPlayerPosition();
                    } else if (spt == 4) {
                        PlayerSearch.SearchPlayerSalary();
                    } else if (spt == 5) {
                        PlayerSearch.CountryPlayerCount();
                    } else if(spt==7){
                        PlayerSearch.SearchPlayerHeight();
                    }
                    else if (spt == 6)
                        break;
                    else
                        System.out.println("Wrong input. Please enter a value between 1 to 6");
                }
            }
            else if (st == 2) {
                while (true) {
                    ClubSearch.setB(false);
                    Menu.DisplaySearchClubs();
                    int sct=0;
                    p=false;
                    while(!p){
                        try {
                            sct =scn.nextInt();
                            p=true;
                        }
                        catch (Exception e){
                            String g=scn.nextLine();
                            System.out.print("Wrong input. Please enter an integer between 1 to 5: ");
                        }
                    }
                    if (sct == 1) {
                        ClubSearch.ClubMaxSalary();
                    } else if (sct == 2) {
                        ClubSearch.ClubMaxAge();
                    } else if (sct == 3) {
                        ClubSearch.ClubMaxHeight();
                    } else if (sct == 4) {
                        ClubSearch.ClubTotalSalary();
                    } else if (sct == 5)
                        break;
                    else
                        System.out.println("Wrong input. Please enter a value between 1 to 5");
                }
            }
            else if(st ==3){
                AddPlayer.Add();
            }
            else if (st == 4) {
                Menu.End();
                break;
            }
            else
                System.out.println("Wrong input. Please enter a value between 1 to 4");
        }
    }
}