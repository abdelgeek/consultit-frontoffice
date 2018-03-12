package com.consultitnow.app.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("AdminstrativeRequirements")
public class AdminstrativeRequirements extends ApprovalInformation {

}
