import main.Elevator;

public class MainClass {

    public static void main(String[] args) {
        Elevator elevator = new Elevator();
        elevator.addFloorToQueue(3);
        elevator.addFloorToQueue(1);
        elevator.addFloorToQueue(4);
        elevator.addFloorToQueue(6);
        System.out.println(elevator.getNextFloor());
        elevator.goToTheNextFloor();
        System.out.println(elevator.getNextFloor());
        elevator.goToTheNextFloor();
        System.out.println(elevator.getNextFloor());
        elevator.goToTheNextFloor();
        System.out.println(elevator.getNextFloor());
        elevator.goToTheNextFloor();
        System.out.println(elevator.getNextFloor());
        elevator.goToTheNextFloor();
    }
}
