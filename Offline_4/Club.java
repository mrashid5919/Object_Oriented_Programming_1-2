public class Club {
    private int id;
    private String name;
    private int point;

    public Club() {
        setId(0);
        setName("A");
        setPoint(0);
    }

    public void setId(int n) { this.id=n; }

    public void setName(String name)
    {
        this.name=name;
    }

    public void setPoint(int point){
        this.point=point;
    }

    public int getId() { return this.id; }

    public String getName(){
        return this.name;
    }

    public int getPoint(){
        return this.point;
    }
}
