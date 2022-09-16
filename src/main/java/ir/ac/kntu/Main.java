package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int userIndex = -1;

    static int tedadKelas = 0;

    static int tedadKarbar = 0;

    static ArrayList<Class> classes = new ArrayList<>();

    static ArrayList<User> users = new ArrayList<>();

    static Scanner scanner = new Scanner(System.in);

    public static int findUser(User user, ArrayList<User> users) {
        for (int i = 0; i < users.size(); i++) {
            if (user.getUserName().equals(users.get(i).getUserName())) {
                if (user.getPassWord().equals(users.get(i).getPassWord())) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void editClass(int userIndex) {
        int search;
        for (int i = 0; i < users.get(userIndex).getOwnClasses().size(); i++) {
            System.out.println(i + ":" + users.get(userIndex).getOwnClasses().toString());
        }
        System.out.println("Which class do you want to edit? Enter the number of class:");
        search = scanner.nextInt();
        System.out.println("Enter your new Class name:");
        users.get(userIndex).getOwnClasses().get(search).setName(scanner.next());
        System.out.println("Enter new Ostad name:");
        users.get(userIndex).getOwnClasses().get(search).setOstad(scanner.next());
        System.out.println("Enter new Moasese Amoozeshi:");
        users.get(userIndex).getOwnClasses().get(search).setMoaseseAmoozeshi(scanner.next());
        System.out.println("Enter new Sal tahsili:");
        users.get(userIndex).getOwnClasses().get(search).setSalTahsili(scanner.nextInt());
        System.out.println("Enter your class is open or not(true/false)/(new):");
        users.get(userIndex).getOwnClasses().get(search).setBaz(scanner.nextBoolean());
        System.out.println("Enter your class is public or not(true/false)/(new):");
        users.get(userIndex).getOwnClasses().get(search).setKhosoosi(scanner.nextBoolean());
        if (!users.get(userIndex).getOwnClasses().get(search).getKhosoosi()) {
            System.out.println("Enter a new password for class :");
            users.get(userIndex).getOwnClasses().get(search).setPassword(scanner.next());
        }
    }

    public static void haltKhas2(int userIndex, int search) {
        System.out.println("Enter [" + "1:To make a new class|" + "2:To delete your classes|" + "3:To edit your classes]:");
        search = scanner.nextInt();
        if (search == 1) {
            classes.add(new Class());
            System.out.println("Enter your Class name:");
            classes.get(tedadKelas).setName(scanner.next());
            System.out.println("Enter Ostad name:");
            classes.get(tedadKelas).setOstad(scanner.next());
            System.out.println("Enter Moasese Amoozeshi:");
            classes.get(tedadKelas).setMoaseseAmoozeshi(scanner.next());
            System.out.println("Enter Sal tahsili:");
            classes.get(tedadKelas).setSalTahsili(scanner.nextInt());
            System.out.println("Enter your class is open or not(true/false):");
            classes.get(tedadKelas).setBaz(scanner.nextBoolean());
            System.out.println("Enter your class is public or not(true/false):");
            classes.get(tedadKelas).setKhosoosi(scanner.nextBoolean());
            if (!classes.get(tedadKelas).getKhosoosi()) {
                System.out.println("Enter a password for class :");
                classes.get(tedadKelas).setPassword(scanner.next());
            }
            classes.get(tedadKelas).setMalekUser(users.get(userIndex));
            System.out.println("New class made successfully.");
            users.get(userIndex).getOwnClasses().add(classes.get(tedadKelas));
            users.get(userIndex).setTedadKelas(users.get(userIndex).getTedadKelas() + 1);
            tedadKelas++;
        } else if (search == 2) {
            for (int i = 0; i < users.get(userIndex).getOwnClasses().size(); i++) {
                System.out.println(i + ":" + users.get(userIndex).getOwnClasses().get(i).toString());
            }
            System.out.println("Which class do you want to delete? Enter the number of class:");
            search = scanner.nextInt();
            users.get(userIndex).getOwnClasses().remove(search);
        } else if (search == 3) {
            editClass(userIndex);
        } else {
            System.out.println("You didn't put a number in range :( !!");
        }
    }

    public static void haltKhas3() {
        int search;
        ArrayList<Class> searchClasses = new ArrayList<>();
        System.out.println("Enter [" + "1:To search by Name|" + "2:To search by Ostad name|" + "3:To search for Sal tsahsili]:");
        search = scanner.nextInt();
        if (search == 1) {
            System.out.println("Name:");
            String name = scanner.next();
            for (int i = 0; i < classes.size(); i++) {
                if (name.equals(classes.get(i).getName())) {
                    searchClasses.add(new Class(classes.get(i)));
                }
            }
        } else if (search == 2) {
            System.out.println("Ostad name:");
            String ostadName = scanner.next();
            for (int i = 0; i < classes.size(); i++) {
                if (ostadName.equals(classes.get(i).getOstad())) {
                    searchClasses.add(new Class(classes.get(i)));
                }
            }
        } else if (search == 3) {
            System.out.println("Sal tahsili:");
            int salTahsili = scanner.nextInt();
            for (int i = 0; i < classes.size(); i++) {
                if (salTahsili == classes.get(i).getSalTahsili()) {
                    searchClasses.add(new Class(classes.get(i)));
                }
            }
        } else {
            System.out.println("You didn't put anything in range :( !!!");
        }
        boolean searchAnjamShode = false;
        for (int i = 0; i < searchClasses.size(); i++) {
            System.out.println(i + ":" + searchClasses.get(i).toString());
            searchAnjamShode = true;
        }
        if (searchAnjamShode) {
            System.out.println("Which class do you want? Enter the number of class:  :) ");
            search = scanner.nextInt();
            searchClasses.get(search).sabtNam(users.get(userIndex));
        }
    }

    public static void haltKhas4() {
        int search;
        ArrayList<User> searchUsers = new ArrayList<>();
        System.out.println("Enter [" + "1:To search by National code|" + "2:To search by Email]:");
        search = scanner.nextInt();
        if (search == 1) {
            System.out.println("National code:");
            String nationalCode = scanner.next();
            for (int i = 0; i < users.size(); i++) {
                if (nationalCode.equals(users.get(i).getNationalCode())) {
                    searchUsers.add(new User(users.get(i)));
                }
            }
        } else if (search == 2) {
            System.out.println("Email:");
            String email = scanner.next();
            for (int i = 0; i < users.size(); i++) {
                if (email.equals(users.get(i).getEmail())) {
                    searchUsers.add(new User(users.get(i)));
                }
            }
        } else {
            System.out.println("You didn't put anything in range :( !!!");
        }
        boolean searchAnjamShode = false;
        for (int i = 0; i < searchUsers.size(); i++) {
            System.out.println(i + ":" + searchUsers.get(i).toString());
            searchAnjamShode = true;
        }
        if (searchAnjamShode) {
            System.out.println("If you want to go main menu press (1 & enter):");
            String edame = scanner.next();
        }
    }

    public static void tarifTamrin(int userIndex, Scanner receiver) {
        String search;
        System.out.println("Which class do you want to add a home work for that? Enter the number of class:");
        search = scanner.next();
        users.get(userIndex).getOwnClasses().get(Integer.parseInt(search)).getTamrin().add(new Tamrin());
        System.out.println("Enter your home work name:");
        users.get(userIndex).getOwnClasses().get(Integer.parseInt(search)).getTamrin().get(users.get(userIndex).getOwnClasses().get(Integer.parseInt(search)).getTedadTamrin()).setName(scanner.next());
        System.out.println("Enter your home work definition:");
        users.get(userIndex).getOwnClasses().get(Integer.parseInt(search)).getTamrin().get(users.get(userIndex).getOwnClasses().get(Integer.parseInt(search)).getTedadTamrin()).setTozih(receiver.nextLine());
        System.out.println("Enter the number of questions for homework:");
        String numberOfQuestions = scanner.next();
        for (int i = 0; i < Integer.parseInt(numberOfQuestions); i++) {
            int j = i + 1;
            users.get(userIndex).getOwnClasses().get(Integer.parseInt(search)).getTamrin().get(users.get(userIndex).getOwnClasses().get(Integer.parseInt(search)).getTedadTamrin()).getSoal().add(new Soal());
            System.out.println("Enter your question " + j + " name:");
            users.get(userIndex).getOwnClasses().get(Integer.parseInt(search)).getTamrin().get(users.get(userIndex).getOwnClasses().get(Integer.parseInt(search)).getTedadTamrin()).getSoal().get(i).setName(scanner.next());
            System.out.println("Enter your question " + j + " definition:");
            users.get(userIndex).getOwnClasses().get(Integer.parseInt(search)).getTamrin().get(users.get(userIndex).getOwnClasses().get(Integer.parseInt(search)).getTedadTamrin()).getSoal().get(i).setTozih(receiver.nextLine());
            System.out.println("Enter your question  " + j + " mizan sakhti(Easy/Normal/Hard/VeryHard):");
            String temp = scanner.next();
            if (temp.equals("Easy")) {
                users.get(userIndex).getOwnClasses().get(Integer.parseInt(search)).getTamrin().get(users.get(userIndex).getOwnClasses().get(Integer.parseInt(search)).getTedadTamrin()).getSoal().get(i).setMizanSakhti(MizanSakhti.Easy);
            } else if (temp.equals("Normal")) {
                users.get(userIndex).getOwnClasses().get(Integer.parseInt(search)).getTamrin().get(users.get(userIndex).getOwnClasses().get(Integer.parseInt(search)).getTedadTamrin()).getSoal().get(i).setMizanSakhti(MizanSakhti.Normal);
            } else if (temp.equals("Hard")) {
                users.get(userIndex).getOwnClasses().get(Integer.parseInt(search)).getTamrin().get(users.get(userIndex).getOwnClasses().get(Integer.parseInt(search)).getTedadTamrin()).getSoal().get(i).setMizanSakhti(MizanSakhti.Hard);
            } else if (temp.equals("VeryHard")) {
                users.get(userIndex).getOwnClasses().get(Integer.parseInt(search)).getTamrin().get(users.get(userIndex).getOwnClasses().get(Integer.parseInt(search)).getTedadTamrin()).getSoal().get(i).setMizanSakhti(MizanSakhti.VeryHard);
            }
            System.out.println("Enter your question " + j + " barom:");
            users.get(userIndex).getOwnClasses().get(Integer.parseInt(search)).getTamrin().get(users.get(userIndex).getOwnClasses().get(Integer.parseInt(search)).getTedadTamrin()).getSoal().get(i).setBarom(Integer.parseInt(scanner.next()));
        }
        System.out.println("Enter your home work start time:");
        users.get(userIndex).getOwnClasses().get(Integer.parseInt(search)).getTamrin().get(users.get(userIndex).getOwnClasses().get(Integer.parseInt(search)).getTedadTamrin()).setTime("Start");
        System.out.println("Enter your home work end time:");
        users.get(userIndex).getOwnClasses().get(Integer.parseInt(search)).getTamrin().get(users.get(userIndex).getOwnClasses().get(Integer.parseInt(search)).getTedadTamrin()).setTime("End");
        System.out.println("Enter your home work delay coefficient:");
        users.get(userIndex).getOwnClasses().get(Integer.parseInt(search)).getTamrin().get(users.get(userIndex).getOwnClasses().get(Integer.parseInt(search)).getTedadTamrin()).setZaribTakhir(Integer.parseInt(scanner.next()));
        System.out.println("Enter your home work delay time:");
        users.get(userIndex).getOwnClasses().get(Integer.parseInt(search)).getTamrin().get(users.get(userIndex).getOwnClasses().get(Integer.parseInt(search)).getTedadTamrin()).setTime("Delay");
        users.get(userIndex).getOwnClasses().get(Integer.parseInt(search)).setTedadTamrin(users.get(userIndex).getOwnClasses().get(Integer.parseInt(search)).getTedadTamrin() + 1);
    }

    public static void haltKhas5(int userIndex) {
        Scanner receiver = new Scanner(System.in);
        for (int i = 0; i < users.get(userIndex).getOwnClasses().size(); i++) {
            System.out.println(i + ":" + users.get(userIndex).getOwnClasses().get(i).toString());
        }
        if (users.get(userIndex).getOwnClasses().size() != 0) {
            tarifTamrin(userIndex, receiver);
        }
    }

    public static void editTamrin(String search, String search1) {
        Scanner receiver = new Scanner(System.in);
        Tamrin tamrin = new Tamrin();
        System.out.println("Enter your new home work name:");
        tamrin.setName(scanner.next());
        System.out.println("Enter your new home work definition:");
        tamrin.setTozih(receiver.nextLine());
        System.out.println("Enter the number of questions for new homework:");
        String numberOfQuestions;
        numberOfQuestions = scanner.next();
        for (int i = 0; i < Integer.parseInt(numberOfQuestions); i++) {
            int j = i + 1;
            tamrin.getSoal().add(new Soal());
            System.out.println("Enter your new question " + j + " name:");
            tamrin.getSoal().get(i).setName(scanner.next());
            System.out.println("Enter your new question " + j + " definition:");
            tamrin.getSoal().get(i).setTozih(receiver.nextLine());
            System.out.println("Enter your new question " + j + " mizan sakhti(Easy/Normal/Hard/VeryHard):");
            String temp = scanner.next();
            if (temp.equals("Easy")) {
                tamrin.getSoal().get(i).setMizanSakhti(MizanSakhti.Easy);
            } else if (temp.equals("Normal")) {
                tamrin.getSoal().get(i).setMizanSakhti(MizanSakhti.Normal);
            } else if (temp.equals("Hard")) {
                tamrin.getSoal().get(i).setMizanSakhti(MizanSakhti.Hard);
            } else if (temp.equals("VeryHard")) {
                tamrin.getSoal().get(i).setMizanSakhti(MizanSakhti.VeryHard);
            }
            System.out.println("Enter your new question " + j + " barom:");
            tamrin.getSoal().get(i).setBarom(Integer.parseInt(scanner.next()));
        }
        System.out.println("Enter your new home work start time:");
        tamrin.setTime("Start");
        System.out.println("Enter your new home work end time:");
        tamrin.setTime("End");
        System.out.println("Enter your new home work delay coefficient:");
        tamrin.setZaribTakhir(Integer.parseInt(scanner.next()));
        System.out.println("Enter your new home work delay time:");
        tamrin.setTime("Delay");
        users.get(userIndex).getOwnClasses().get(Integer.parseInt(search)).getTamrin().set(Integer.parseInt(search1), tamrin);
    }

    public static void haltKhas6() {
        String search;
        for (int i = 0; i < users.get(userIndex).getOwnClasses().size(); i++) {
            System.out.println(i + ":" + users.get(userIndex).getOwnClasses().get(i).toString());
        }
        if (users.get(userIndex).getOwnClasses().size() != 0) {
            System.out.println("Which class do you want to edit a home work for that? Enter the number of class:");
            search = scanner.next();
            for (int i = 0; i < users.get(userIndex).getOwnClasses().get(Integer.parseInt(search)).getTamrin().size(); i++) {
                System.out.println(i + ":" + users.get(userIndex).getOwnClasses().get(Integer.parseInt(search)).getTamrin().get(i).toString());
            }
            String search1;
            System.out.println("Which home work do you want to delete or edit? Enter the number of home work:");
            search1 = scanner.next();
            String barresyDeleteYaEdit;
            System.out.println("Do you want to edit or delete this home work? Enter (e:for edit/d:for delete):");
            barresyDeleteYaEdit = scanner.next();
            if (barresyDeleteYaEdit.equals("e")) {
                users.get(userIndex).getOwnClasses().get(Integer.parseInt(search)).getTamrin().remove(Integer.parseInt(search1));
                editTamrin(search, search1);
            } else if (barresyDeleteYaEdit.equals("d")) {
                users.get(userIndex).getOwnClasses().get(Integer.parseInt(search)).getTamrin().remove(Integer.parseInt(search1));
            } else {
                System.out.println("You didn't put e or d :( !!!");
            }
        }
    }

    public static void haltKhas7() {
        ArrayList<Class> searchClasses = new ArrayList<>();
        boolean searchAnjamShode = false;
        for (int i = 0; i < users.get(userIndex).getOwnClasses().size(); i++) {
            if (!users.get(userIndex).getOwnClasses().get(i).getBaz()) {
                searchClasses.add(users.get(userIndex).getOwnClasses().get(i));
            }
        }
        for (int i = 0; i < searchClasses.size(); i++) {
            System.out.println(i + ":" + searchClasses.get(i).toString());
            searchAnjamShode = true;
        }
        if (searchAnjamShode) {
            System.out.println("Which class do you want to add a student for that as an owner. Enter the number of class: :)");
            String shomareClassMoredNazar = scanner.next();
            System.out.println("Enter the name of student:");
            String nameStudent = scanner.next();
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getName().equals(nameStudent)) {
                    System.out.println("Enter the email of student:");
                    String emailStudent = scanner.next();
                    if (users.get(i).getEmail().equals(emailStudent)) {
                        searchClasses.get(Integer.parseInt(shomareClassMoredNazar)).sabtNamKhas(users.get(i));
                    }
                }
            }
        }
    }

    public static void haltKhas8() {
        Scanner receiver = new Scanner(System.in);
        ArrayList<Class> searchClasses = new ArrayList<>();
        for (int i = 0; i < classes.size(); i++) {
            for (int j = 0; j < classes.get(i).getStudentUser().size(); j++) {
                if (classes.get(i).getStudentUser().get(j).equals(users.get(userIndex))) {
                    searchClasses.add(classes.get(i));
                }
            }
        }
        if (searchClasses.size() == 0) {
            System.out.println("You haven't any registered class.");
        }
        if (searchClasses.size() != 0) {
            for (int i = 0; i < searchClasses.size(); i++) {
                System.out.println(i + ":" + searchClasses.get(i).toString());
            }
            System.out.println("Which class do you want to do home work from? Enter the number of class:");
            int homeWorkclass = scanner.nextInt();
            if (searchClasses.get(homeWorkclass).getTamrin().size() != 0) {
                for (int i = 0; i < searchClasses.get(homeWorkclass).getTamrin().size(); i++) {
                    System.out.println(i + ":" + searchClasses.get(homeWorkclass).getTamrin().get(i).getName());
                }
                System.out.println("Which home work do you want to do? Enter the number of home work:");
                int homeWork = scanner.nextInt();
                System.out.println("name : " + searchClasses.get(homeWorkclass).getTamrin().get(homeWork).getName());
                System.out.println("definition : " + searchClasses.get(homeWorkclass).getTamrin().get(homeWork).getTozih());
                for (int i = 0; i < searchClasses.get(homeWorkclass).getTamrin().get(homeWork).getSoal().size(); i++) {
                    int j = i + 1;
                    System.out.println("question " + j + " name: " + searchClasses.get(homeWorkclass).getTamrin().get(homeWork).getName());
                    System.out.println("question " + j + " definition: " + searchClasses.get(homeWorkclass).getTamrin().get(homeWork).getTozih());
                    System.out.println("Enter your answer for question " + j + " :");
                    searchClasses.get(homeWorkclass).getTamrin().get(homeWork).getSoal().get(i).getPasokh().add(new Pasokh());
                    searchClasses.get(homeWorkclass).getTamrin().get(homeWork).getSoal().get(i).getPasokh().get(searchClasses.get(homeWorkclass).getTamrin().get(homeWork).getSoal().get(i).getTedadPasokh()).setMatnePasokh(receiver.nextLine());
                    searchClasses.get(homeWorkclass).getTamrin().get(homeWork).getSoal().get(i).getPasokh().get(searchClasses.get(homeWorkclass).getTamrin().get(homeWork).getSoal().get(i).getTedadPasokh()).setUserName(users.get(userIndex).getUserName());
                    searchClasses.get(homeWorkclass).getTamrin().get(homeWork).getSoal().get(i).getPasokh().get(searchClasses.get(homeWorkclass).getTamrin().get(homeWork).getSoal().get(i).getTedadPasokh()).setSoalName(searchClasses.get(homeWorkclass).getTamrin().get(homeWork).getSoal().get(i).getName());
                    searchClasses.get(homeWorkclass).getTamrin().get(homeWork).getSoal().get(i).getPasokh().get(searchClasses.get(homeWorkclass).getTamrin().get(homeWork).getSoal().get(i).getTedadPasokh()).setZaribTakhir(searchClasses.get(homeWorkclass).getTamrin().get(homeWork).getZaribTakhir());
                    searchClasses.get(homeWorkclass).getTamrin().get(homeWork).getSoal().get(i).getPasokh().get(searchClasses.get(homeWorkclass).getTamrin().get(homeWork).getSoal().get(i).getTedadPasokh()).setTime();
                    searchClasses.get(homeWorkclass).getTamrin().get(homeWork).getSoal().get(i).setTedadPasokh(searchClasses.get(homeWorkclass).getTamrin().get(homeWork).getSoal().get(i).getTedadPasokh() + 1);
                }
            } else {
                System.out.println("This class hasn't any home work to do :( !!!");
            }
        }
    }

    public static void haltKhas9() {
        Scanner receiver = new Scanner(System.in);
        if (users.get(userIndex).getOwnClasses().size() == 0) {
            System.out.println("You haven't any class as an owner.");
        }
        if (users.get(userIndex).getOwnClasses().size() != 0) {
            for (int i = 0; i < users.get(userIndex).getOwnClasses().size(); i++) {
                System.out.println(i + ":" + users.get(userIndex).getOwnClasses().get(i).toString());
            }
            System.out.println("Which class do you want? Enter the number of class:");
            int homeWorkclass = scanner.nextInt();
            if (users.get(userIndex).getOwnClasses().get(homeWorkclass).getTamrin().size() != 0) {
                for (int i = 0; i < users.get(userIndex).getOwnClasses().get(homeWorkclass).getTamrin().size(); i++) {
                    System.out.println(i + ":" + users.get(userIndex).getOwnClasses().get(homeWorkclass).getTamrin().get(i).getName());
                }
                System.out.println("Which home work do you want to add a correct answer for that? Enter the number of home work:");
                int homeWork = scanner.nextInt();
                System.out.println("name : " + users.get(userIndex).getOwnClasses().get(homeWorkclass).getTamrin().get(homeWork).getName());
                System.out.println("definition : " + users.get(userIndex).getOwnClasses().get(homeWorkclass).getTamrin().get(homeWork).getTozih());
                for (int i = 0; i < users.get(userIndex).getOwnClasses().get(homeWorkclass).getTamrin().get(homeWork).getSoal().size(); i++) {
                    int j = i + 1;
                    System.out.println("question " + j + " name: " + users.get(userIndex).getOwnClasses().get(homeWorkclass).getTamrin().get(homeWork).getSoal().get(i).getName());
                    System.out.println("question " + j + " definition: " + users.get(userIndex).getOwnClasses().get(homeWorkclass).getTamrin().get(homeWork).getSoal().get(i).getTozih());
                    System.out.println("Enter the correct answer for question " + j + " :");
                    users.get(userIndex).getOwnClasses().get(homeWorkclass).getTamrin().get(homeWork).getSoal().get(i).setPasokhDorost(receiver.nextLine());
                }
            } else {
                System.out.println("This class hasn't any home work :( !!!");
            }
        }
    }

    public static void haltKhas10() {
        JadvalEmtiazat.emtiazdehi(classes);
    }

    public static void joziatBarresyVaziat(int vazieat) {
        if (vazieat == 1) {
            System.exit(0);
        } else if (vazieat == 2) {
            int search = 0;
            haltKhas2(userIndex, search);
        } else if (vazieat == 3) {
            haltKhas3();
        } else if (vazieat == 4) {
            haltKhas4();
        } else if (vazieat == 5) {
            haltKhas5(userIndex);
        } else if (vazieat == 6) {
            haltKhas6();
        } else if (vazieat == 7) {
            haltKhas7();
        } else if (vazieat == 8) {
            haltKhas8();
        } else if (vazieat == 9) {
            haltKhas9();
        } else if (vazieat == 10) {
            haltKhas10();
        } else if (vazieat == 11) {
            BankSoal.useBankSoal();
        } else if (vazieat == 12) {
            System.out.println("You log out successfully");
            userIndex = -1;
        } else {
            System.out.println("Please enter a number in range!!");
        }
    }

    public static void barresyVaziat(int vazieat) {
        for (; true; ) {//vorood
            if (userIndex == -1) {
                User tempUser = new User();
                System.out.println("Enter your UserName:");
                tempUser.setUserName(scanner.next());
                System.out.println("Enter your PassWord:");
                tempUser.setPassWord(scanner.next());
                userIndex = findUser(tempUser, users);
                if (userIndex == -1) {
                    System.out.println("This user doesn't exist!!\nEnter[1:To continue|2:To end running]:");
                    String i = scanner.next();
                    if (Integer.parseInt(i) == 2) {
                        System.exit(0);
                    }
                    if (Integer.parseInt(i) == 1) {
                        continue;
                    }
                }
            }//payan vorood & barresy vaziat dar halat vared shode
            System.out.println("Enter\n" + "1:To end running\n" + "2:To make a new class & edit it\n" + "3:To search for a class & register for that\n" + "4:To search for a user\n" + "5:To add a homework for a class\n" + "6:To edit or delete a home work\n" + "7:To add student for close classes as an owner\n" + "8:To answer the home works\n" + "9:To add a correct answer for home works as an owner\n" + "10:To show score table for any question\n" + "11:To use question bank\n" + "12:To login with another account");
            vazieat = scanner.nextInt();
            joziatBarresyVaziat(vazieat);
            //payan barresy vaziat dar halat vared shode
        }
    }

    public static void main(String[] args) {
        //ToDo:Quera logic loop
        int vazieat;
        for (; true; ) {
            System.out.println("******Enter [" + "1:To login with your user|" + "2:To make a new user]******");
            vazieat = scanner.nextInt();
            System.out.print("\033[H\033[2J");
            System.out.flush();
            if (vazieat == 1) {
                barresyVaziat(vazieat);
            } else if (vazieat == 2) {
                users.add(new User());
                System.out.println("Enter your Name:");
                users.get(tedadKarbar).setName(scanner.next());
                System.out.println("Enter your UserName:");
                users.get(tedadKarbar).setUserName(scanner.next());
                System.out.println("Enter your Email:");
                users.get(tedadKarbar).setEmail(scanner.next());
                System.out.println("Enter your PassWord:");
                users.get(tedadKarbar).setPassWord(scanner.next());
                System.out.println("Enter your NationalCode:");
                users.get(tedadKarbar).setNationalCode(scanner.next());
                System.out.println("Enter your PhoneNumber:");
                users.get(tedadKarbar).setPhoneNumber(scanner.next());
                System.out.println("You make your user successfully \n" + "System restarted.");
                tedadKarbar++;
            } else {
                System.out.println("Please enter 1 or 2 !!");
            }
        }
    }
}