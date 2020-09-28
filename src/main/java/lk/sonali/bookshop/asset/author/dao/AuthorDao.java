package lk.sonali.bookshop.asset.author.dao;


import lk.sonali.bookshop.asset.author.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorDao extends JpaRepository< Author, Integer> {
}
