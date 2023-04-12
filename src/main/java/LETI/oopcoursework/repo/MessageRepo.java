package LETI.oopcoursework.repo;

import LETI.oopcoursework.domain.Message;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Qualifier("message")
@Repository
public interface MessageRepo extends JpaRepository<Message, Long> {
}
