package eu.chargetime.ocpp.model.test;

import eu.chargetime.ocpp.model.core.RemoteStartStopStatus;
import eu.chargetime.ocpp.model.core.RemoteStartTransactionConfirmation;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/*
 * ChargeTime.eu - Java-OCA-OCPP
 *
 * MIT License
 *
 * Copyright (C) 2016-2018 Thomas Volden <tv@chargetime.eu>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
public class RemoteStartTransactionConfirmationTest {
    RemoteStartTransactionConfirmation confirmation;

    @Before
    public void setUp() throws Exception {
        confirmation = new RemoteStartTransactionConfirmation();
    }

    @Test
    public void setStatus_remoteStartStopStatus_statusIsSet() throws Exception {
        // Given
        RemoteStartStopStatus remoteStartStopStatus = RemoteStartStopStatus.Accepted;

        // When
        confirmation.setStatus(remoteStartStopStatus);

        // Then
        assertThat(confirmation.objStatus(), equalTo(remoteStartStopStatus));
    }

    @Test
    public void validate_returnFalse() {
        // When
        boolean isValid = confirmation.validate();

        // Then
        assertThat(isValid, is(false));
    }

    @Test
    public void validate_statusIsSet_returnTrue() throws Exception {
        // Given
        confirmation.setStatus(RemoteStartStopStatus.Accepted);

        // When
        boolean isValid = confirmation.validate();

        // Then
        assertThat(isValid, is(true));
    }
}