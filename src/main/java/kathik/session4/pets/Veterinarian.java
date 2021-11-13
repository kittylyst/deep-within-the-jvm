package kathik.session4.pets;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Veterinarian {
    private final String name;
    private final List<Pet> pets = new ArrayList<>();

    public static boolean isOpenToday() {
        var today = LocalDate.now();
        if (today.getDayOfWeek().equals(DayOfWeek.SATURDAY) || today.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
            return false;
        }
        return true;
    }

    public Veterinarian(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }

    public void careFor(Pet pet) {
        pets.add(pet);
    }

    @Override
    public String toString() {
        return "Veterinarian{" +
                "name='" + name + '\'' +
                ", pets=" + pets +
                '}';
    }
}
