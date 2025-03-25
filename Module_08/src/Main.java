public class Main {
    public static void main(String[] args) {

        Horse horse = new Horse("Horse 3", 4, false);
        Kangaroo kangaroo = new Kangaroo("Kangaroo 3", 4, true);
        Dragonfly dragonfly = new Dragonfly("Dragonfly 3", 6, true);

        Animal[] herd = new Animal[7];
        herd[0] = new Horse("Horse", 4, false);
        herd[1] = new Horse("Horse",4,true);
        herd[2] = new Kangaroo("Kangaroo",4,false);
        herd[3] = new Kangaroo("Kangaroo",4,false);
        herd[4] = new Dragonfly("Dragonfly",6,false);
        herd[5] = new Dragonfly("Dragonfly", 6, true);
        herd[6] = new Animal("Unknown type", 10, true){};

        for (Animal animal :herd){
            animal.voice();
            animal.isHungry();
            animal.move();
        }



    }

}