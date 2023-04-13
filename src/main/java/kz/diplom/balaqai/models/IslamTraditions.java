package kz.diplom.balaqai.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_islamtraditions")
@Data
public class IslamTraditions extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "description1")
    private String description1;

    @Column(name = "description2")
    private String description2;

    @Column(name = "image")
    private String image;

    @Column(name = "video")
    private String video;

    @Column(name = "question")
    private String question;

    @Column(name = "variantA")
    private String variantA;

    @Column(name = "variantB")
    private String variantB;

    @Column(name = "variantC")
    private String variantC;

}
