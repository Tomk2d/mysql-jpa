package mysql.ex.mysqljpa.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Getter
@Setter
public class article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long c_id;
    @NonNull
    private String c_name;
    @NonNull
    private String c_mind1;
    @NonNull
    private String c_mind2;
    @NonNull
    private String c_mind3;
    @NonNull
    private String c_mind4;

    public Long getC_id() {
        return c_id;
    }

    public void setC_id(Long c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_mind1() {
        return c_mind1;
    }

    public void setC_mind1(String c_mind1) {
        this.c_mind1 = c_mind1;
    }

    public String getC_mind2() {
        return c_mind2;
    }

    public void setC_mind2(String c_mind2) {
        this.c_mind2 = c_mind2;
    }

    public String getC_mind3() {
        return c_mind3;
    }

    public void setC_mind3(String c_mind3) {
        this.c_mind3 = c_mind3;
    }

    public String getC_mind4() {
        return c_mind4;
    }

    public void setC_mind4(String c_mind4) {
        this.c_mind4 = c_mind4;
    }
}
