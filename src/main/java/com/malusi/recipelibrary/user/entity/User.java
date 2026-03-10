package com.malusi.recipelibrary.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class User{

  private @Id @GeneratedValue Long id;
  private string firstName;
  private string lastName;




}
