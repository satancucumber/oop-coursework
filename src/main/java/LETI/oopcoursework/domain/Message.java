package LETI.oopcoursework.domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

import java.lang.Object;

@Entity
@Table(name = "message", schema = "information_schema")
@ToString(of = {"id", "text"})
@EqualsAndHashCode(of = {"id"})
public class Message{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "text")
    private String text;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
