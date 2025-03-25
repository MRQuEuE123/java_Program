public class Dragonfly extends Animal{
    public Dragonfly(String name, int footNumber, Boolean hasMustache) {
        super(name, footNumber, hasMustache);
    }
    @Override
    public void voice(){
        System.out.println("bj-w-w");
    }

    @Override
    public void move() {
        System.out.println("I want insects");
    }

    @Override
    public void isHungry() {
        System.out.println("flight");
    }
}

