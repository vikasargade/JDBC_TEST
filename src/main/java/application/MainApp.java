package application;


import java.util.List;
import java.util.Scanner;

public class MainApp {

    private static Scanner sc = new Scanner(System.in);
    private static Service service =new ServiceImplmentaion();


    public static void main(String[] args) {

        System.out.println("-------------------------------------");
        System.out.println("1.ENTER FILM DETAILS");
        System.out.println("2.UPDATE FILM DETAILS");
        System.out.println("3.DISPLAY FILM DETAILS");
        System.out.println("4.NOMINATION OF TOP 5 FILM FOR AN OSCAR AWARD");
        System.out.println("5.EXIT");

        int ch = sc.nextInt();
        System.out.println("-------------------------------------");
        switch (ch)
        {
            case 1:
                 filmDetails();
                break;
            case 2:
                 updateDetails();
                break;
            case 3:
                 displayDetails();
                break;
            case 4:
                 top5Film();
                break;
            case 5:
                System.out.println("APPLICATION CLOSED");
                System.exit(0);
                break;

            default:
                System.out.println("INVALID OPTION");
        }
        main(args);

    }

    private static void top5Film() {
        List<Film> filmAll = service.top5Film();
        System.out.println("\t\t***TOP 5 FILM DETAILS***\n");

        for(Film f:filmAll)
        {
            System.out.println(f.getFilmId()+" "+f.getFilmName()+" "+" "+f.getFilmYear()+" "+f.getFilmLang()+" "+f.getFilmRating());
        }


    }

    private static void displayDetails() {

        List<Film> filmAll = service.displayDetails();
        System.out.println("\t\t***FILM DETAILS***\n");

        for(Film f:filmAll)
        {
            System.out.println(f.getFilmId()+" "+f.getFilmName()+" "+" "+f.getFilmYear()+" "+f.getFilmLang()+" "+f.getFilmRating());
        }


    }

    private static void updateDetails() {
        System.out.println("ENTER FILM YEAR");
        int fYear = sc.nextInt();
        System.out.println("ENTER FILM NAME");
        String fName = sc.nextLine();
        fName = sc.nextLine();


        int n = service.updateDetails(fYear,fName);
        System.out.println(n+" ROWS UPDATED");
    }




    private static void filmDetails() {

        System.out.println("ENTER FILM NAME: ");
        String fName = sc.nextLine();
        fName = sc.nextLine();

        System.out.println("ENTER FILM YEAR: ");
        int fYear = sc.nextInt();

        System.out.println("ENTER FILM LANG: ");
        String fLang =sc.next();

        System.out.println("ENTER FILM RATING OUT OF 10");
        int fRating = sc.nextInt();

        Film film = new Film(fName,fYear,fLang,fRating);

        int  row =service.filmDetails(film);

        System.out.println(row+" ROWS ARE ADDED SUCESSFULLY");


    }
}
