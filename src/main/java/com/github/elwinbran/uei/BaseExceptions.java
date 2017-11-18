/*
 * Copyright (c) 2017 Elwin Slokker
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.github.elwinbran.uei;

/**
 * The default kinds of exceptions.
 * <br><br>
 * All entries are added to the {@link ExceptionSet}.
 *
 * @author Elwin Slokker
 */
public enum BaseExceptions implements ExceptionType
{
//==============================================================================
// Should never be made since they are useless to clients.
//==============================================================================
    
    /**
     * Undefined exception type. 
     * <br>Should be the parent of all exception types.
     * <br>This exception type is completely useless to the user and calling 
     * code so please refrain from using.
     */
    UNKNOWN(null, Groups.UNKNOWN),
    
    /**
     * Can be used to handle remaining exceptions.(?? TODO)
     */
    GENERIC(UNKNOWN, Groups.UNKNOWN),
    
    /**
     * Marks exception that occurred during a reflective operation.
     */
    REFLECTIVE_OPERATION(GENERIC, Groups.PROGRAMMER_INTERVENTION_REQUIRED),
    
//==============================================================================
// Exception kinds inspired by the ones found in {@see java.lang}
//==============================================================================

    INTERUPTED(GENERIC, Groups.OUTSIDE_SOFTWARE_SCOPE),
    CLONE_NOT_SUPPORTED(GENERIC, Groups.OUTSIDE_SOFTWARE_SCOPE),
    
    CLASS_NOT_FOUND(REFLECTIVE_OPERATION, Groups.PROGRAMMER_INTERVENTION_REQUIRED),
    INSTANTION(REFLECTIVE_OPERATION, Groups.PROGRAMMER_INTERVENTION_REQUIRED),
    ILLEGAL_ACCESS(REFLECTIVE_OPERATION, Groups.PROGRAMMER_INTERVENTION_REQUIRED),
    INVOCATION_TARGET(REFLECTIVE_OPERATION, Groups.PROGRAMMER_INTERVENTION_REQUIRED),
    NO_SUCH_FIELD(REFLECTIVE_OPERATION, Groups.PROGRAMMER_INTERVENTION_REQUIRED),
    NO_SUCH_METHOD(REFLECTIVE_OPERATION, Groups.PROGRAMMER_INTERVENTION_REQUIRED);

    
    /*
    socket exceptions
    also these things are WIP
    BindException,
    ConnectException,
            HttpRetryException,
    MalformedURLException,
            ProtocolException,
    UnknownHostException,
            UnknownServiceException,

    //SQL exception
    SQLDataException,
    SQLFeatureNotSupportedException,
            SQLIntegrityConstraintViolationException,
    SQLSyntaxErrorException,
            SQLTransientException,
    SQLTimeoutException,
            SQLTransactionRollbackException,
    SQLTransientConnectionException,
            SQLRecoverableException,
    SQLWarning;
    */
    
    private final ExceptionType parent;

    private final GroupType group;

    private String name;

    /**
     * Default constructor that adds the enum to the public set.
     * 
     * @param parent
     * @param group
     */
    private BaseExceptions(ExceptionType parent, GroupType group)
    {
        this.parent = parent;
        this.group = group;
        ExceptionSet.getInstance().add(this);
    }

    /**
     *
     * @param name
     * @param parent
     * @param group
     * @deprecated Reserved for future use, when the default Enum name may not
     * be desireable anymore.
     */
    private BaseExceptions(String name, ExceptionType parent, GroupType group)
    {
        this.name = name;
        this.parent = parent;
        this.group = group;
        ExceptionSet.getInstance().add(this);
    }


    @Override
    public String getName()
    {
        return this.name();
    }

    @Override
    public boolean hasParent()
    {
        return getParent() != null;
    }

    @Override
    public ExceptionType getParent()
    {
        return this.parent;
    }

    @Override
    public GroupType getGroup()
    {
        return this.group;
    }
}
