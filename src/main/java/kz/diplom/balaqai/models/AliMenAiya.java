package kz.diplom.balaqai.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_alimenaiya")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AliMenAiya extends BaseEntity{

    @Column(name = "variant1")
    private String variant1;

    @Column(name = "variant2")
    private String variant2;

    @Column(name = "variant3")
    private String variant3;

    @Column(name = "variant4")
    private String variant4;

    @Column(name = "answer")
    private String answer;

}

