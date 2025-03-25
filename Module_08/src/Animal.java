abstract public class Animal implements Voiceable,Starveble,Movable{

    String name;
    int footNumber;
    Boolean hasMustache;

    public Animal(String name, int footNumber, Boolean hasMustache) {
        this.name = name;
        this.footNumber = footNumber;
        this.hasMustache = hasMustache;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFootNumber() {
        return footNumber;
    }

    public void setFootNumber(int footNumber) {
        this.footNumber = footNumber;
    }

    public Boolean getHasMustache() {
        return hasMustache;
    }

    public void setHasMustache(Boolean hasMustache) {
        this.hasMustache = hasMustache;
    }
    @Override
    public void voice() {

    }

    @Override
    public void isHungry() {

    }

    @Override
    public void move() {

    }
}
