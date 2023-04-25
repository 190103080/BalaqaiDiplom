package kz.diplom.balaqai.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_saikestendiru")
@Data
public class Saikestendiru extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String image;

}
