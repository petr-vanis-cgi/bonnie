package com.cgi.hexagon.communicationplugin;

import com.cgi.hexagon.businessrules.Status;

public record SendRequest (
        String shopOrderId,
        Status status,
        String trackingNr,
        String metadata
) {

    public SendRequest(String shopOrderId, Status status) {
        this(shopOrderId, status, null, null);
    }
    public SendRequest(String shopOrderId, Status status, String metadata) {
        this(shopOrderId, status, null, metadata);
    }

}
