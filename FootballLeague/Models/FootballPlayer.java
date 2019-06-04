package SDA.Streams.FootballLeague.Models;

import java.time.LocalDate;

public class FootballPlayer {
    private String name;
    private String lastName;
    private Position position;
    private LocalDate dateOfBirth;

    public FootballPlayer(String name, String lastName, Position position, LocalDate dateOfBirth) {
        this.name = name;
        this.lastName = lastName;
        this.position = position;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
