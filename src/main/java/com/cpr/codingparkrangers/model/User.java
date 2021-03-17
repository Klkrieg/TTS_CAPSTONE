package com.cpr.codingparkrangers.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User{

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "user_id")
  private long id;

  @CreationTimestamp
  private Date createdAt;

  @Length(min=3, message = "Your username must have at least 3 characters")
  @Length(max = 15, message = "Your username must not be longer than 15 characters")
  private String username;
  @Email(message="Please provide a valid email")
  @NotEmpty(message="Please provide an email")
  private String email;
  @Length(min = 5, message = "Your password must have at least 5 characters")
  private String password;
//  private List<Favorite> favorites;
  private int active;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
          inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles;

}
