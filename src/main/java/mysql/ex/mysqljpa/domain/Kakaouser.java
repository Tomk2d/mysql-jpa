package mysql.ex.mysqljpa.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Kakaouser {

    @Id
    private String id;
    private String email;
    private String nickname;
    private String password;
}
