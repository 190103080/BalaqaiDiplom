package kz.diplom.balaqai.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_pass_reset")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PasswordResetRequest extends BaseEntity {

    @Column(name = "email")
    private String email;

    @Column(name = "link")
    private String link;

}
