package com.consultitnow.app.entity;



import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Internal Agent")
public class InternalAgent extends Users {

}
