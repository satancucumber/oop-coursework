package LETI.oopcoursework;

import LETI.oopcoursework.domain.Message;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

//
//@ComponentScan(basePackages = "LETI.oopcousework")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EntityScan("LETI.oopcousework.domain")
public class OopCourseworkApplication {
	public static EntityManagerFactory emf;
	public static EntityManager em;

	public static void main(String[] args) {

		emf = Persistence.createEntityManagerFactory("db_persistence");
		em = emf.createEntityManager();

		SpringApplication.run(OopCourseworkApplication.class, args);

//
//
//		em.getTransaction().begin();
//
//		Message message = em.find(Message.class, Long.parseLong("1", 10));
//		System.out.println(message);
//
//		em.remove(message);
//		message.setText("Second message!!!");
//		em.persist(message);
//		Message newMessage = new Message();
//		newMessage.setText("Third message");
//		em.getTransaction().commit();
//
//		System.out.println(newMessage.getId() + " " + newMessage.getText());
//
//		List<Message> list = em.createQuery("SELECT g FROM Message g WHERE id > 0").getResultList();
//		System.out.println(list);
//
//		for (int i = 0; i < list.size(); i++) {
//
//			System.out.println(list.get(i).toString());
//		}
//
//		list = em.createQuery("SELECT g FROM Message g WHERE id > 0").getResultList();
//		for (int i = 0; i < list.size(); i++) {
//
//			System.out.println(list.get(i).getId() + " " + list.get(i).getText());
//		}
	}

}
