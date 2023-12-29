package application;

import java.util.List;

public interface Service {
    int filmDetails(Film film);

    int updateDetails(int fYear, String fName);

    List<Film> displayDetails();

    List<Film> top5Film();
}
