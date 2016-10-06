package chuck;

/**
 * Created by manji on 6/7/16.


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "fortunes")
public class Fortune {
    @Id
    private Integer id;
    @Column(name="fortune")
    private String text;
    private Boolean offensive;

    public Fortune() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setOffensive(Boolean offensive) {
        this.offensive = offensive;
    }

    public long getId() {
        return id;
    }

    public Boolean getOffensive() {

        return offensive;
    }

    public String getText() {

        return text;
    }

} **/
