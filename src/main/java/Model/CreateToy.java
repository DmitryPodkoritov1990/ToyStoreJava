package Model;

import View.ListToys;

import java.util.List;

public class CreateToy {
ListToys listToys = new ListToys();
public void createnewtoy(String str) throws Exception{
    String[] arr = str.split(" ");
    String name = arr[0];
    int weight = Integer.parseInt(arr[1]);
    Toy toy = new Toy(name, weight);
    listToys.getToys().add(toy);
}

    public ListToys getListToys() {
        return listToys;
    }
}
