public class Club {
    private int id;
    private String name;
    private Player[] players;
    private int playerCount;
    // add your code here

    // you are not allowed to write any other constructor
    public Club() {
        this.players = new Player[11];
        playerCount=0;
    }

    public double getSalary() {
        double total = 0;
        for (int i = 0; i < playerCount; i++) {
            total += players[i].getSalary();
        }
        return total;
    }

    public void addPlayer(Player p){
        this.players[playerCount]=p;
        playerCount++;
    }

    public void setId(int number){
        this.id=number;
    }

    public void setName(String name)
    {
        this.name=name;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public Player getMaxSalaryPlayer(){
        Player temp=players[0];
        double mx=players[0].getSalary();
        for(int i=0;i<playerCount;i++)
        {
            if(i==0) {
                temp=players[i];
                mx=players[i].getSalary();
            }
            else if(players[i].getSalary()>mx){
                temp=players[i];
                mx=players[i].getSalary();
            }
        }
        return temp;
    }
}
