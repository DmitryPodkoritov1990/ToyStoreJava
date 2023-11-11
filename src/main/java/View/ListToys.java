package View;

import Model.Toy;

import java.util.ArrayList;
import java.util.List;

public class ListToys {
    List <Toy> toys = new ArrayList<>();

    public void printAlltoys() throws Exception{
        if(toys.size() > 0){
            for (Toy toy: this.toys) {
                System.out.println("\n" + toys);
            }
        }else {
            System.out.println("Toys not found");
            throw new RuntimeException();
        }
    }

    public List<Toy> getToys() {
        return toys;
    }
}
