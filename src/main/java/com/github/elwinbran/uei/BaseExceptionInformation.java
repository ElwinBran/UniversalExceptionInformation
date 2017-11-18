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

import java.util.Objects;
import java.util.logging.Level;

/**
 * Serves as the base for exception information to prevent duplicate code.
 *
 * @author Elwin Slokker
 */
public abstract class BaseExceptionInformation implements ExceptionInformation
{
    private final String message;
    private final Level level;
    private final Object thrower;
    private final ExceptionType type;
    private final String threadName;
    protected String throwableTrace;

    protected BaseExceptionInformation(final String message, final Level level,
                                       final Object thrower,
                                       final ExceptionType type) {
        this.message = message;
        this.level = level;
        this.thrower = thrower;
        this.type = type;
        this.threadName = Thread.currentThread().getName();
        this.throwableTrace = "";
        
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public String getMessage()
    {
        return this.message;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Level getLevel()
    {
        return this.level;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Object getThrower()
    {
        return this.thrower;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ExceptionType getType(){return this.type;}

    /**
     * Based on
     * https://www.sitepoint.com/implement-javas-equals-method-correctly/
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof BaseExceptionInformation))
            return false;
        BaseExceptionInformation other = (BaseExceptionInformation) obj;
        return Objects.equals(this.level, other.level)
                && Objects.equals(this.message, other.message)
                && Objects.equals(this.thrower, other.thrower)
                && Objects.equals(this.type, other.type);
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder("Exception in \"");
        builder.append(this.threadName);
        builder.append("\" ");
        builder.append(this.getType().getName());
        builder.append(": ");
        builder.append(this.getMessage());
        builder.append("\n (group is ");
        builder.append(this.getType().getGroup().getName());
        builder.append(")");
        builder.append(this.throwableTrace);
        return builder.toString();
    }
}
