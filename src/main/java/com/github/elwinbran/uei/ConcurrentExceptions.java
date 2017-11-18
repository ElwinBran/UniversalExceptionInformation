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
 *
 * @author Elwin Slokker
 */
public enum ConcurrentExceptions implements ExceptionType
{
    //java.util.concurrent
    TIMEOUT(BaseExceptions.GENERIC, Groups.RETRY_REQUIRED),
    BROKEN_BARRIER_EXCEPTION(BaseExceptions.GENERIC, Groups.RETRY_REQUIRED),
    EXECUTION_EXCEPTION(BaseExceptions.GENERIC, Groups.RETRY_REQUIRED);

    private final ExceptionType parent;

    private final GroupType group;

    private String name;

    /**
     *
     * @param parent
     * @param group
     */
    private ConcurrentExceptions(ExceptionType parent, GroupType group)
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
    private ConcurrentExceptions(String name, ExceptionType parent, GroupType group)
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
