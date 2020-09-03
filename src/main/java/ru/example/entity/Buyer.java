package ru.example.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.*;

public class Buyer implements SQLData {
    private String firstName;
    private String lastName;
    private String sqlType;

    public String getSqlTypeName() {
        return sqlType;
    }

    public Buyer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "['" + getFirstName() + "', '" + getLastName() + "']";
    }

    /**
     * Returns the fully-qualified
     * name of the SQL user-defined type that this object represents.
     * This method is called by the JDBC driver to get the name of the
     * UDT instance that is being mapped to this instance of
     * <code>SQLData</code>.
     *
     * @return the type name that was passed to the method <code>readSQL</code>
     * when this object was constructed and populated
     * @throws SQLException                    if there is a database access error
     * @throws SQLFeatureNotSupportedException if the JDBC driver does not support
     *                                         this method
     * @since 1.2
     */
    @Override
    public String getSQLTypeName() throws SQLException {
        return "buyer";
    }

    /**
     * Populates this object with data read from the database.
     * The implementation of the method must follow this protocol:
     * <UL>
     * <LI>It must read each of the attributes or elements of the SQL
     * type  from the given input stream.  This is done
     * by calling a method of the input stream to read each
     * item, in the order that they appear in the SQL definition
     * of the type.
     * <LI>The method <code>readSQL</code> then
     * assigns the data to appropriate fields or
     * elements (of this or other objects).
     * Specifically, it must call the appropriate <i>reader</i> method
     * (<code>SQLInput.readString</code>, <code>SQLInput.readBigDecimal</code>,
     * and so on) method(s) to do the following:
     * for a distinct type, read its single data element;
     * for a structured type, read a value for each attribute of the SQL type.
     * </UL>
     * The JDBC driver initializes the input stream with a type map
     * before calling this method, which is used by the appropriate
     * <code>SQLInput</code> reader method on the stream.
     *
     * @param stream   the <code>SQLInput</code> object from which to read the data for
     *                 the value that is being custom mapped
     * @param typeName the SQL type name of the value on the data stream
     * @throws SQLException                    if there is a database access error
     * @throws SQLFeatureNotSupportedException if the JDBC driver does not support
     *                                         this method
     * @see SQLInput
     * @since 1.2
     */
    @Override
    public void readSQL(SQLInput stream, String typeName) throws SQLException {
        sqlType = typeName;
        firstName = stream.readString();
        lastName = stream.readString();
    }

    /**
     * Writes this object to the given SQL data stream, converting it back to
     * its SQL value in the data source.
     * The implementation of the method must follow this protocol:<BR>
     * It must write each of the attributes of the SQL type
     * to the given output stream.  This is done by calling a
     * method of the output stream to write each item, in the order that
     * they appear in the SQL definition of the type.
     * Specifically, it must call the appropriate <code>SQLOutput</code> writer
     * method(s) (<code>writeInt</code>, <code>writeString</code>, and so on)
     * to do the following: for a Distinct Type, write its single data element;
     * for a Structured Type, write a value for each attribute of the SQL type.
     *
     * @param stream the <code>SQLOutput</code> object to which to write the data for
     *               the value that was custom mapped
     * @throws SQLException                    if there is a database access error
     * @throws SQLFeatureNotSupportedException if the JDBC driver does not support
     *                                         this method
     * @see SQLOutput
     * @since 1.2
     */
    @Override
    public void writeSQL(SQLOutput stream) throws SQLException {
        if (firstName != null)
            stream.writeString(firstName);
        else
            stream.writeObject(null);

        if (lastName != null)
            stream.writeString(lastName);
        else
            stream.writeObject(null);

    }

}
