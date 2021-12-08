/*
 * Copyright 2015, The Querydsl Team (http://www.querydsl.com/team)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.querydsl.core.types.dsl;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.Calendar;

import com.querydsl.core.DateConstant;

import org.junit.Test;

public class ComparableExpressionTest {

    private StringPath strPath = new StringPath("str");


    @Test
    public void between_start_given() {
        assertEquals(strPath.goe("A"), strPath.between("A", null));
    }

    @Test
    public void between_end_given() {
        assertEquals(strPath.loe("Z"), strPath.between(null, "Z"));
    }

    @Test

    public void min_max_test() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.MONTH, 0);
        cal.set(Calendar.YEAR,  2000);

        DateExpression<Date> date = DateConstant.create(cal.getTime());
        Calendar cal2 = Calendar.getInstance();
        cal2.set(Calendar.DAY_OF_MONTH, 1);
        cal2.set(Calendar.MONTH, 9);
        cal2.set(Calendar.YEAR,  2000);

        DateExpression<Date> date2 = DateConstant.create(cal2.getTime());
        System.out.println(ComparableExpressionBase.max(date, date2));
        System.out.println(ComparableExpressionBase.min(date, date2));
        assertEquals(ComparableExpressionBase.max(date, date2).toString(), "max("+date.toString()+","+date2.toString()+")");
        assertEquals(ComparableExpressionBase.min(date, date2).toString(), "min("+date.toString()+","+date2.toString()+")");

    }

}
