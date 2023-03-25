package kz.diplom.balaqai.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_nauryztraditions")
public class NauryzTraditions extends BaseEntity{

    @Column(name = "nt_name")
    private String name;

    @Column(name = "nt_description")
    private String description;

    @Column(name = "nt_image")
    private String image;

    @Column(name = "nt_video")
    private String video;

}
