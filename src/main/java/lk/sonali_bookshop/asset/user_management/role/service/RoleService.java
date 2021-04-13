package lk.sonali_bookshop.asset.user_management.role.service;


import lk.sonali_bookshop.asset.common_asset.model.enums.LiveDead;
import lk.sonali_bookshop.asset.user_management.role.dao.RoleDao;
import lk.sonali_bookshop.asset.user_management.role.entity.Role;
import lk.sonali_bookshop.util.interfaces.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Service
@CacheConfig( cacheNames = {"role"} ) // tells Spring where to store cache for this class
public class RoleService implements AbstractService< Role, Integer > {
    private final RoleDao roleDao;

    @Autowired
    public RoleService(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Cacheable
    public List< Role > findAll() {
        return roleDao.findAll().stream()
            .filter(x -> LiveDead.ACTIVE.equals(x.getLiveDead()))
            .collect(Collectors.toList());
    }

    @Cacheable
    public Role findById(Integer id) {
        return roleDao.getOne(id);
    }


    @Caching( evict = {@CacheEvict( value = "role", allEntries = true )},
            put = {@CachePut( value = "role", key = "#role.id" )} )//Link to ApplicationCreateResetController.java
    public Role persist(Role role) {//(save role)
        role.setRoleName(role.getRoleName().toUpperCase());//set role name as upper case
        if ( role.getId()==null ){//look is it null
            role.setLiveDead(LiveDead.ACTIVE);//liveDead check
        }
        return roleDao.save(role);//give role as a save method(return role)
    }

    @CacheEvict( allEntries = true )
    public boolean delete(Integer id) {
        Role role =roleDao.getOne(id);//look in role dao(user_management-role-dao-RoleDao)
        role.setLiveDead(LiveDead.STOP);
        roleDao.save(role);//role save
        return true;
    }

    @Cacheable
    public List< Role > search(Role role) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example< Role > roleExample = Example.of(role, matcher);
        return roleDao.findAll(roleExample);
    }

    @Cacheable
    public Role findByRoleName(String roleName) {
        return roleDao.findByRoleName(roleName);
    }
}

//spring framework - JpaRepository