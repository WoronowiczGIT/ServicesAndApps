package paprotka.algorithms;

import paprotka.exceptions.IncorrectValueException;

import java.util.List;

public interface Algorithm {

    void execute(List<String> lines) throws IncorrectValueException;
}
