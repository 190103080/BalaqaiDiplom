package kz.diplom.balaqai.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_jasyrylganZattar")
@Data
public class JasyrylganZattar extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String image;

}
