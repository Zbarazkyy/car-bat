package com.bat.car.service.bet;

import com.bat.car.model.client.request.SetBetRequest;
import com.bat.car.model.client.request.TotalInfoRequest;
import com.bat.car.model.client.response.TotalInfoResponse;

public interface BetService {
    void setBet(SetBetRequest request);

    TotalInfoResponse getTotalBet(TotalInfoRequest request);
}
