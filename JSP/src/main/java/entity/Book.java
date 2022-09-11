package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter

public class Book {
    private String name;
    private String author;
    private int amountOfPages;

    @Override
    public String toString() {
        return "Book name: "+ name+ " /Author: "+author+ " /Pages: "+ amountOfPages;
    }
}


