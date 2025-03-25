public class Horse extends Animal{
    public Horse (String name, int footNumber, Boolean hasMustache) {
        super(name, footNumber, hasMustache);
    }
    @Override
    public void voice(){
        System.out.println("I-go-go");
    }

    @Override
    public void move() {
        System.out.println("I want hay");
    }

    @Override
    public void isHungry() {
        System.out.println("top-top");
    }
}
