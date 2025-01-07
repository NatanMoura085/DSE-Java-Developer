package org.example.decoupleCode.adapter;

import org.example.decoupleCode.ThirdPartyLibrary.ThirdPartyService;
import org.example.decoupleCode.port.DataFetcher;

public class ThirdPartyServiceAdapter implements DataFetcher {
    private ThirdPartyService service;

    public ThirdPartyServiceAdapter(ThirdPartyService service) {
        this.service = service;
    }

    @Override
    public void fetchData() {
       service.fetchData();
    }

    @Override
    public String toString() {
        return "ThirdPartyServiceAdapter{" +
                "service=" + service +
                '}';
    }
}
