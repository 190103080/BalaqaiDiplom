package kz.diplom.balaqai.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_familytraditions")
public class FamilyTraditions extends BaseEntity{

    @Column(name = "ft_name")
    private String name;

    @Column(name = "ft_description")
    private String description;

    @Column(name = "ft_image")
    private String image;

    @Column(name = "ft_video")
    private String video;

}
