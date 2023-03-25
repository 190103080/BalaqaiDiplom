package kz.diplom.balaqai.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_islamtraditions")
public class IslamTraditions extends BaseEntity{

    @Column(name = "it_name")
    private String name;

    @Column(name = "it_description")
    private String description;

    @Column(name = "it_image")
    private String image;

    @Column(name = "it_video")
    private String video;

}
