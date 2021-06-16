public abstract class Animal {
    public String name;
    public int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString(){
        return name + " is a " + getClass().getName() + ", aged "+age+ " ";
    }
}
