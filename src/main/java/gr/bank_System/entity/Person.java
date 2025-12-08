package gr.bank_System.entity;

import gr.bank_System.core.enums.Gender;
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

    @Column(name = "dateOfBirth", nullable = false)
    private String dateOfBirth;

    @Column(name = "placeOfBirth", nullable = false, length = 50)
    private String placeOfBirth;

    @Column(name = "fatherName", nullable = false, length = 50)
    private String fatherName;

    @Column(name = "identityNumber",unique = true, nullable = false, length = 9)
    private String identityNumber;

    @Column(name = "phone", nullable = false, length = 10)
    private Integer phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private Gender gender;

    @OneToOne(mappedBy = "person")
    private User user;
}
