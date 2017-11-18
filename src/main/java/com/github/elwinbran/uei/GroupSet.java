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

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author Elwin Slokker
 */
@Deprecated
public class GroupSet implements Set<GroupType>
{
    private static GroupSet INSTANCE = null;

    public static synchronized GroupSet getInstance()
    {
        if(INSTANCE == null)
        {
            INSTANCE = new GroupSet();
        }
        return INSTANCE;
    }

    private Set<GroupType> wrappedSet = new HashSet<>();

    protected GroupSet(){}



    @Override
    public int size() {
        return wrappedSet.size();
    }

    @Override
    public boolean isEmpty() {
        return wrappedSet.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return wrappedSet.contains(o);
    }

    @Override
    public Iterator<GroupType> iterator() {
        return wrappedSet.iterator();
    }

    @Override
    public Object[] toArray() {
        return this.wrappedSet.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return wrappedSet.toArray(a);
    }

    @Override
    public boolean add(GroupType groupType) {
        return wrappedSet.add(groupType);
    }

    @Override
    public boolean remove(Object o) {
        return wrappedSet.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return wrappedSet.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends GroupType> c) {
        return wrappedSet.addAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        this.wrappedSet.clear();
    }
}
