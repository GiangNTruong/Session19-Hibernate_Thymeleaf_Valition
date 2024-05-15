package ra.baitapvnthayhai.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import javax.validation.constraints.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="employees")
public class Employee {
    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer emId;


   @NotEmpty(message = "Không để rong")
    @Size(min=2, max=50 , message = "từ 2-15")
    @Column(name = "employee_name")
    private String emName;

    @NotEmpty
    @Size(min=2, max=50)
    @Column(name = "address")
    private String address;

    @NotNull(message = "Không để rong")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "dateOfBirth")
    @Past(message = "Khong dung ngay ")
    private Date dateOfBirth;

    @NotEmpty
    @Size(min=6, max=15)
    @Column(name = "phone")
    private String phone;


}
