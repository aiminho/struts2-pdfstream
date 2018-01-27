/*
 * Copyright 2014-2018 Aleksandr Mashchenko.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.amashchenko.struts2.pdfstream;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletResponse;

/**
 * Tests for SimpleServletResponseWrapper.
 * 
 * @author Aleksandr Mashchenko
 * 
 */
public class SimpleServletResponseWrapperTest {
    /**
     * Tests writing to writer.
     * 
     * @throws Exception
     */
    @Test
    public void testWritingToWriter() throws Exception {
        MockHttpServletResponse response = new MockHttpServletResponse();
        SimpleServletResponseWrapper responseWrapper = new SimpleServletResponseWrapper(
                        response);

        Assert.assertNotNull(responseWrapper);

        final String expected = "Testing wrapper. А а Б б В в Г г Д д. &#x1F030;&#x1F031;&#x1F032;";

        // write to writer
        responseWrapper.getWriter().write(expected);

        final String actual = responseWrapper.toString();

        Assert.assertEquals(expected, actual);
    }

    /**
     * Tests writing to output stream.
     * 
     * @throws Exception
     */
    @Test
    public void testWritingToOutputStream() throws Exception {
        MockHttpServletResponse response = new MockHttpServletResponse();
        SimpleServletResponseWrapper responseWrapper = new SimpleServletResponseWrapper(
                        response);

        Assert.assertNotNull(responseWrapper);

        final String expected = "Testing wrapper. А а Б б В в Г г Д д. &#x1F030;&#x1F031;&#x1F032;";

        // write to output stream
        responseWrapper.getOutputStream().write(expected.getBytes());

        final String actual = responseWrapper.toString();

        Assert.assertEquals(expected, actual);
    }
}
