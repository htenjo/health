package co.zero.health.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

/**
 * Created by hernan on 6/30/17.
 */
@Getter
@Setter
@ToString
@Document
public class Client {
    private String id;
    private String name;
    private LocalDate createdDate;
}
