public class Kangaroo extends Animal{

    public Kangaroo(String name, int footNumber, Boolean hasMustache) {
        super(name, footNumber, hasMustache);

    }
    @Override
    public void voice(){
        System.out.println("khe-khe");
    }

    @Override
    public void move() {
        System.out.println("I want berries");
    }

    @Override
    public void isHungry() {
        System.out.println("jump-jump");
    }
}

