public class League {
    private Match[] matches;
    private int matchCount;
    private int clubCount;
    // add your variables here, if required
    private Club[] clubs;
    private Club[] stand;
    private String name;

    public League() {
        // assume a league can have at most 5 clubs, add code for initialization accordingly
        clubCount = 0;
        matchCount = 0;
        this.clubs=new Club[5];
    }

    public void printLeagueInfo(){
        System.out.println("League : " + name);
        printClubs();
    }

    public void printClubs(){
        System.out.println("Clubs:");
        // print the name of the clubs of this league, each one on a line
        for(int i=0;i<clubCount;i++)
            System.out.println(clubs[i].getName());
    }

    public void scheduleMatches(){
        matchCount = (clubCount*(clubCount-1));
        matches = new Match[matchCount];
        int matchNo = 0;
        for (int i=0; i<clubCount; i++){
            for (int j=0; j<clubCount; j++){
                // check the constructor of the Match class and add your code here
                // note that there will be two matches between club A and club B
                // in the first match, club A will play as the home team and in the second match, as the away team
                if(i==j)
                    continue;
                Match temp=new Match(matchNo,clubs[i],clubs[j]);
                matches[matchNo]=temp;
                matchNo++;
            }
        }
    }

    public void simulateMatches(){
        for(int i=0;i<clubCount;i++)
            clubs[i].setPoint(0);
        for (int i=0; i<matchCount; i++){
            matches[i].play();
        }
    }

    public void showStandings(){
        // sort the clubs in descending order of points
        // note that, the sequence in which clubs were added to the league, should be unchanged
        // check the given sample output for clarification
        // (carefully observe the output of showStandings() followed by printLeagueInfo() method calls
        // you can use additional arrays if needed
        System.out.println("Sl. - Club - Points");
        // print the clubs in descending order of points
        stand=new Club[5];
        for(int i=0;i<clubCount;i++)
            stand[i]=clubs[i];
        for(int i=0;i<clubCount;i++)
        {
            for(int j=i+1;j<clubCount;j++)
            {
                if(stand[i].getPoint()<stand[j].getPoint())
                {
                    Club temp=stand[i];
                    stand[i]=stand[j];
                    stand[j]=temp;
                }
            }
        }
        for(int i=0;i<clubCount;i++)
            System.out.print(i+1 + ". " + stand[i].getName() + " " + stand[i].getPoint() + "\n");

    }

    // add your methods here, if required
    public void setName(String name){
        this.name=name;
    }

    public void addClub(Club c)
    {
        this.clubs[clubCount]=c;
        clubCount++;
    }

    public void printMatches()
    {
        System.out.println("Matches:");
        for(int i=0;i<matchCount;i++)
            matches[i].showResult();
    }

    public void removeClub(Club c)
    {
        for(int i=0;i<clubCount;i++)
        {
            if(clubs[i]==c)
            {
                for(int j=i;j<clubCount-1;j++)
                    clubs[j]=clubs[j+1];
                clubCount--;
            }
        }
    }
}
