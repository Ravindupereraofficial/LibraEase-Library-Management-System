package edu.icet.librarymanagementsystem.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class User {
    private String id;
    private String username;
    private String email;
    private String password;

}
