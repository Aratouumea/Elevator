package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Elevator {

    private List<Integer> floorsQueue = new ArrayList<>();
    private FloorDirection direction = FloorDirection.UP;
    private Integer actualFloor = 3;

    public boolean addFloorToQueue(Integer floorNumber) {
        if (!floorsQueue.contains(floorNumber)) {
            floorsQueue.add(floorNumber);
        }
        return true;
    }

    public void goToTheNextFloor() {
        Integer nextFloor = getNextFloor();
        if (!actualFloor.equals(nextFloor)) {
            floorsQueue.remove(nextFloor);
        }
        actualFloor = nextFloor;

    }

    public Integer getNextFloor() {
        Optional<Integer> nextFloor = getNextFloorByDirection();
        if (!nextFloor.isPresent()) {
            changeDirection();
            nextFloor = getNextFloorByDirection();
        }
        return nextFloor.orElse(actualFloor);
    }

    private Optional<Integer> getNextFloorByDirection() {
        if (direction.equals(FloorDirection.UP)) {
            return floorsQueue.stream().sorted().filter(floor -> floor > actualFloor).findFirst();
        }
        return floorsQueue.stream().sorted((f1, f2) -> Integer.compare(f2, f1)).filter(floor -> floor < actualFloor).findFirst();
    }

    private void changeDirection() {
        if (FloorDirection.DOWN.equals(direction)) {
            direction = FloorDirection.UP;
        } else {
            direction = FloorDirection.DOWN;
        }
    }
}
