package lk.sonali.bookshop.asset.userManagement.dao;
import lk.sonali.bookshop.asset.userManagement.entity.Enum.UserSessionLogStatus;
import lk.sonali.bookshop.asset.userManagement.entity.User;
import lk.sonali.bookshop.asset.userManagement.entity.UserSessionLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSessionLogDao extends JpaRepository< UserSessionLog, Integer > {
    UserSessionLog findByUserAndUserSessionLogStatus(User user, UserSessionLogStatus userSessionLogStatus);
}
