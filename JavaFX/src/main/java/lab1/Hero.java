package lab1;

public class Hero {

    private String name;
    public Hero(String name){
        this.name = name;
    }

    public String move(Strategy strategy){
        strategy.move();
        return (name +" "+ strategy.move()+"\n");
    }

}
