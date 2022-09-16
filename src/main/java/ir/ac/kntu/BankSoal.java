package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

public class BankSoal {
    private static ArrayList<Soal> soal = new ArrayList<>();

    private static ArrayList<Soal> soalMoratab = new ArrayList<>();

    private static int tedadSoal = 0;

    public static void useBankSoal() {
        Scanner scanner = new Scanner(System.in);
        Scanner receiver = new Scanner(System.in);
        System.out.println("Enter [" + "1:To add a question for question bank|" + "2:To see the list of question bank]:");
        String vaziat = scanner.next();
        if (Integer.parseInt(vaziat) == 1) {
            jazbSoal(scanner, receiver);
        } else if (Integer.parseInt(vaziat) == 2) {
            chapSoalat();
        } else {
            System.out.println("You didn't put a number in range !!!");
        }
    }

    private static void chapSoalat() {
        for (int i = 0; i < soal.size(); i++) {
            if (soal.get(i).getMizanSakhti() == MizanSakhti.Easy) {
                soalMoratab.add(soal.get(i));
            }
        }
        for (int i = 0; i < soal.size(); i++) {
            if (soal.get(i).getMizanSakhti() == MizanSakhti.Normal) {
                soalMoratab.add(soal.get(i));
            }
        }
        for (int i = 0; i < soal.size(); i++) {
            if (soal.get(i).getMizanSakhti() == MizanSakhti.Hard) {
                soalMoratab.add(soal.get(i));
            }
        }
        for (int i = 0; i < soal.size(); i++) {
            int j = i + 1;
            System.out.println(j + " : " + soalMoratab.get(i).toString());
        }
    }

    private static void jazbSoal(Scanner scanner, Scanner receiver) {
        System.out.println("Enter the number of questions you want to add:");
        String numberOfQuestions = scanner.next();
        for (int i = 0; i < Integer.parseInt(numberOfQuestions); i++) {
            int j = i + 1;
            soal.add(new Soal());
            System.out.println("Enter your question " + j + " name:");
            soal.get(tedadSoal).setName(scanner.next());
            System.out.println("Enter your question " + j + " definition:");
            soal.get(tedadSoal).setTozih(receiver.nextLine());
            System.out.println("Enter your question  " + j + " mizan sakhti(Easy/Normal/Hard/VeryHard):");
            String temp = scanner.next();
            if (temp.equals("Easy")) {
                soal.get(tedadSoal).setMizanSakhti(MizanSakhti.Easy);
            } else if (temp.equals("Normal")) {
                soal.get(tedadSoal).setMizanSakhti(MizanSakhti.Normal);
            } else if (temp.equals("Hard")) {
                soal.get(tedadSoal).setMizanSakhti(MizanSakhti.Hard);
            } else if (temp.equals("VeryHard")) {
                soal.get(tedadSoal).setMizanSakhti(MizanSakhti.VeryHard);
            }
            tedadSoal++;
        }
    }


    public ArrayList<Soal> getSoal() {
        return soal;
    }

    public void setSoal(ArrayList<Soal> soal) {
        BankSoal.soal = soal;
    }

    public static int getTedadSoal() {
        return tedadSoal;
    }

    public static void setTedadSoal(int tedadSoal) {
        BankSoal.tedadSoal = tedadSoal;
    }
}
