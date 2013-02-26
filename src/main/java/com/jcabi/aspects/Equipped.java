/**
 * Copyright (c) 2012-2013, JCabi.com
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met: 1) Redistributions of source code must retain the above
 * copyright notice, this list of conditions and the following
 * disclaimer. 2) Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following
 * disclaimer in the documentation and/or other materials provided
 * with the distribution. 3) Neither the name of the jcabi.com nor
 * the names of its contributors may be used to endorse or promote
 * products derived from this software without specific prior written
 * permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT
 * NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL
 * THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.jcabi.aspects;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Equips a class with three methods {@code hashCode()}, {@code equals()},
 * and {@code toString()}.
 *
 * <p>For example:
 *
 * <pre> &#64;Equipped
 * public class Foo {
 *   private final Bar bar;
 *   private final Sample sample;
 * }</pre>
 *
 * <p>Is equivalent to:
 *
 * <pre> public class Foo {
 *   private final Bar bar;
 *   private final Sample sample;
 *   &#64;Override
 *   public String toString() {
 *     return String.format("bar=[%s], sample=[%s]", bar, sample);
 *   }
 *   &#64;Override
 *   public int hashCode() {
 *     return this.bar.hashCode() + this.sample.hashCode();
 *   }
 *   &#64;Override
 *   public boolean equals(final Object obj) {
 *     boolean equals;
 *     if (this == obj) {
 *        equals = true;
 *     } else if (obj instanceof Foo) {
 *        final Foo foo = Foo.class.cast(obj);
 *        equals = foo.bar.equals(this.bar)
 *          &amp;&amp; foo.sample.equals(this.sample);
 *     } else {
 *       equals = false;
 *     }
 *     return equals;
 *   }
 * }</pre>
 *
 * @author Yegor Bugayenko (yegor@tpc2.com)
 * @version $Id$
 * @since 0.7.8
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Equipped {
}