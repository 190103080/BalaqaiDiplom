package kz.diplom.balaqai.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_traditionsandcustomsofeducation")
public class TraditionsAndCustomsOfEducation extends BaseEntity{

    @Column(name = "td_name")
    private String name;

    @Column(name = "td_description")
    private String description;

    @Column(name = "td_image")
    private String image;

    @Column(name = "td_video")
    private String video;

}
