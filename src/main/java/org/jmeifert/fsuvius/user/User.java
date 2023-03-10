package org.jmeifert.fsuvius.user;

import java.io.Serializable;
import java.util.Objects;
import java.util.Random;
import java.lang.Integer;

import org.jmeifert.fsuvius.util.StringTools;

/**
 * User represents an account in the system with an ID, name, and balance.
 */
public class User implements Serializable {

    private String id;
    private String name;
    private float balance;

    /**
     * Constructs a User with the name "" and a balance of 0.
     */
    public User() {
        this.id = generateID();
        this.name = "";
        this.balance = 0.0F;
    }

    /**
     * Constructs a User with the given name and a balance of 0.
     * @param name The User's name
     */
    public User(String name) {
        this.id = generateID();
        this.name = StringTools.sanitizeLine(name);
        this.balance = 0.0F;
    }

    /**
     * Constructs a User with the given name and balance.
     * @param name The User's name
     * @param balance The User's balance
     */
    public User(String name, float balance) {
        this.id = generateID();
        this.name = StringTools.sanitizeLine(name);
        this.balance = balance;
    }

    /**
     * Returns this User's ID.
     * @return This User's ID
     */
    public String getID() {
        return this.id;
    }

    /**
     * Returns this User's name.
     * @return this User's name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns this User's balance.
     * @return this User's balance
     */
    public float getBalance() {
        return this.balance;
    }

    /**
     * Sets this User's ID.
     * @param id this User's ID
     */
    public void setID(String id) {
        this.id = id;
    }

    /**
     * Sets this User's name.
     * @param name this User's name
     */
    public void setName(String name) {
        this.name = StringTools.sanitizeLine(name);
    }

    /**
     * Sets this User's balance.
     * @param balance this User's balance
     */
    public void setBalance(float balance) {
        this.balance = balance;
    }

    /**
     * Generates an ID.
     * @return id The generated ID.
     */
    public String generateID() {
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        sb.append("user");
        for(int i = 0; i < 64; i++) {
            sb.append(Integer.toHexString(r.nextInt(256)));
        }
        return sb.toString();
    }


    @Override
    public boolean equals(Object other) {
        if(!(other instanceof User)) {
            return false;
        }
        return Objects.equals(this.id, ((User) other).getID()) &&
                Objects.equals(this.name, ((User) other).getName()) &&
                Objects.equals(this.balance, ((User) other).getBalance());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.balance);
    }

    @Override
    public String toString() {
        return String.format(
          "{\n    \"id\" = \"%s\",\n    \"name\" = \"%s\",\n    \"balance\" = %f,\n}",
                this.id,
                this.name,
                this.balance
        );
    }
}
