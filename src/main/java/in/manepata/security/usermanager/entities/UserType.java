package in.manepata.security.usermanager.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "user_types")
public class UserType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String type;

    // ... (getters and setters)
}