package org.example.decoupleCode;

import org.example.decoupleCode.ThirdPartyLibrary.ThirdPartyService;
import org.example.decoupleCode.adapter.ThirdPartyServiceAdapter;
import org.example.decoupleCode.port.DataFetcher;

public class Main {
    public static void main(String[] args) {
        DataFetcher dataFetcher = new ThirdPartyServiceAdapter(new ThirdPartyService());
        dataFetcher.fetchData();  // Usando o Adapter
    }
}
