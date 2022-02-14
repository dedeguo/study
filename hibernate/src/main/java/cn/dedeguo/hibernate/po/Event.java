package cn.dedeguo.hibernate.po;



import org.geolatte.geom.Point;
import org.hibernate.annotations.GenericGenerator;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity(name = "Event")
public  class Event {

    @Id
  //  @Generated(Ide)
   // @GenericGenerator(Ide)
    private Long id;

    private String name;

    private Point location;

    //Getters and setters are omitted for brevity

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }
}
