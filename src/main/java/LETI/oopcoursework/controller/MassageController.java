package LETI.oopcoursework.controller;

import LETI.oopcoursework.domain.Message;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;


import javax.persistence.Query;
import java.util.List;

import LETI.oopcoursework.OopCourseworkApplication;

@RestController
@RequestMapping("message")
public class MassageController {

    @GetMapping
    public List<Message> list() {
        return OopCourseworkApplication.em.createQuery("SELECT g FROM Message g WHERE id > 0", Message.class).getResultList();
    }

    @GetMapping("{id}")
    public Message getOne(@PathVariable String id) {
        return OopCourseworkApplication.em.find(Message.class, Long.parseLong(id, 10));
    }

    @PostMapping
    public Message create(@org.jetbrains.annotations.NotNull @RequestBody Message message) {

        OopCourseworkApplication.em.getTransaction().begin();

        Message newMessage = new Message();
        message.setText(message.getText());
        OopCourseworkApplication.em.persist(message);

        OopCourseworkApplication.em.getTransaction().commit();
        return newMessage;
    }

    @PutMapping("{id}")
    public Message update(
            @PathVariable String id,
            @RequestBody Message message
    ) {
        Message messageFromDb = OopCourseworkApplication.em.find(Message.class, Long.parseLong(id, 10));

        BeanUtils.copyProperties(message, messageFromDb, "id");

        OopCourseworkApplication.em.getTransaction().begin();
        OopCourseworkApplication.em.persist(messageFromDb);
        OopCourseworkApplication.em.getTransaction().commit();

        return messageFromDb;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        Message message = OopCourseworkApplication.em.find(Message.class, Long.parseLong(id, 10));

        OopCourseworkApplication.em.getTransaction().begin();
        OopCourseworkApplication.em.remove(message);
        OopCourseworkApplication.em.getTransaction().commit();;
    }
}