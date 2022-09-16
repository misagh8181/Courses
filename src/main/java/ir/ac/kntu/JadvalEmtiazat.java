package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

public class JadvalEmtiazat {
    private static Scanner scanner = new Scanner(System.in);

    private static ArrayList<String> emtiazUsers = new ArrayList<>();

    private static ArrayList<Double> mizanEmtiazUsers = new ArrayList<>();

    public static void emtiazdehi(ArrayList<Class> classes) {
        if (classes.size() != 0) {
            for (int i = 0; i < classes.size(); i++) {
                System.out.println(i + ":" + classes.get(i).toString());
            }
            System.out.println("Which class do you want? Enter the number of class:");
            int jadvalclass = scanner.nextInt();
            if (classes.get(jadvalclass).getTamrin().size() != 0) {
                for (int i = 0; i < classes.get(jadvalclass).getTamrin().size(); i++) {
                    System.out.println(i + ":" + classes.get(jadvalclass).getTamrin().get(i).getName());
                }
                System.out.println("Which home work do you want? Enter the number of home work:");
                int homeWork = scanner.nextInt();
                if (classes.get(jadvalclass).getTamrin().get(homeWork).getSoal().size() != 0) {
                    for (int i = 0; i < classes.get(jadvalclass).getTamrin().get(homeWork).getSoal().size(); i++) {
                        int j = i + 1;
                        System.out.println(j + ":" + classes.get(jadvalclass).getTamrin().get(homeWork).getSoal().get(i).getName());
                    }
                    System.out.println("Which question do you want(To show score table)? Enter the number of question:");
                    int question = scanner.nextInt();
                    question = question - 1;
                    joziatEmtiazDehi(classes, jadvalclass, homeWork, question);
                }
            } else {
                System.out.println("This class hasn't any home work :( !!!");
            }
        }
    }

    public static void joziatEmtiazDehi(ArrayList<Class> classes, int jadvalclass, int homeWork, int question) {
        for (int i = 0; i < classes.get(jadvalclass).getTamrin().get(homeWork).getSoal().get(question).getPasokh().size(); i++) {
            if (classes.get(jadvalclass).getTamrin().get(homeWork).getSoal().get(question).getPasokh().get(i).getMatnePasokh().equals(classes.get(jadvalclass).getTamrin().get(homeWork).getSoal().get(question).getPasokhDorost())) {
                if (classes.get(jadvalclass).getTamrin().get(homeWork).getSoal().get(question).getPasokh().get(i).getTarikhErsal().isAfter(classes.get(jadvalclass).getTamrin().get(homeWork).getEndTime())) {
                    if (classes.get(jadvalclass).getTamrin().get(homeWork).getSoal().get(question).getPasokh().get(i).getTarikhErsal().isAfter(classes.get(jadvalclass).getTamrin().get(homeWork).getTakhirTime())) {
                        classes.get(jadvalclass).getTamrin().get(homeWork).getSoal().get(question).getPasokh().get(i).setNomre(0);
                    } else {
                        classes.get(jadvalclass).getTamrin().get(homeWork).getSoal().get(question).getPasokh().get(i).setNomre(classes.get(jadvalclass).getTamrin().get(homeWork).getSoal().get(question).getBarom() * ((100 - classes.get(jadvalclass).getTamrin().get(homeWork).getZaribTakhir()) / 100));
                    }
                } else {
                    classes.get(jadvalclass).getTamrin().get(homeWork).getSoal().get(question).getPasokh().get(i).setNomre(classes.get(jadvalclass).getTamrin().get(homeWork).getSoal().get(question).getBarom());
                }
            } else {
                classes.get(jadvalclass).getTamrin().get(homeWork).getSoal().get(question).getPasokh().get(i).setNomre(0);
            }
        }
        for (int i = 0; i < classes.get(jadvalclass).getTamrin().get(homeWork).getSoal().get(question).getPasokh().size(); i++) {
            if (classes.get(jadvalclass).getTamrin().get(homeWork).getSoal().get(question).getPasokh().get(i).getNomre() == classes.get(jadvalclass).getTamrin().get(homeWork).getSoal().get(question).getBarom()) {
                emtiazUsers.add(classes.get(jadvalclass).getTamrin().get(homeWork).getSoal().get(question).getPasokh().get(i).getUserName());
                mizanEmtiazUsers.add(classes.get(jadvalclass).getTamrin().get(homeWork).getSoal().get(question).getPasokh().get(i).getNomre());
            }
        }
        for (int i = 0; i < classes.get(jadvalclass).getTamrin().get(homeWork).getSoal().get(question).getPasokh().size(); i++) {
            if (classes.get(jadvalclass).getTamrin().get(homeWork).getSoal().get(question).getPasokh().get(i).getNomre() == classes.get(jadvalclass).getTamrin().get(homeWork).getSoal().get(question).getBarom() * ((100 - classes.get(jadvalclass).getTamrin().get(homeWork).getZaribTakhir()) / 100)) {
                emtiazUsers.add(classes.get(jadvalclass).getTamrin().get(homeWork).getSoal().get(question).getPasokh().get(i).getUserName());
                mizanEmtiazUsers.add(classes.get(jadvalclass).getTamrin().get(homeWork).getSoal().get(question).getPasokh().get(i).getNomre());
            }
        }
        for (int i = 0; i < classes.get(jadvalclass).getTamrin().get(homeWork).getSoal().get(question).getPasokh().size(); i++) {
            if (classes.get(jadvalclass).getTamrin().get(homeWork).getSoal().get(question).getPasokh().get(i).getNomre() == 0) {
                emtiazUsers.add(classes.get(jadvalclass).getTamrin().get(homeWork).getSoal().get(question).getPasokh().get(i).getUserName());
                mizanEmtiazUsers.add(classes.get(jadvalclass).getTamrin().get(homeWork).getSoal().get(question).getPasokh().get(i).getNomre());
            }
        }
        System.out.println("score table:");
        for (int i = 0; i < emtiazUsers.size() - 1; i++) {
            int j = i + 1;
            System.out.println(j + " : " + emtiazUsers.get(i) + " , score: " + mizanEmtiazUsers.get(i));
        }
    }
}