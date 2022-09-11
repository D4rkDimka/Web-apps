package com.tms.prudnik.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode

public class Book {
    private String name;
    private String author;
    private Integer amountOfPages;
}
