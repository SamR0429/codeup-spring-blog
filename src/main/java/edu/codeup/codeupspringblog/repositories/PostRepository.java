package edu.codeup.codeupspringblog.repositories;

import edu.codeup.codeupspringblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;


//whats in the <> is going to be the name of the db and then the data type of the property that holds the id, most likely will be a long when you make the db
public interface PostRepository extends JpaRepository<Post, Long> {
}
