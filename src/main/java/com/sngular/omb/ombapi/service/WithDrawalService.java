package com.sngular.omb.ombapi.service;

import com.sngular.omb.ombapi.exception.ExceptionFormat;
import com.sngular.omb.ombapi.model.request.WithdrawalRequest;
import com.sngular.omb.ombapi.model.response.WithdrawalResponse;

public interface WithDrawalService {

    WithdrawalResponse withdrawAmount(String accountId, WithdrawalRequest withdrawReq) throws ExceptionFormat;
}
