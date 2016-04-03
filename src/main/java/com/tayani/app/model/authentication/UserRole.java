
package com.tayani.app.model.authentication;

/**
 * This Enum has the list of all possible roles in our application
 * <p>
 * 1: Admin - Can change passwords, add new users and has complete control over
 * application. 
 * <p>
 * 2: Office_User - Will manually input data in office and will generate reports
 * <p>
 * 3: Mine_User - Will be a person from mine who will relevant input data 
 * 
 */
public enum UserRole {

	Admin, Office_User, Mine_User;

}
