package darknsoft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.persistence.TypedQuery;

@Repository
public class HibernateDao {

  private LocalSessionFactoryBean localSessionFactoryBean;

  @Autowired
  public HibernateDao(
      LocalSessionFactoryBean localSessionFactoryBean) {
    this.localSessionFactoryBean = localSessionFactoryBean;
  }
//  public List<Authors> listAuthors() {
//    /@SuppressWarnings("unchecked")
//    //TypedQuery<Authors> query=localSessionFactoryBean.getObject().
//    return query.getResultList();
//  }
}
