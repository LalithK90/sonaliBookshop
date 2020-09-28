package lk.sonali.bookshop.asset.author.service;


import lk.sonali.bookshop.asset.author.dao.AuthorDao;
import lk.sonali.bookshop.asset.author.entity.Author;
import lk.sonali.bookshop.util.interfaces.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthorService implements AbstractService< Author, Integer> {

    private final AuthorDao authorDao;
    @Autowired
    public AuthorService(AuthorDao authorDao){
        this.authorDao = authorDao;
    }


    @Cacheable(value = "SampleCollectingTube")
    public List< Author > findAll() {
        return authorDao.findAll();
    }


    public Author findById(Integer id) {
        return authorDao.getOne(id);
    }

    @Transactional
    public Author persist(Author author) {
        return authorDao.save(author);
    }

    @Transactional
    public boolean delete(Integer id) {
        authorDao.deleteById(id);
        return false;
    }


    public List< Author > search(Author author) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example< Author > sampleCollectingTubeExample = Example.of(author, matcher);
        return authorDao.findAll(sampleCollectingTubeExample);
    }
}
