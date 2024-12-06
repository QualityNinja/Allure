package model;

import lombok.Data;

@Data
public class User {
    private String name;
    private String job;
    private String id;
    private String createdAt;
    private String updatedAt;
}
