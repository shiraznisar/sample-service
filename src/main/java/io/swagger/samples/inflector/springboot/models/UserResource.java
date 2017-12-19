package io.swagger.samples.inflector.springboot.models;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Link;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserResource implements Resource {
  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Override
  public List<Link> getLinks() {
    throw new NotImplementedException("TODO");
  }
  
  public UserDetails getUser() {
	  String sql = "select * from UserDetails";
	  
	  UserDetails userDetails = new UserDetails();
	  
	  Map<String, Object> rows = jdbcTemplate.queryForMap(sql);
	  
	  userDetails.setDob((String) rows.get("DoB"));
	  
	  String name = (String) rows.get("Name");
	  
	  String[] names = name.split(" ");
	  userDetails.setFirstname(names[1]);
	  userDetails.setSurname(names[0]);
	  
	  return userDetails;
  }

}
