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
 * Provides the 'default' collection of Groups.
 * <br><br>
 * All entries are added to the {@link GroupSet}.
 * 
 * 
 * @author Elwin Slokker
 */
public enum Groups implements GroupType
{
    /**
     * It is unknown what group this exception is in.
     */
    UNKNOWN,
    
    /**
     * The solution is outside the means of the software. 
     * <br>Usually exceptions that deal with hardware encounter this.
     */
    OUTSIDE_SOFTWARE_SCOPE,
    
    /**
     * Some services are not always available and may simply need another try
     * to use. 
     * <br>Exceptions in this group should 90% of the time really be solvable
     * by trying again.
     */
    RETRY_REQUIRED,
    
    /**
     * These kind of exceptions require human (or very smart machines) 
     * intervention. 
     * <br>Usually encountered when a human user makes a 'mistake' or 
     * the program encounters a logic loop, like dependency problems.
     */
    HUMAN_INTERACTION_REQUIRED,
    
    /**
     * No exception of this group should ever be encountered...
     * <br>... but if they are encountered, programmer intervention is required 
     * to fix them.
     */
    PROGRAMMER_INTERVENTION_REQUIRED;
    

    private Groups()
    {
        GroupSet.getInstance().add(this);
    }

    @Override
    public String getName() {
        return this.name();
    }
}
