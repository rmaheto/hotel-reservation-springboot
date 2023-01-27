package com.codemaniac.hotelsystem.services;

import com.codemaniac.hotelsystem.entities.Rate;

import java.util.List;

public interface RateService {
    public Rate getRate(long rateId);
    public List<Rate> getAllRates();
    public Rate createRate(Rate rate);
    public Rate updateRate(long rateId, Rate rate);
    public void deleteRate(long rateId);
}
