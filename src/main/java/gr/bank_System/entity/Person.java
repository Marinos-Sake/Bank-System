package gr.bank_System.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "persons")
public class Person extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50)
    private String surname;

    @Column(name = "date_of_birth", nullable = false)
    private String dateOfBirth;

    @Column(name = "place_of_birth", nullable = false, length = 50)
    private String placeOfBirth;

    @Column(name = "father_name", nullable = false, length = 50)
    private String fatherName;

    @Column(name = "identity_number",unique = true, nullable = false, length = 9)
    private String identityNumber;
}
