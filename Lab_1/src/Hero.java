
public class Hero {

    private String name;
    public Hero(String name){
        this.name = name;
    }

    public void move(Strategy strategy){
        System.out.print(name);
        strategy.move();
    }

}
