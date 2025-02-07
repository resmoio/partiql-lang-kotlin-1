/*
 * Copyright 2019 Amazon.com, Inc. or its affiliates.  All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 *  You may not use this file except in compliance with the License.
 * A copy of the License is located at:
 *
 *      http://aws.amazon.com/apache2.0/
 *
 *  or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific
 *  language governing permissions and limitations under the License.
 */

package org.partiql.cli

import java.util.concurrent.TimeUnit

fun <T> timeIt(block: () -> T): Long {
    val start = System.nanoTime()
    block()
    val end = System.nanoTime()

    return TimeUnit.MILLISECONDS.convert(end - start, TimeUnit.NANOSECONDS)
}
