package kz.diplom.balaqai.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_suretteNeKorsetilgen")
@Data
public class SuretteNeKorsetilgen extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String image;

}
