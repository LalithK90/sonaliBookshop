package lk.sonali_bookshop.asset.user_management.role.dao;


import lk.sonali_bookshop.asset.user_management.role.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends JpaRepository< Role, Integer > {//interface-interface =>extend //link to JpaRepository.java
    Role findByRoleName(String roleName);
}

//java interface keywords 2- extend,implement
//JpaRepository-lock has in the icon.Because we put a dependency for our system by build.gradle we can't change.we don't write them.
