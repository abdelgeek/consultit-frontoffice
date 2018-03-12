package com.consultitnow.app.entity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("TechnicalRequirements")
public class TechnicalRequirements extends ApprovalInformation {

}
