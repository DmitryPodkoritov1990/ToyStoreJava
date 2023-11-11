package Model;

import View.ListToys;

import java.io.FileWriter;
import java.util.Comparator;
import java.util.Date;
import java.util.PriorityQueue;

public class Priz {
    PriorityQueue queue = new PriorityQueue<>(Comparator.comparing(Toy::getWeight));
    public boolean add(ListToys listToys){
        if(listToys.getToys().size()>0) {
            for (Toy toy : listToys.getToys()) {
                this.queue.offer(toy);
            }
            return true;
        }else {
            System.out.println("Toys not found, impossible take priz ");
            return false;
        }
    }
    public void awardToy(ListToys listToys){
        try{
            FileWriter fileWriter = new FileWriter("toypriz.txt", true);
            Date date = new Date();
            Toy winoftoy = (Toy)queue.poll();
            fileWriter.write(date.toString() + "\n");
            fileWriter.write(winoftoy.toString() + "\n");
            System.out.println("Prize" + winoftoy.getName()+ "record to file");
            listToys.getToys().remove(winoftoy);
            fileWriter.close();
        }catch (Exception e){

        }
    }

    public PriorityQueue getQueue() {
        return queue;
    }
}
