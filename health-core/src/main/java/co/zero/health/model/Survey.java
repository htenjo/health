package co.zero.health.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

/**
 * Created by hernan on 6/30/17.
 */
@Getter
@Setter
@ToString
@Entity
public class Survey extends AbstractEntity {
    @ManyToOne
    private SurveyTemplate template;
    @ManyToOne
    private Event event;
    @ManyToOne
    @JsonIgnore
    private Patient patient;
    private String surveyAnswers;
    @Enumerated(EnumType.STRING)
    private SurveyState state;

    public Survey() {
        this.state = SurveyState.NOT_STARTED;
    }

    public Survey(SurveyTemplate template) {
        this();
        this.template = template;
    }

    public Survey(SurveyTemplate template, Event event) {
        this(template);
        this.event = event;
        this.patient = event.getPatient();
    }

    public Survey(SurveyTemplate template, Patient patient) {
        this(template);
        this.patient = patient;
    }
}