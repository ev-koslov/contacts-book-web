package ev.koslov.db.repository;

import ev.koslov.db.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Jpa repository for Contact entity
 */
public interface ContactJpaRepository extends JpaRepository<Contact, Long> {
    /**
     * Selects any contact of given user
     * @param login account login
     * @return list of user's contacts sorted by surname
     */
    @Query("SELECT c FROM Contact c where c.owner.login = :login order by c.surname asc ")
    List<Contact> getAllUserContacts(@Param("login") String login);


    /**
     * Does filtered selection of user's contacts using given expression
     * @param login account login
     * @param criteria filter criteria
     * @return list of user's contacts which are mathing given criteria. Sorted by surname
     */
    @Query("SELECT c FROM Contact c where c.owner.login = :login and " +
            "(c.surname like %:criteria% " +
            "or c.name like %:criteria% " +
            "or c.secondName like %:criteria% " +
            "or c.cellPhone like %:criteria% " +
            "or c.phone like %:criteria% " +
            "or c.address like %:criteria% " +
            "or c.email like %:criteria%) order by c.surname asc ")
    List<Contact> getFilteredUserContacts(@Param("login") String login,
                                          @Param("criteria") String criteria);
}
