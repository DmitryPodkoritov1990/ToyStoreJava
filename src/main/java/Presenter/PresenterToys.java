package Presenter;

import Model.CreateToy;
import Model.Priz;
import Model.Toy;

import java.util.Scanner;

public class PresenterToys {
    CreateToy createToy = new CreateToy();
    String menu = "\n1 >>> ADD NEW TOY " +
            "\n2 >>> DELETE TOY " +
             "\n3 >>> CHANGE FREQUANCY OF TOY " +
            "\n4 >>> QUIZE / PRIZE " +
            "\n5 >>> FINISH ";
            String userData = "\nEnter data of toy please(name, weight)\n"+
                    "note\n" +
                    "Name toy" +
                    "Weight toy";
            String findId = "\n Enter ID of toy";

            public void startofgame(){
                Scanner scanner = new Scanner(System.in);
                Boolean flag = true;
                while (flag){
                    System.out.println(this.menu);
                    String command = scanner.nextLine();
                    switch (command) {
                        case "1":
                            System.out.println(this.userData);
                            String temp = scanner.nextLine();
                            try {
                                createToy.createnewtoy(temp);
                                System.out.println("Succesfull");
                            } catch (Exception e) {
                                System.out.println("Incorrect data ");
                            }
                            break;
                        case "2":
                            try {
                                createToy.getListToys().printAlltoys();
                            } catch (Exception e) {
                                System.out.println("Choice 1, to add toy");
                                break;
                            }
                            System.out.println(findId);
                            try {
                                Integer number = Integer.parseInt(scanner.nextLine());
                                Boolean indicator = false;
                                for (int i = 0; i < createToy.getListToys().getToys().size(); i++) {
                                    Toy toy = createToy.getListToys().getToys().get(i);
                                    if (toy.getId() == number) {
                                        createToy.getListToys().getToys().remove(toy);
                                        indicator = true;
                                        System.out.println("Delete toy");
                                    }
                                }
                                if (indicator == false) {
                                    System.out.println("Toy not found for id");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("ID is incorrect");
                            }
                            break;
                        case "3":
                            try{
                                createToy.getListToys().printAlltoys();
                            }catch (Exception e){
                                System.out.println("Choice 1, to add toy");
                                break;
                            }
                            System.out.println(findId);
                        try {
                            Integer number = Integer.parseInt(scanner.nextLine());
                            Boolean indicator = false;
                            for (int i =0; i<createToy.getListToys().getToys().size(); i++){
                                Toy toy = createToy.getListToys().getToys().get(i);
                                if(toy.getId()==number){
                                    System.out.println("Enter new frequancy of toy");
                                    try {
                                        Integer newValue = Integer.parseInt(scanner.nextLine());
                                        toy.setWeight(newValue);
                                        System.out.println("Change is success");
                                        indicator = true;
                                        break;
                                    }catch (NumberFormatException e){
                                        System.out.println("Incorrect value");
                                    }
                                }
                            }
                        if(indicator == false){
                            System.out.println("Toy with id not found");
                        }
                        }catch (NumberFormatException e){
                            System.out.println("Incorrect Id");
                        }
                        break;
                        case "4":
                            Priz priz = new Priz();
                            if(priz.add(createToy.getListToys())== true){
                                priz.awardToy(createToy.getListToys());
                            }
                            break;
                        case "5":
                            flag = false;
                            break;
                    }
                }
            }
}
