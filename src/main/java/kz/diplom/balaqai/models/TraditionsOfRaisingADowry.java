package kz.diplom.balaqai.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_traditionsofraisingadowry")
public class TraditionsOfRaisingADowry extends BaseEntity{

    @Column(name = "tr_name")
    private String name;

    @Column(name = "tr_description")
    private String description;

    @Column(name = "tr_image")
    private String image;

    @Column(name = "tr_video")
    private String video;

}
